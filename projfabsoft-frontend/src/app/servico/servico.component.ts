import { Component, ElementRef } from '@angular/core';
import { Servico } from '../model/servico';
import { ServicoService } from '../service/servico.service';
import { HttpClientModule } from '@angular/common/http';
import { CommonModule } from '@angular/common';
import { Router } from '@angular/router';
import * as bootstrap from 'bootstrap';

@Component({
  selector: 'app-Servico',
  imports: [HttpClientModule, CommonModule],
  templateUrl: './Servico.component.html',
  styleUrl: './Servico.component.css',
  providers: [ServicoService, Router]
})
export class ServicoComponent {
  listaServicos: Servico[] = [];

  @ViewChild('myModal') modalElement!: ElementRef;
  private modal!: bootstrap.Modal;
  private ServicoSelecionado!: Servico;

  constructor(
    private ServicoService: ServicoService, 
    private router: Router
  ) {}

  novo() {
    this.router.navigate(['Servicos/novo']);
  }

  ngOnInit() {
    console.log("Carregando Servicos...");
    this.ServicoService.getServicos().subscribe(Servicos => {
      this.listaServicos = Servicos;
    });
  }

  alterar(Servico: Servico) {
    this.router.navigate(['Servicos/alterar', Servico.id]);
  }

  abrirConfirmacao(Servico: Servico) {
    this.ServicoSelecionado = Servico;
    this.modal = new bootstrap.Modal(this.modalElement.nativeElement);
    this.modal.show();
  }

  fecharConfirmacao() {
    this.modal.hide();
  }

  confirmarExclusao() {
    this.ServicoService.excluirServico(this.ServicoSelecionado.id).subscribe(
      () => {
        this.fecharConfirmacao();
        this.ServicoService.getServicos().subscribe(
          Servicos => {
            this.listaServicos = Servicos;
          }
        );
      },
      error => {
        console.error('Erro ao excluir Servico:', error);
      }
    );
  }

}
