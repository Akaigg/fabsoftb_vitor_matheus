import { Injectable } from '@angular/core';
import { Pagamento } from '../model/pagamento';
import { HttpClient } from '@angular/common/http';


@Injectable({
  providedIn: 'root'
})
export class PagamentoService {
  apiURL = "http://localhost:8080/api/v1/Pagamentos";
  
  constructor(private http:HttpClient) { }

  getPagamentos(){
    return this.http.get<Pagamento[]>(this.apiURL);
  }

  savePagamento(Pagamento:Pagamento){
    if(Pagamento.id){
      return this.http.put(this.apiURL +'/'+ Pagamento.id,Pagamento);
    }
    return this.http.post(this.apiURL, Pagamento); 
  }

  getPagamentoById(id:any){
    return this.http.get<Pagamento>(this.apiURL + '/' + id);
  }
  excluirPagamento(id: any){
  return this.http.delete<Pagamento>(this.apiURL + '/' + id);
  }
}