package com.minsait.emprestimo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.minsait.emprestimo.entity.Cliente;
import com.minsait.emprestimo.exception.CPFJaCadastradoException;
import com.minsait.emprestimo.repository.ClienteRepository;

@Service
public class ClienteService {
	private ClienteRepository clienteRepository;
	
	@Autowired
	public ClienteService(ClienteRepository clienteRepository) {
		this.clienteRepository = clienteRepository;
	}
	
	public Cliente cadastrarCliente(Cliente cliente) throws Exception {
	if (!this.clienteRepository.existsById(cliente.getCPF())) {
			return this.clienteRepository.save(cliente);
		}
	throw new CPFJaCadastradoException(cliente.getCPF());
	}
}
