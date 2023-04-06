package com.minsait.emprestimo.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.minsait.emprestimo.entity.Cliente;
import com.minsait.emprestimo.service.ClienteService;

import jakarta.validation.Valid;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/v1/emprestimo/clientes")
public class ClienteController {

	private ClienteService clienteService;
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Cliente cadastraCliente(@Valid @RequestBody Cliente cliente) {
		return this.clienteService.cadastrarCliente(cliente);
	}
}
