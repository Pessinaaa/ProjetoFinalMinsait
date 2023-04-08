package com.minsait.emprestimo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.minsait.emprestimo.entity.Cliente;
import com.minsait.emprestimo.exception.CPFJaCadastradoException;
import com.minsait.emprestimo.exception.CPFNaoEncontradoException;
import com.minsait.emprestimo.repository.ClienteRepository;

@Service
public class ClienteService {
	private ClienteRepository clienteRepository;
	
	@Autowired
	public ClienteService(ClienteRepository clienteRepository) {
		this.clienteRepository = clienteRepository;
	}
	
	public Cliente cadastrarCliente(Cliente cliente) throws CPFJaCadastradoException {
	if (!this.clienteRepository.existsById(cliente.getCPF())) {
			return this.clienteRepository.save(cliente);
		}
	throw new CPFJaCadastradoException(cliente.getCPF());
	}
	
	public List<Cliente> retornarTodosClientes() {
		return this.clienteRepository.findAll();
	}
	
	public Cliente retornarClientePeloCPF(Long cpf) throws CPFNaoEncontradoException{
		if (this.clienteRepository.existsById(cpf)) {
			return this.clienteRepository.getReferenceById(cpf);
		}
		throw new CPFNaoEncontradoException(cpf);
	}
}