import { Component } from '@angular/core';
import { FormGroup, FormControl, Validators } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { IEmprestimo } from 'src/app/interfaces/emprestimo';
import { EmprestimoService } from 'src/app/services/emprestimo.service';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-cadastrar-emprestimo',
  templateUrl: './cadastrar-emprestimo.component.html',
  styleUrls: ['./cadastrar-emprestimo.component.css']
})
export class CadastrarEmprestimoComponent {
  constructor(private emprestimoService: EmprestimoService, private route: ActivatedRoute, private router: Router) { }

  cpf = Number(this.route.snapshot.paramMap.get('cpf'));
  emprestimoForm = new FormGroup({
    cpfcliente: new FormControl(this.cpf, Validators.required),
    valorInicial: new FormControl(0, Validators.required),
    relacionamento: new FormControl("", Validators.required),
    dataInicial: new FormControl(0, Validators.required),
    dataFinal: new FormControl(0, Validators.required)
  });
  Relacionamento: any = [
    'BRONZE',
    'PRATA',
    'OURO'
  ];

  cadastrarEmprestimo() {
    const emprestimo: IEmprestimo = this.emprestimoForm.value as IEmprestimo;
    this.emprestimoService.cadastrarEmprestimo(this.cpf, emprestimo).subscribe(result => {
      Swal.fire({
        title: 'Sucesso',
        text: 'Empréstimo aprovado!',
        icon: 'success',
        confirmButtonText: 'Ok'
      }).then(() => {
        this.router.navigateByUrl(`/emprestimos/${this.cpf}`);
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

  relacionamentoSelect(e: any) {
    this.relacionamento?.setValue(e.target.value, {
      onlySelf: true,
    });
  }

  get relacionamento() {
    return this.emprestimoForm.get('relacionamento');
  }
}
