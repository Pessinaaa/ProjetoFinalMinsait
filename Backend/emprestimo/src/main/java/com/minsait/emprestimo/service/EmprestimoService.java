package com.minsait.emprestimo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.minsait.emprestimo.entity.Emprestimo;
import com.minsait.emprestimo.exception.CPFNaoEncontradoException;
import com.minsait.emprestimo.repository.ClienteRepository;
import com.minsait.emprestimo.repository.EmprestimoRepository;
import com.minsait.emprestimo.strategy.Relacionamento;

@Service
public class EmprestimoService {
	private EmprestimoRepository emprestimoRepository;
	private ClienteRepository clienteRepository;
	
	@Autowired
	public EmprestimoService(EmprestimoRepository emprestimoRepository, ClienteRepository clienteRepository) {
		this.emprestimoRepository = emprestimoRepository;
		this.clienteRepository = clienteRepository;
	}
	
	public Emprestimo cadastrarEmprestimo(Long cpf, Emprestimo emprestimo) throws CPFNaoEncontradoException {
		if (this.clienteRepository.existsById(cpf)) {
			emprestimo.setCPFCliente(cpf);
			emprestimo.setNivelRelacionamento(Relacionamento.BRONZE);
			return this.emprestimoRepository.save(emprestimo);
		}
		throw new CPFNaoEncontradoException(cpf);
	}
}
