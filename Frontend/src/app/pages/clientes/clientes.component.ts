import { Component } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { ICliente } from 'src/app/interfaces/cliente';
import { ClienteService } from 'src/app/services/cliente.service';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-clientes',
  templateUrl: './clientes.component.html',
  styleUrls: ['./clientes.component.css']
})
export class ClientesComponent {
  clientes: ICliente[] = [];
  constructor(private clienteService: ClienteService, private route: ActivatedRoute, private router: Router) {  }

  ngOnInit() {
    this.clienteService.buscarTodosClientes().subscribe((result: ICliente[]) => {
      this.clientes = result;
    });
    if (Number(this.route.snapshot.paramMap.get('cpf'))) {
      this.deletarCliente();
    }
  }

  deletarCliente() {
    Swal.fire({
      title: 'Deletar cliente',
      text: "Deseja mesmo deletar o cliente?",
      icon: 'warning',
      showCancelButton: true,
      confirmButtonColor: '#3085d6',
      cancelButtonColor: '#d33',
      confirmButtonText: 'Sim',
      cancelButtonText: 'Não'
    }).then((result) => {
      if (result.isConfirmed) {
        this.clienteService.deletarCliente(Number(this.route.snapshot.paramMap.get('cpf'))).subscribe(result => {}, error => {
          Swal.fire({
            title: 'Erro',
            text: error(error),
            icon: 'error',
            confirmButtonText: 'Ok'
          });
        });
      }
    }).then(() => {
      this.router.navigateByUrl('/clientes')
    });
  }
}
