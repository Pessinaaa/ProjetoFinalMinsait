package com.minsait.emprestimo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class CPFNaoEncontradoException extends Exception {
	private static final long serialVersionUID = 1L;
	
	public CPFNaoEncontradoException(Long cpf) {
		super(String.format("O CPF %s não foi encontrado", cpf));
	}
}
