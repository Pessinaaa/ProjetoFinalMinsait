package com.minsait.emprestimo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.minsait.emprestimo.entity.Emprestimo;
import com.minsait.emprestimo.exception.CPFNaoCorrespondenteException;
import com.minsait.emprestimo.exception.CPFNaoEncontradoException;
import com.minsait.emprestimo.exception.IdNaoEncontradoException;
import com.minsait.emprestimo.exception.LimiteDeEmprestimoAtingidoException;
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
	
	public Emprestimo cadastrarEmprestimo(Long cpf, Emprestimo emprestimo) throws CPFNaoEncontradoException, LimiteDeEmprestimoAtingidoException {
		if (!this.clienteRepository.existsById(cpf)) {
			throw new CPFNaoEncontradoException(cpf);
		}
		if (!this.clientePodePedirEmprestimo(cpf, emprestimo.getValorInicial())) {
			throw new LimiteDeEmprestimoAtingidoException(cpf);
		}
		emprestimo.setCPFCliente(cpf);
		emprestimo.setValorFinal(emprestimo.getRelacionamento().calcularValorFinal(emprestimo.getValorInicial(), this.retornarTodosEmprestimos(cpf).size()));
		return this.emprestimoRepository.save(emprestimo);
	}
	
	public Emprestimo retornarEmprestimoPorId(Long cpf, Long id) throws CPFNaoEncontradoException, IdNaoEncontradoException, CPFNaoCorrespondenteException {
		if (!this.clienteRepository.existsById(cpf)) {
			throw new CPFNaoEncontradoException(cpf);
		}
		if (!this.emprestimoRepository.existsById(id)) {
			throw new IdNaoEncontradoException(id);
		}
		Emprestimo emprestimo = this.emprestimoRepository.getReferenceById(id);
		if (!emprestimo.getCPFCliente().equals(cpf)) {
			throw new CPFNaoCorrespondenteException(id, cpf);
		}
		return emprestimo;	
	}
	
	public List<Emprestimo> retornarTodosEmprestimos(Long cpf) throws CPFNaoEncontradoException {
		if (!this.clienteRepository.existsById(cpf)) {
			throw new CPFNaoEncontradoException(cpf);
		}
		return this.emprestimoRepository.findAllByCPFCliente(cpf); //Retornar todos os empréstimos do cliente que o cpf foi passado
	}
	
	public void deletarEmprestimo(Long cpf, Long id) throws CPFNaoEncontradoException, IdNaoEncontradoException, CPFNaoCorrespondenteException {
		if (!this.clienteRepository.existsById(cpf)) {
			throw new CPFNaoEncontradoException(cpf);
		}
		if (!this.emprestimoRepository.existsById(id)) {
			throw new IdNaoEncontradoException(id);
		}
		if (!this.emprestimoRepository.getReferenceById(id).getCPFCliente().equals(cpf)) {
			throw new CPFNaoCorrespondenteException(id, cpf);	
		}
		this.emprestimoRepository.deleteById(id);
	}
	
	//Método para verificar se o cliente pode pedir empréstimo no valor solicitado
	public boolean clientePodePedirEmprestimo(Long cpf, Double valor) throws CPFNaoEncontradoException {
		Double valorMaximo = this.clienteRepository.getReferenceById(cpf).getRendimentoMensal() * 10;
		Double valorEmprestimo = valor;
		for (Emprestimo emprestimoAuxiliar : this.retornarTodosEmprestimos(cpf)) {
			valorEmprestimo += emprestimoAuxiliar.getValorInicial();
		}
		if (valorEmprestimo <= valorMaximo) {
			return true;
		}
		return false;
	}
}
