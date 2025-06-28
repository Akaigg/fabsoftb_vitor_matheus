import { Injectable } from '@angular/core';
import { Servico } from '../model/servico';
import { HttpClient } from '@angular/common/http';


@Injectable({
  providedIn: 'root'
})
export class ServicoService {
  apiURL = "http://localhost:8080/api/v1/Servicos";
  
  constructor(private http:HttpClient) { }

  getServicos(){
    return this.http.get<Servico[]>(this.apiURL);
  }

  saveServico(Servico:Servico){
    if(Servico.id){
      return this.http.put(this.apiURL +'/'+ Servico.id,Servico);
    }
    return this.http.post(this.apiURL, Servico); 
  }

  getServicoById(id:any){
    return this.http.get<Servico>(this.apiURL + '/' + id);
  }
  excluirServico(id: any){
  return this.http.delete<Servico>(this.apiURL + '/' + id);
  }
}
