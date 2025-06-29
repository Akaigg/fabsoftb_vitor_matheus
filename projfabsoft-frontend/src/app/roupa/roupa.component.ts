import { Component, ElementRef, ViewChild } from '@angular/core';
import { Roupa } from '../model/roupa';
import { RoupaService } from '../service/roupa.service';
import { HttpClientModule } from '@angular/common/http';
import { CommonModule } from '@angular/common';
import { Router } from '@angular/router';
import * as bootstrap from 'bootstrap';

@Component({
  selector: 'app-Roupa',
  imports: [HttpClientModule, CommonModule],
  templateUrl: './roupa.component.html',
  styleUrl: './roupa.component.css',
  providers: [RoupaService, Router]
})
export class RoupaComponent {
  listaRoupas: Roupa[] = [];

  @ViewChild('myModal') modalElement!: ElementRef;
  private modal!: bootstrap.Modal;
  private RoupaSelecionado!: Roupa;

  constructor(
    private RoupaService: RoupaService, 
    private router: Router
  ) {}

  novo() {
    this.router.navigate(['Roupas/novo']);
  }

  ngOnInit() {
    console.log("Carregando Roupas...");
    this.RoupaService.getRoupas().subscribe(Roupas => {
      this.listaRoupas = Roupas;
    });
  }

  alterar(Roupa: Roupa) {
    this.router.navigate(['Roupas/alterar', Roupa.id]);
  }

  abrirConfirmacao(Roupa: Roupa) {
    this.RoupaSelecionado = Roupa;
    this.modal = new bootstrap.Modal(this.modalElement.nativeElement);
    this.modal.show();
  }

  fecharConfirmacao() {
    this.modal.hide();
  }

  confirmarExclusao() {
    this.RoupaService.excluirRoupa(this.RoupaSelecionado.id).subscribe(
      () => {
        this.fecharConfirmacao();
        this.RoupaService.getRoupas().subscribe(
          Roupas => {
            this.listaRoupas = Roupas;
          }
        );
      },
      error => {
        console.error('Erro ao excluir Roupa:', error);
      }
    );
  }

}
