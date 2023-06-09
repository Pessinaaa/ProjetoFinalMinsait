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

import com.minsait.emprestimo.entity.Emprestimo;
import com.minsait.emprestimo.exception.CPFNaoCorrespondenteException;
import com.minsait.emprestimo.exception.CPFNaoEncontradoException;
import com.minsait.emprestimo.exception.IdNaoEncontradoException;
import com.minsait.emprestimo.exception.LimiteDeEmprestimoAtingidoException;
import com.minsait.emprestimo.service.EmprestimoService;

import jakarta.validation.Valid;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/v1/emprestimo/clientes/{cpf}/emprestimos")
public class EmprestimoController {
	
	private EmprestimoService emprestimoService;
	
	@Autowired
	public EmprestimoController(EmprestimoService emprestimoService) {
		this.emprestimoService = emprestimoService;
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Emprestimo cadastrarEmprestimo(@PathVariable Long cpf, @Valid @RequestBody Emprestimo emprestimo) throws CPFNaoEncontradoException, LimiteDeEmprestimoAtingidoException {
		return this.emprestimoService.cadastrarEmprestimo(cpf, emprestimo);
	}
	
	@GetMapping
	public List<Emprestimo> retornarTodosEmprestimos(@PathVariable Long cpf) throws CPFNaoEncontradoException {
		return this.emprestimoService.retornarTodosEmprestimos(cpf);
	}
	
	@GetMapping("/{id}")
	public Emprestimo retornarEmprestimoPorId(@PathVariable Long cpf, @PathVariable Long id) throws CPFNaoEncontradoException, IdNaoEncontradoException, CPFNaoCorrespondenteException {
		return this.emprestimoService.retornarEmprestimoPorId(cpf, id);
	}
	
	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deletarEmprestimo(@PathVariable Long cpf, @PathVariable Long id) throws CPFNaoEncontradoException, IdNaoEncontradoException, CPFNaoCorrespondenteException {
		this.emprestimoService.deletarEmprestimo(cpf, id);
	}
}
