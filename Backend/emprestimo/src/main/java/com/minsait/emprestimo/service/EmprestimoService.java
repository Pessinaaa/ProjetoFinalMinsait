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
		if (this.clientePodePedirEmprestimo(cpf, emprestimo.getValorInicial())) {
			emprestimo.setCPFCliente(cpf);
			emprestimo.setNivelRelacionamento(Relacionamento.BRONZE);
			return this.emprestimoRepository.save(emprestimo);
		}
		throw new LimiteDeEmprestimoAtingidoException(cpf);
	}
	
	public Emprestimo retornarEmprestimoPorId(Long cpf, Long id) throws CPFNaoEncontradoException, IdNaoEncontradoException, CPFNaoCorrespondenteException {
		if (this.clienteRepository.existsById(cpf)) {
			if (this.emprestimoRepository.existsById(id)) {
				Emprestimo emprestimo = this.emprestimoRepository.getReferenceById(id);
				if (emprestimo.getCPFCliente().equals(cpf)) {
					return emprestimo;
				}
				throw new CPFNaoCorrespondenteException(id, cpf);
			}
			throw new IdNaoEncontradoException(id);
		}
		throw new CPFNaoEncontradoException(cpf);
	}
	
	public List<Emprestimo> retornarTodosEmprestimos(Long cpf) throws CPFNaoEncontradoException {
		if (this.clienteRepository.existsById(cpf)) {
			return this.emprestimoRepository.findAllByCPFCliente(cpf); //Retornar todos os empréstimos do cliente que o cpf foi passado
		}
		throw new CPFNaoEncontradoException(cpf);
	}
	
	public void deletarEmprestimo(Long cpf, Long id) throws CPFNaoEncontradoException, IdNaoEncontradoException, CPFNaoCorrespondenteException {
		if (this.clienteRepository.existsById(cpf)) {
			if (this.emprestimoRepository.existsById(id)) {
				if (this.emprestimoRepository.getReferenceById(id).getCPFCliente().equals(cpf)) {
					this.emprestimoRepository.deleteById(id);
					return;
				}
				throw new CPFNaoCorrespondenteException(id, cpf);
			}
			throw new IdNaoEncontradoException(id);
		}
		throw new CPFNaoEncontradoException(cpf);
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
