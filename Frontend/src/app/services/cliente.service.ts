import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { environment } from 'src/environment/environment';
import { ICliente } from '../interfaces/cliente';

@Injectable({
  providedIn: 'root'
})
export class ClienteService {
  endpoint = 'clientes';
  api = environment.api;
  constructor(private http: HttpClient) { }

  buscarTodosClientes() {
    return this.http.get<ICliente[]>(`${this.api}/${this.endpoint}`);
  }

  buscarClientePeloCPF(cpf: number) {
    return this.http.get(`${this.api}/${this.endpoint}/${cpf}`);
  }

  cadastrarCliente(cliente: ICliente) {
    return this.http.post(`${this.api}/${this.endpoint}`, cliente);
  }

  alterarCliente(cpf:number, cliente: ICliente) {
    return this.http.put(`${this.api}/${this.endpoint}/${cpf}`, cliente);
  }

  deletarCliente(cpf: number) {
    return this.http.delete(`${this.api}/${this.endpoint}/${cpf}`);
  }
}
