package com.minsait.emprestimo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Cliente {
	
	//Atributos
	
	@Id
	private Long CPF;
	
	private String nome;
	private Integer telefone;
	private String endereco; // Rua e número
	private Integer CEP;
	private Double rendimentoMensal;
	
	//Métodos
	
	public Cliente() {	}

	public Cliente(Long cpf, String nome, Integer telefone, String endereco, Integer cep, Double rendimentoMensal) {
		this.CPF = cpf;
		this.nome = nome;
		this.telefone = telefone;
		this.endereco = endereco;
		this.CEP = cep;
		this.rendimentoMensal = rendimentoMensal;
	}
	
	public Cliente(String nome, Integer telefone, String endereco, Integer cep, Double rendimentoMensal) {
		this.nome = nome;
		this.telefone = telefone;
		this.endereco = endereco;
		this.CEP = cep;
		this.rendimentoMensal = rendimentoMensal;
	}

	public Long getCPF() {
		return CPF;
	}
	public void setCPF(Long cpf) {
		CPF = cpf;
	}

	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}

	public Integer getTelefone() {
		return telefone;
	}
	public void setTelefone(Integer telefone) {
		this.telefone = telefone;
	}

	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public Integer getCEP() {
		return CEP;
	}
	public void setCEP(Integer cep) {
		this.CEP = cep;
	}

	public Double getRendimentoMensal() {
		return rendimentoMensal;
	}
	public void setRendimentoMensal(Double rendimentoMensal) {
		this.rendimentoMensal = rendimentoMensal;
	}
	
	
}
