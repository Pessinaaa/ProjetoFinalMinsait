package com.minsait.emprestimo.dto;

import com.minsait.emprestimo.entity.Cliente;

public class ClienteDTO {
	
	// Atributos
	private String nome;
	private Integer telefone;
	private String endereco; // Rua e número
	private Integer CEP;
	
	//Métodos
	
	public ClienteDTO() {	}

	public ClienteDTO(String nome, Integer telefone, String endereco, Integer cep) {
		this.nome = nome;
		this.telefone = telefone;
		this.endereco = endereco;
		CEP = cep;
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
	
	//Recebe um cliente e retorna um clienteDTO sem os dados sensíveis
	public static ClienteDTO retornaClienteDTO(Cliente cliente) {
		return new ClienteDTO(cliente.getNome(), cliente.getTelefone(), cliente.getEndereco(), cliente.getCEP());
	}
	
	//Recebe um clieteDTO e retorna um cliente que vai receber os dados sensíveis depois
	public static Cliente retornaCliente(ClienteDTO clienteDTO) {
		return new Cliente(clienteDTO.getNome(), clienteDTO.getTelefone(), clienteDTO.getEndereco(), clienteDTO.getCEP());
	}
}
