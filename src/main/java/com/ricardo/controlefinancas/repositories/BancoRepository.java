package com.ricardo.controlefinancas.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ricardo.controlefinancas.domain.Banco;

@Repository
public interface BancoRepository extends JpaRepository<Banco, Integer>{

}
