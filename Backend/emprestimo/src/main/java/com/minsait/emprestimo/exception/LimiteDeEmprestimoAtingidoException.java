package com.minsait.emprestimo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.PRECONDITION_FAILED)
public class LimiteDeEmprestimoAtingidoException extends Exception{
	private static final long serialVersionUID = 1L;
	
	public LimiteDeEmprestimoAtingidoException(Long cpf) {
		super(String.format("O cliente com o CPF %s não possui limite suficiente para este empréstimo", cpf));
	}
}
