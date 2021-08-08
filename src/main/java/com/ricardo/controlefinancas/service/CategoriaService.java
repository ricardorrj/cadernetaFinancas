package com.ricardo.controlefinancas.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.ricardo.controlefinancas.domain.Categoria;
import com.ricardo.controlefinancas.repositories.CategoriaRepository;
import com.ricardo.controlefinancas.service.exception.ObjectNotFoundException;

@Service
public class CategoriaService {

	@Autowired
	private CategoriaRepository repository;
	
	
	public Categoria findById(Integer id){
		
		Optional<Categoria> categoria = repository.findById(id);
		return categoria.orElseThrow(() -> new ObjectNotFoundException(
												"Objeto NÃ£o encontrado! Id: " + id + " Tipo: " + Categoria.class.getName()));
	}
	
	
	public List<Categoria> findAll(){
		List<Categoria> list = repository.findAll();
		return list;
	}
	
	
	public Categoria create(Categoria cat) {
		cat.setId(null);
		Categoria categoria = repository.save(cat);
		
		return categoria;
	}
	
	
	public Categoria update(Integer id, Categoria obj) {
		Categoria categoria = this.findById(id);
		
		categoria.setDescricao(obj.getDescricao());
		
		return repository.save(categoria);
	}
	
	
	public void delete(Integer id) {
		this.findById(id);
		
		try {
			repository.deleteById(id);
		}
		catch(DataIntegrityViolationException e){
			throw new com.ricardo.controlefinancas.service.exception.DataIntegrityViolationException("Informação não pode ser deletada, possui outros cadastros vinculados!");
		}
	}
}
