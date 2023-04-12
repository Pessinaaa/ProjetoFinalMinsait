import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CadastrarAtualizarClienteComponent } from './cadastrar-atualizar-cliente.component';

describe('CadastrarAtualizarClienteComponent', () => {
  let component: CadastrarAtualizarClienteComponent;
  let fixture: ComponentFixture<CadastrarAtualizarClienteComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ CadastrarAtualizarClienteComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(CadastrarAtualizarClienteComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
