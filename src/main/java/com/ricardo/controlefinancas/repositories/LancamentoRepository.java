package com.ricardo.controlefinancas.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ricardo.controlefinancas.domain.Lancamento;

public interface LancamentoRepository extends JpaRepository<Lancamento, Integer>{

	@Query(value = "select l from Lancamento l where l.banco.id = :idBanco order by l.tipo desc")
	List<Lancamento> findAllByBanco(@Param(value = "idBanco") Integer idBanco);
}
