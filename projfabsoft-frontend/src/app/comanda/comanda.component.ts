import { Component, ElementRef, ViewChild } from '@angular/core';
import { Comanda } from '../model/comanda';
import { ComandaService } from '../service/comanda.service';
import { HttpClientModule } from '@angular/common/http';
import { CommonModule } from '@angular/common';
import { Router } from '@angular/router';
import * as bootstrap from 'bootstrap';

@Component({
  selector: 'app-Comanda',
  imports: [HttpClientModule, CommonModule],
  templateUrl: './comanda.component.html',
  styleUrl: './comanda.component.css',
  providers: [ComandaService, Router]
})
export class ComandaComponent {
  listaComandas: Comanda[] = [];

  @ViewChild('myModal') modalElement!: ElementRef;
  private modal!: bootstrap.Modal;
  private ComandaSelecionado!: Comanda;

  constructor(
    private ComandaService: ComandaService, 
    private router: Router
  ) {}

  novo() {
    this.router.navigate(['Comandas/novo']);
  }

  ngOnInit() {
    console.log("Carregando Comandas...");
    this.ComandaService.getComandas().subscribe(Comandas => {
      this.listaComandas = Comandas;
    });
  }

  alterar(Comanda: Comanda) {
    this.router.navigate(['Comandas/alterar', Comanda.id]);
  }

  abrirConfirmacao(Comanda: Comanda) {
    this.ComandaSelecionado = Comanda;
    this.modal = new bootstrap.Modal(this.modalElement.nativeElement);
    this.modal.show();
  }

  fecharConfirmacao() {
    this.modal.hide();
  }

  confirmarExclusao() {
    this.ComandaService.excluirComanda(this.ComandaSelecionado.id).subscribe(
      () => {
        this.fecharConfirmacao();
        this.ComandaService.getComandas().subscribe(
          Comandas => {
            this.listaComandas = Comandas;
          }
        );
      },
      error => {
        console.error('Erro ao excluir Comanda:', error);
      }
    );
  }

}
