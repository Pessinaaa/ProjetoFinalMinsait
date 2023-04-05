package com.minsait.emprestimo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Cliente {
	
	//Atributos
	
	@Id
	private String CPF; // CPF definido como string pois podem haver CPFs com X
	
	private String nome;
	private Integer telefone;
	private String endereco; // Rua e número
	private Integer CEP;
	private Double rendimentoMensal;
	
	//Métodos
	
	public Cliente() {	}

	public Cliente(String cpf, String nome, Integer telefone, String endereco, Integer cep, Double rendimentoMensal) {
		CPF = cpf;
		this.nome = nome;
		this.telefone = telefone;
		this.endereco = endereco;
		CEP = cep;
		this.rendimentoMensal = rendimentoMensal;
	}

	public String getCPF() {
		return CPF;
	}
	public void setCPF(String cPF) {
		CPF = cPF;
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
	public void setCEP(Integer cEP) {
		CEP = cEP;
	}

	public Double getRendimentoMensal() {
		return rendimentoMensal;
	}
	public void setRendimentoMensal(Double rendimentoMensal) {
		this.rendimentoMensal = rendimentoMensal;
	}
	
	
}
