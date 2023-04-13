import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { environment } from 'src/environment/environment';
import { IEmprestimo } from '../interfaces/emprestimo';

@Injectable({
  providedIn: 'root'
})
export class EmprestimoService {
  endpoint = 'emprestimos';
  api = `${environment.api}/clientes`;
  constructor(private http: HttpClient) { }

  buscarTodosEmprestimosDoCliente(cpf: number) {
    return this.http.get<IEmprestimo[]>(`${this.api}/${cpf}/${this.endpoint}`);
  }

  buscarEmprestimoPeloId(cpf: number, id: number) {
    return this.http.get(`${this.api}/}/${cpf}/${this.endpoint}/${id}`);
  }

  cadastrarEmprestimo(cpf: number, emprestimo: IEmprestimo) {
    return this.http.post(`${this.api}/${cpf}/${this.endpoint}`, emprestimo);
  }

  deletarEmprestimo(cpf: number, id: number) {
    return this.http.delete(`${this.api}/${cpf}/${this.endpoint}/${id}`);
  }
}
