import { Component, ElementRef, ViewChild } from '@angular/core';
import { Pagamento } from '../model/pagamento';
import { PagamentoService } from '../service/pagamento.service';
import { HttpClientModule } from '@angular/common/http';
import { CommonModule } from '@angular/common';
import { Router } from '@angular/router';
import * as bootstrap from 'bootstrap';

@Component({
  selector: 'app-Pagamento',
  imports: [HttpClientModule, CommonModule],
  templateUrl: './pagamento.component.html',
  styleUrl: './pagamento.component.css',
  providers: [PagamentoService, Router]
})
export class PagamentoComponent {
  listaPagamentos: Pagamento[] = [];

  @ViewChild('myModal') modalElement!: ElementRef;
  private modal!: bootstrap.Modal;
  private PagamentoSelecionado!: Pagamento;

  constructor(
    private PagamentoService: PagamentoService, 
    private router: Router
  ) {}

  novo() {
    this.router.navigate(['Pagamentos/novo']);
  }

  ngOnInit() {
    console.log("Carregando Pagamentos...");
    this.PagamentoService.getPagamentos().subscribe(Pagamentos => {
      this.listaPagamentos = Pagamentos;
    });
  }

  alterar(Pagamento: Pagamento) {
    this.router.navigate(['Pagamentos/alterar', Pagamento.id]);
  }

  abrirConfirmacao(Pagamento: Pagamento) {
    this.PagamentoSelecionado = Pagamento;
    this.modal = new bootstrap.Modal(this.modalElement.nativeElement);
    this.modal.show();
  }

  fecharConfirmacao() {
    this.modal.hide();
  }

  confirmarExclusao() {
    this.PagamentoService.excluirPagamento(this.PagamentoSelecionado.id).subscribe(
      () => {
        this.fecharConfirmacao();
        this.PagamentoService.getPagamentos().subscribe(
          Pagamentos => {
            this.listaPagamentos = Pagamentos;
          }
        );
      },
      error => {
        console.error('Erro ao excluir Pagamento:', error);
      }
    );
  }

}
