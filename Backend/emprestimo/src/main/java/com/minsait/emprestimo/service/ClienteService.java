package com.minsait.emprestimo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.minsait.emprestimo.entity.Cliente;
import com.minsait.emprestimo.exception.CPFJaCadastradoException;
import com.minsait.emprestimo.exception.CPFNaoEncontradoException;
import com.minsait.emprestimo.repository.ClienteRepository;

import jakarta.validation.Valid;

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
	
	public Cliente retornarClientePeloCPF(Long cpf) throws CPFNaoEncontradoException {
		if (this.clienteRepository.existsById(cpf)) {
			return this.clienteRepository.getReferenceById(cpf);
		}
		throw new CPFNaoEncontradoException(cpf);
	}
	
	public void deletarCliente(Long cpf) throws CPFNaoEncontradoException {
		if (this.clienteRepository.existsById(cpf)) {
			this.clienteRepository.deleteById(cpf);
		} else {
			throw new CPFNaoEncontradoException(cpf);
		}
	}
	
	public Cliente alterarCliente(Long cpf, @Valid Cliente cliente) throws CPFNaoEncontradoException {
		if (this.clienteRepository.existsById(cpf)) {
			Cliente clienteASerAlterado = this.clienteRepository.getReferenceById(cpf);
			cliente.setCPF(cpf);
			if (cliente.getNome() == null) {
				cliente.setNome(clienteASerAlterado.getNome());
			}
			if (cliente.getTelefone() == null) {
				cliente.setTelefone(clienteASerAlterado.getTelefone());
			}
			if (cliente.getEndereco() == null) {
				cliente.setEndereco(clienteASerAlterado.getEndereco());
			}
			if (cliente.getCEP() == null) {
				cliente.setCEP(clienteASerAlterado.getCEP());
			}
			if (cliente.getRendimentoMensal() == null) {
				cliente.setRendimentoMensal(clienteASerAlterado.getRendimentoMensal());
			}
			return this.clienteRepository.save(cliente);
		}
		throw new CPFNaoEncontradoException(cpf);
	}
}
