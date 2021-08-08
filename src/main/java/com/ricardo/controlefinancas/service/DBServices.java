package com.ricardo.controlefinancas.service;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ricardo.controlefinancas.domain.Banco;
import com.ricardo.controlefinancas.domain.Categoria;
import com.ricardo.controlefinancas.domain.Lancamento;
import com.ricardo.controlefinancas.repositories.BancoRepository;
import com.ricardo.controlefinancas.repositories.CategoriaRepository;
import com.ricardo.controlefinancas.repositories.LancamentoRepository;

@Service
public class DBServices {

	@Autowired
	private CategoriaRepository catRep;
	
	@Autowired
	private LancamentoRepository lancRep;
	
	@Autowired
	private BancoRepository bancoRep;
	
	public void instanciaDb() {
		
		Categoria cat1 = new Categoria(null, "Renda Mensal");
		Categoria cat2 = new Categoria(null, "Despesas Mensais");
		Categoria cat3 = new Categoria(null, "Carro");
		
		Banco b1 = new Banco(null, "Caixa");
		Banco b2 = new Banco(null, "Itaú");
		
		Lancamento l1 = new Lancamento(null, 'E', "Salário Mensal", 1, cat1, b1);
		Lancamento l2 = new Lancamento(null, 'S', "Financiamento Casa", 0, cat2, b1);
		Lancamento l3 = new Lancamento(null, 'S', "Financiamento Carro", 0, cat3, b2);
		
		this.bancoRep.saveAll(Arrays.asList(b1, b2));
		this.catRep.saveAll(Arrays.asList(cat1, cat2, cat3));
		this.lancRep.saveAll(Arrays.asList(l1, l2, l3));
	}
}
