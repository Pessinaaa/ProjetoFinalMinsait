import { Component } from '@angular/core';
import { ICliente } from 'src/app/interfaces/cliente';
import { ClienteService } from 'src/app/services/cliente.service';

@Component({
  selector: 'app-clientes',
  templateUrl: './clientes.component.html',
  styleUrls: ['./clientes.component.css']
})
export class ClientesComponent {
  clientes: ICliente[] = [];
  constructor(private clienteService: ClienteService) {  }

  ngOnInit() {
    this.clienteService.buscarTodosClientes().subscribe((result: ICliente[]) => {
      this.clientes = result;
    });
  }
}
