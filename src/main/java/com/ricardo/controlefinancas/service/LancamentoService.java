package com.ricardo.controlefinancas.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ricardo.controlefinancas.domain.Banco;
import com.ricardo.controlefinancas.domain.Categoria;
import com.ricardo.controlefinancas.domain.Lancamento;
import com.ricardo.controlefinancas.repositories.LancamentoRepository;
import com.ricardo.controlefinancas.service.exception.ObjectNotFoundException;

@Service
public class LancamentoService {
	
	@Autowired
	private LancamentoRepository repository;
	
	@Autowired
	private CategoriaService categoriaService;
	
	@Autowired
	private BancoService bancoService;
	
	
	public Lancamento findById(Integer id) {
		Optional<Lancamento> obj = repository.findById(id);
		
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado! Id: " + id));
	}
	
	
	public List<Lancamento> findAll(Integer idBanco){
		
		bancoService.findById(idBanco);
		List<Lancamento> list = repository.findAllByBanco(idBanco);
		
		return list;
	}
	
	
	public Lancamento create(Lancamento lancamento, Integer idCategoria, Integer idBanco) {
		lancamento.setId(null);
		
		Categoria cat = categoriaService.findById(idCategoria);
		Banco banco = bancoService.findById(idBanco);
		
		lancamento.setCategoria(cat);
		lancamento.setBanco(banco);
		repository.save(lancamento);

		return lancamento;
	}
	
	
	private Lancamento updateLancamento(Integer id, Lancamento obj, Integer idCategoria) {
		Lancamento lancamento = this.findById(id);
		Categoria cat = categoriaService.findById(idCategoria);
		
		lancamento.setDescricao(obj.getDescricao());
		lancamento.setSituacao(obj.getSituacao());
		lancamento.setCategoria(cat);
		
		return lancamento;
	}
	
	public Lancamento update(Integer id, Lancamento obj, Integer idCategoria) {
		Lancamento lancamento = updateLancamento(id, obj, idCategoria);
		
		return repository.save(lancamento);
	}
	
	
	public void delete(Integer id) {
		this.findById(id);
		repository.deleteById(id);
	}
	
}
