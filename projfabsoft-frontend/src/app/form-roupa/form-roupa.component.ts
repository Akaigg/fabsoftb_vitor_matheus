import { Component } from '@angular/core';
import {Roupa} from '../model/roupa';
import { RoupaService} from '../service/roupa.service';
import { HttpClientModule } from '@angular/common/http';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { Router, ActivatedRoute, ParamMap } from '@angular/router';

@Component({
  selector: 'app-form-roupa',
  imports: [HttpClientModule, CommonModule, FormsModule],
  templateUrl: './form-roupa.component.html',
  styleUrl: './form-roupa.component.css',
  providers: [RoupaService, Router]
})
export class FormRoupaComponent {
  roupa: Roupa = new Roupa();
  
    constructor(
      private roupaService: RoupaService,
      private router: Router,
      private activedRouter: ActivatedRoute
    ){
        const id = this.activedRouter.snapshot.paramMap.get('id');
  
        if(id) {
          this.roupaService.getRoupaById(id).subscribe(roupa => {
            this.roupa = roupa;
          })
        }
  
    }
  
    salvar(){
      this.roupaService.saveRoupa(this.roupa)
       .subscribe(resultado => {
        this.router.navigate(['roupas'])
       });
    }

}
