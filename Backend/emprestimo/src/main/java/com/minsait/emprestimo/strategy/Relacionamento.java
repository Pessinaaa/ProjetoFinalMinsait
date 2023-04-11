package com.minsait.emprestimo.strategy;

public enum Relacionamento {
	
	BRONZE {
		@Override
		public Double calcularValorFinal(Double valorInicial, Integer quantidadeEmprestimos) {
			Double valorFinal = valorInicial * 1.8;
			Double valorFinalFormatado = Double.parseDouble(String.format("%.2f", valorFinal).replace(",", ".")); //Transforma o valor em string, formata para duas casas decimais, susbstitui a virgula que separa a parte decimal por ponto e transforma novamente em Double
			return valorFinalFormatado;
		}
	},
	PRATA {
		@Override
		public Double calcularValorFinal(Double valorInicial, Integer quantidadeEmprestimos) {
			Double valorFinal;
			if (valorInicial > 5000) {
				valorFinal = valorInicial * 1.4;
			} else {
				valorFinal = valorInicial * 1.6;
			}
			return Double.parseDouble(String.format("%.2f", valorFinal).replace(",", "."));
		}
	},
	OURO {
		@Override
		public Double calcularValorFinal(Double valorInicial, Integer quantidadeEmprestimos) {
			Double valorFinal;
			if (quantidadeEmprestimos <= 1) {
				valorFinal = valorInicial * 1.2;
			} else {
				valorFinal = valorInicial * 1.3;
			}
			return Double.parseDouble(String.format("%.2f", valorFinal).replace(",", "."));
		}
	};
	
	//Método abstrato
	public abstract Double calcularValorFinal(Double valorInicial, Integer quantidadeEmprestimos);
}
