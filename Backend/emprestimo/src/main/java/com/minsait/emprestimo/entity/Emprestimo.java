package com.minsait.emprestimo.entity;

import com.minsait.emprestimo.strategy.Relacionamento;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;

@Entity
public class Emprestimo {
	//Atributos
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private Long CPFCliente;
	
	@NotNull(message="O valor inicial do empréstimo é obrigatório")
	private Double valorInicial;
	
	private Double valorFinal;
	
	@NotNull(message="O relacionamento é obrigatório")
	private Relacionamento relacionamento;
	
	@NotNull(message="A data inicial do empréstimo é obrigatória")
	private Integer dataInicial;
	
	@NotNull(message="A data final do empréstimo é obrigatória")
	private Integer dataFinal;
	
	//Metodos
	public Emprestimo() {	}
	
	public Emprestimo(Long cpfCliente, Double valorInicial, Double valorFinal, Relacionamento relacionamento, Integer dataInicial, Integer dataFinal) {
		CPFCliente = cpfCliente;
		this.valorInicial = valorInicial;
		this.valorFinal = valorFinal;
		this.relacionamento = relacionamento;
		this.dataInicial = dataInicial;
		this.dataFinal = dataFinal;
	}

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}

	public Long getCPFCliente() {
		return CPFCliente;
	}
	public void setCPFCliente(Long cpfCliente) {
		CPFCliente = cpfCliente;
	}

	public Double getValorInicial() {
		return valorInicial;
	}
	public void setValorInicial(Double valorInicial) {
		this.valorInicial = valorInicial;
	}

	public Double getValorFinal() {
		return valorFinal;
	}
	public void setValorFinal(Double valorFinal) {
		this.valorFinal = valorFinal;
	}

	public Relacionamento getRelacionamento() {
		return relacionamento;
	}
	public void setRelacionamento(Relacionamento relacionamento) {
		this.relacionamento = relacionamento;
	}

	public Integer getDataInicial() {
		return dataInicial;
	}
	public void setDataInicial(Integer dataInicial) {
		this.dataInicial = dataInicial;
	}

	public Integer getDataFinal() {
		return dataFinal;
	}
	public void setDataFinal(Integer dataFinal) {
		this.dataFinal = dataFinal;
	}
}
