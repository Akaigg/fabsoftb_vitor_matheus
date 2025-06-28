import { Injectable } from '@angular/core';
import { Roupa } from '../model/roupa';
import { HttpClient } from '@angular/common/http';


@Injectable({
  providedIn: 'root'
})
export class RoupaService {
  apiURL = "http://localhost:8080/api/v1/Roupas";
  
  constructor(private http:HttpClient) { }

  getRoupas(){
    return this.http.get<Roupa[]>(this.apiURL);
  }

  saveRoupa(Roupa:Roupa){
    if(Roupa.id){
      return this.http.put(this.apiURL +'/'+ Roupa.id,Roupa);
    }
    return this.http.post(this.apiURL, Roupa); 
  }

  getRoupaById(id:any){
    return this.http.get<Roupa>(this.apiURL + '/' + id);
  }
  excluirRoupa(id: any){
  return this.http.delete<Roupa>(this.apiURL + '/' + id);
  }
}
