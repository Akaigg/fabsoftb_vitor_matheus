import { Component, OnInit } from '@angular/core';
import { Roupa } from '../model/roupa';
import { RoupaService } from '../service/roupa.service';
import { ServicoService } from '../service/servico.service';
import { Servico } from '../model/servico';
import { HttpClientModule } from '@angular/common/http';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { Router, ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-form-roupa',
  standalone: true,
  imports: [HttpClientModule, CommonModule, FormsModule],
  templateUrl: './form-roupa.component.html',
  styleUrls: ['./form-roupa.component.css'],
  providers: [RoupaService, ServicoService]
})
export class FormRoupaComponent implements OnInit {
  roupa: Roupa = new Roupa();
  listaServicos: Servico[] = [];

  constructor(
    private roupaService: RoupaService,
    private servicoService: ServicoService,
    private router: Router,
    private activatedRoute: ActivatedRoute
  ) {}

  ngOnInit(): void {
    this.servicoService.getServicos().subscribe(servicos => {
      this.listaServicos = servicos;
    });

    const id = this.activatedRoute.snapshot.paramMap.get('id');
    if (id) {
      this.roupaService.getRoupaById(id).subscribe(roupa => {
        this.roupa = roupa;
      });
    }
  }

  salvar() {
    this.roupaService.saveRoupa(this.roupa).subscribe(() => {
      this.router.navigate(['roupa']);
    });
  }

  atualizarPreco() {
    if (this.roupa.servico) {
      this.roupa.preco = this.roupa.servico.preco;
    }
  }
}
