import { Injectable } from '@angular/core';
import {Cliente} from '../model/cliente';
@Injectable({
  providedIn: 'root'
})
export class ClienteService {
  getClientes() {
    throw new Error('Method not implemented.');
  }

  constructor() { }
}
