import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { HttpClientModule } from '@angular/common/http';
import { ReactiveFormsModule } from '@angular/forms';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { NavbarComponent } from './components/navbar/navbar.component';
import { HomeComponent } from './pages/home/home.component';
import { SobreComponent } from './pages/sobre/sobre.component';
import { ClientesComponent } from './pages/clientes/clientes.component';
import { CadastrarAtualizarClienteComponent } from './pages/cadastrar-atualizar-cliente/cadastrar-atualizar-cliente.component';
import { FormInputComponent } from './components/form-input/form-input.component';
import { EmprestimosComponent } from './pages/emprestimos/emprestimos.component';
import { CadastrarEmprestimoComponent } from './pages/cadastrar-emprestimo/cadastrar-emprestimo.component';

@NgModule({
  declarations: [
    AppComponent,
    NavbarComponent,
    HomeComponent,
    SobreComponent,
    ClientesComponent,
    CadastrarAtualizarClienteComponent,
    FormInputComponent,
    EmprestimosComponent,
    CadastrarEmprestimoComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    ReactiveFormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
