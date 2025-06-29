import { Component, ElementRef, ViewChild } from '@angular/core';
import { Servico } from '../model/servico';
import { ServicoService } from '../service/servico.service';
import { HttpClientModule } from '@angular/common/http';
import { CommonModule } from '@angular/common';
import { Router } from '@angular/router';
import * as bootstrap from 'bootstrap';

@Component({
  selector: 'app-servico',
  imports: [HttpClientModule, CommonModule],
  templateUrl: './servico.component.html',
  styleUrls: ['./servico.component.css'],
  providers: [ServicoService, Router]
})
export class ServicoComponent {
  listaServicos: Servico[] = [];

  @ViewChild('myModal') modalElement!: ElementRef;
  private modal!: bootstrap.Modal;
  private servicoSelecionado!: Servico;

  constructor(
    private servicoService: ServicoService, 
    private router: Router
  ) {}

  novo() {
    this.router.navigate(['servico/novo']);
  }

  ngOnInit() {
    console.log("Carregando Serviços...");
    this.servicoService.getServicos().subscribe(servicos => {
      this.listaServicos = servicos;
    });
  }

  alterar(servico: Servico) {
    this.router.navigate(['servico/alterar', servico.id]);  
  }

  abrirConfirmacao(servico: Servico) {
    this.servicoSelecionado = servico;
    this.modal = new bootstrap.Modal(this.modalElement.nativeElement);
    this.modal.show();
  }

  fecharConfirmacao() {
    this.modal.hide();
  }

  confirmarExclusao() {
    this.servicoService.excluirServico(this.servicoSelecionado.id).subscribe(
      () => {
        this.fecharConfirmacao();
        this.servicoService.getServicos().subscribe(
          servicos => {
            this.listaServicos = servicos;
          }
        );
      },
      error => {
        console.error('Erro ao excluir Serviço:', error);
      }
    );
  }
}
