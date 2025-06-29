import { Component } from '@angular/core';
import {Comanda} from '../model/comanda';
import { ComandaService} from '../service/comanda.service';
import { HttpClientModule } from '@angular/common/http';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { Router, ActivatedRoute, ParamMap } from '@angular/router';

@Component({
  selector: 'app-form-comanda',
  imports: [HttpClientModule, CommonModule, FormsModule],
  templateUrl: './form-comanda.component.html',
  styleUrl: './form-comanda.component.css',
  providers: [ComandaService, Router]
})
export class FormComandaComponent {
  comanda: Comanda = new Comanda();
  
    constructor(
      private comandaService: ComandaService,
      private router: Router,
      private activedRouter: ActivatedRoute
    ){
        const id = this.activedRouter.snapshot.paramMap.get('id');
  
        if(id) {
          this.comandaService.getComandaById(id).subscribe(comanda => {
            this.comanda = comanda;
          })
        }
  
    }
  
    salvar(){
      this.comandaService.saveComanda(this.comanda)
       .subscribe(resultado => {
        this.router.navigate(['comandas'])
       });
    }

}
