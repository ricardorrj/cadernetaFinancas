package com.ricardo.controlefinancas.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ricardo.controlefinancas.domain.Categoria;

public interface CategoriaRepository extends JpaRepository<Categoria, Integer>{

}
