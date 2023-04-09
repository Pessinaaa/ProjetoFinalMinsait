package com.minsait.emprestimo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.minsait.emprestimo.entity.Cliente;
import com.minsait.emprestimo.exception.CPFJaCadastradoException;
import com.minsait.emprestimo.exception.CPFNaoEncontradoException;
import com.minsait.emprestimo.service.ClienteService;

import jakarta.validation.Valid;

//@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/v1/emprestimo/clientes")
public class ClienteController {

	private ClienteService clienteService;
	
	@Autowired
	public ClienteController(ClienteService clienteService) {
		this.clienteService = clienteService;
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Cliente cadastrarCliente(@Valid @RequestBody Cliente cliente) throws CPFJaCadastradoException {
		return this.clienteService.cadastrarCliente(cliente);
	}
	
	@GetMapping
	public List<Cliente> retornarTodosClientes() {
		return this.clienteService.retornarTodosClientes();
	}
	
	@GetMapping("/{cpf}")
	public Cliente retornarClientePeloCPF(@PathVariable Long cpf) throws CPFNaoEncontradoException {
		return this.clienteService.retornarClientePeloCPF(cpf);
	}
	
	@DeleteMapping("/{cpf}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deletarCliente(@PathVariable Long cpf) throws CPFNaoEncontradoException {
		this.clienteService.deletarCliente(cpf);
	}
}
