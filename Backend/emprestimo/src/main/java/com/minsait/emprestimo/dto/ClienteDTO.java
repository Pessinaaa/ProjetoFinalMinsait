package com.minsait.emprestimo.dto;

import com.minsait.emprestimo.entity.Cliente;

public class ClienteDTO {
	
	// Atributos
	private String nome;
	private Long telefone;
	private String endereco; // Rua e número
	private Integer CEP;
	private Double rendimentoMensal;
	
	//Métodos
	
	public ClienteDTO() {	}

	public ClienteDTO(String nome, Long telefone, String endereco, Integer cep, Double rendimentoMensal) {
		this.nome = nome;
		this.telefone = telefone;
		this.endereco = endereco;
		this.CEP = cep;
		this.rendimentoMensal = rendimentoMensal;
	}

	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}

	public Long getTelefone() {
		return telefone;
	}
	public void setTelefone(Long telefone) {
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
	
	//Recebe um cliente e retorna um clienteDTO sem os dados sensíveis
	public static ClienteDTO retornaClienteDTO(Cliente cliente) {
		return new ClienteDTO(cliente.getNome(), cliente.getTelefone(), cliente.getEndereco(), cliente.getCEP(), cliente.getRendimentoMensal());
	}
	
	//Recebe um clieteDTO e retorna um cliente que vai receber os dados sensíveis depois
	public static Cliente retornaCliente(ClienteDTO clienteDTO) {
		return new Cliente(clienteDTO.getNome(), clienteDTO.getTelefone(), clienteDTO.getEndereco(), clienteDTO.getCEP(), clienteDTO.getRendimentoMensal());
	}
}
