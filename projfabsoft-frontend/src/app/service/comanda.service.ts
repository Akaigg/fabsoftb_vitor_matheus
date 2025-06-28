import { Injectable } from '@angular/core';
import { Comanda } from '../model/comanda';
import { HttpClient } from '@angular/common/http';


@Injectable({
  providedIn: 'root'
})
export class ComandaService {
  apiURL = "http://localhost:8080/api/v1/Comandas";
  
  constructor(private http:HttpClient) { }

  getComandas(){
    return this.http.get<Comanda[]>(this.apiURL);
  }

  saveComanda(Comanda:Comanda){
    if(Comanda.id){
      return this.http.put(this.apiURL +'/'+ Comanda.id,Comanda);
    }
    return this.http.post(this.apiURL, Comanda); 
  }

  getComandaById(id:any){
    return this.http.get<Comanda>(this.apiURL + '/' + id);
  }
  excluirComanda(id: any){
  return this.http.delete<Comanda>(this.apiURL + '/' + id);
  }
}