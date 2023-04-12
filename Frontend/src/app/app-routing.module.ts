import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { HomeComponent } from './pages/home/home.component';
import { SobreComponent } from './pages/sobre/sobre.component';
import { ClientesComponent } from './pages/clientes/clientes.component';
import { CadastrarAtualizarClienteComponent } from './pages/cadastrar-atualizar-cliente/cadastrar-atualizar-cliente.component';

const routes: Routes = [
  { path: '', redirectTo: '/home', pathMatch: 'full'}, //Definindo a rota padrão como home
  { path: 'home', component: HomeComponent},
  { path: 'sobre', component: SobreComponent},
  { path: 'clientes', component: ClientesComponent},
  { path: 'clientes/cadastrar', component: CadastrarAtualizarClienteComponent},
  { path: 'clientes/alterar/:cpf', component: CadastrarAtualizarClienteComponent},
  { path: 'clientes/deletar/:cpf', component: ClientesComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
