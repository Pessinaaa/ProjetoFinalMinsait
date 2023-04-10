package com.minsait.emprestimo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.minsait.emprestimo.entity.Emprestimo;

public interface EmprestimoRepository extends JpaRepository<Emprestimo, Long>{

	List<Emprestimo> findAllByCPFCliente(Long cpf);

}
