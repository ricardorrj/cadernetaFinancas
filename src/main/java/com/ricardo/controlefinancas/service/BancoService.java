package com.ricardo.controlefinancas.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.ricardo.controlefinancas.domain.Banco;
import com.ricardo.controlefinancas.repositories.BancoRepository;
import com.ricardo.controlefinancas.service.exception.ObjectNotFoundException;

@Service
public class BancoService {

	@Autowired
	private BancoRepository repository;	
	
	public Banco findById(Integer id) {
		Optional<Banco> banco = repository.findById(id);
		
		return banco.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado! Id: " + id));
	}
	
	
	public List<Banco> findAll(){
		List<Banco> list = repository.findAll();
		return list;
	}
	
	
	public Banco create(Banco banco) {
		banco.setId(null);
		return repository.save(banco);
	}
	
	
	public Banco update(Integer id, Banco obj) {
		Banco banco = this.findById(id);
		banco.setDescricao(obj.getDescricao());
		
		return repository.save(banco);
	}
	
	
	public void delete(Integer id) {
		repository.findById(id);
		
		try {
			repository.deleteById(id);
		}
		catch(DataIntegrityViolationException e){
			throw new com.ricardo.controlefinancas.service.exception.DataIntegrityViolationException("Informação não pode ser deletada, possui outros cadastros vinculados!");
		}
	}
	
}
