import { Component } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { IEmprestimo } from 'src/app/interfaces/emprestimo';
import { EmprestimoService } from 'src/app/services/emprestimo.service';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-emprestimos',
  templateUrl: './emprestimos.component.html',
  styleUrls: ['./emprestimos.component.css']
})
export class EmprestimosComponent {
  cpf!: number;
  emprestimos: IEmprestimo[] = [];
  constructor(private emprestimoService: EmprestimoService, private route: ActivatedRoute, private router: Router) {  }

  ngOnInit() {
    this.cpf = Number(this.route.snapshot.paramMap.get('cpf'));
    this.emprestimoService.buscarTodosEmprestimosDoCliente(this.cpf).subscribe((result: IEmprestimo[]) => {
      this.cpf = Number(this.route.snapshot.paramMap.get('cpf'));
      this.emprestimos = result;
    });
    if (Number(this.route.snapshot.paramMap.get('id'))) {
      this.deletarEmprestimo();
    }
  }

  deletarEmprestimo() {
    Swal.fire({
      title: 'Deletar empréstimo',
      text: "Deseja mesmo deletar o empréstimo?",
      icon: 'warning',
      showCancelButton: true,
      confirmButtonColor: '#3085d6',
      cancelButtonColor: '#d33',
      confirmButtonText: 'Sim',
      cancelButtonText: 'Não'
    }).then((result) => {
      if (result.isConfirmed) {
        this.emprestimoService.deletarEmprestimo(Number(this.route.snapshot.paramMap.get('cpf')), Number(this.route.snapshot.paramMap.get('id'))).subscribe(result => {}, error => {
          Swal.fire({
            title: 'Erro',
            text: error(error),
            icon: 'error',
            confirmButtonText: 'Ok'
          });
        });
      }
    }).then(() => {
      this.router.navigateByUrl(`/emprestimos/${this.cpf}`)
    });
  }
}
