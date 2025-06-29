import { Component } from '@angular/core';
import {Pagamento} from '../model/pagamento';
import { PagamentoService} from '../service/pagamento.service';
import { HttpClientModule } from '@angular/common/http';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { Router, ActivatedRoute, ParamMap } from '@angular/router';

@Component({
  selector: 'app-form-pagamento',
  imports: [HttpClientModule, CommonModule, FormsModule],
  templateUrl: './form-pagamento.component.html',
  styleUrls: ['./form-pagamento.component.css'],
  providers: [PagamentoService, Router]
})
export class FormPagamentoComponent {
  pagamento: Pagamento = new Pagamento();
  
    constructor(
      private pagamentoService: PagamentoService,
      private router: Router,
      private activedRouter: ActivatedRoute
    ){
        const id = this.activedRouter.snapshot.paramMap.get('id');
  
        if(id) {
          this.pagamentoService.getPagamentoById(id).subscribe(pagamento => {
            this.pagamento = pagamento;
          })
        }
  
    }
  
    salvar(){
      this.pagamentoService.savePagamento(this.pagamento)
       .subscribe(resultado => {
        this.router.navigate(['pagamentos'])
       });
    }

}
