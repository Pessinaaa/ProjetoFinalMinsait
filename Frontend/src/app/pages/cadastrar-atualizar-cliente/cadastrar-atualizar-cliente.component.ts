import { Component } from '@angular/core';
import { FormGroup, FormControl, Validators } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { ICliente } from 'src/app/interfaces/cliente';
import { ClienteService } from 'src/app/services/cliente.service';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-cadastrar-atualizar-cliente',
  templateUrl: './cadastrar-atualizar-cliente.component.html',
  styleUrls: ['./cadastrar-atualizar-cliente.component.css']
})
export class CadastrarAtualizarClienteComponent {
  constructor(private clienteService: ClienteService, private route: ActivatedRoute, private router: Router) { }

  clienteForm!: FormGroup;
  clienteCPF = 0;

  ngOnInit() {
    this.criarFormulario();
    this.clienteCPF = Number(this.route.snapshot.paramMap.get('cpf'));
    if (this.clienteCPF) {
      this.clienteService.buscarClientePeloCPF(this.clienteCPF).subscribe((cliente: ICliente) => {
        this.clienteForm.setValue({
          cpf: cliente.cpf || 0,
          nome: cliente.nome || "",
          telefone: cliente.telefone || 0,
          endereco: cliente.endereco || "",
          cep: cliente.cep || 0,
          rendimentoMensal: cliente.rendimentoMensal || 0
        })
      });
    }
  }

  cadastrarCliente() {
    const cliente: ICliente = this.clienteForm.value as ICliente;
    this.clienteService.cadastrarCliente(cliente).subscribe(result => {
      Swal.fire({
        title: 'Sucesso',
        text: 'Cliente cadastrado',
        icon: 'success',
        confirmButtonText: 'Ok'
      }).then(() => {
        window.location.reload();
        });
    }, error => {
      Swal.fire({
        title: 'Erro',
        text: error(error),
        icon: 'error',
        confirmButtonText: 'Ok'
      });
    });
  }

  alterarCliente() {
    const cliente: ICliente = this.clienteForm.value as ICliente;
    this.clienteService.alterarCliente(this.clienteCPF, cliente).subscribe(result => {
      Swal.fire({
        title: 'Sucesso',
        text: 'Cliente alterado',
        icon: 'success',
        confirmButtonText: 'Ok'
      }).then(() => {
        this.router.navigateByUrl('/clientes');
        });
    }, error => {
      Swal.fire({
        title: 'Erro',
        text: error(error),
        icon: 'error',
        confirmButtonText: 'Ok'
      });
    });
  }

  cadastraOuEdita() {
    if (this.clienteCPF) {
      this.alterarCliente();
    } else {
      this.cadastrarCliente();
    }
  }

  criarFormulario() {
    this.clienteForm = new FormGroup({
      cpf: new FormControl(0, [Validators.required, Validators.pattern('^[0-9]{11}$')]),
      nome: new FormControl("", Validators.required),
      telefone: new FormControl(0, [Validators.required, Validators.pattern('^[0-9]{11}$')]),
      endereco: new FormControl("", Validators.required),
      cep: new FormControl(0, [Validators.required, Validators.pattern('^[0-9]{8}$')]),
      rendimentoMensal: new FormControl(0, Validators.required)
    });
  }
}
