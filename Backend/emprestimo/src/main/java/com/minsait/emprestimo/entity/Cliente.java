package com.minsait.emprestimo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Entity
public class Cliente {
	//Atributos
	
	@Id
	@NotNull(message="O CPF é obrigatório")
	private Long CPF;
	
	@NotBlank(message="O nome é obrigatório")
	private String nome;
	
	@NotNull(message="O telefone é obrigatório")
	private Integer telefone;
	
	@NotBlank(message="O endereço é obrigatório")
	private String endereco; // Rua e número
	
	@NotNull(message="O CEP é obrigatório")
	private Integer CEP;
	
	@NotNull(message="O rendimento mensal é obrigatório")
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
