package com.minsait.emprestimo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class IdNaoEncontradoException extends Exception {
	private static final long serialVersionUID = 1L;
	
	public IdNaoEncontradoException(Long id) {
		super(String.format("O ID %s não foi encontrado", id));
	}
}
