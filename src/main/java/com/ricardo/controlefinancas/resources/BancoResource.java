package com.ricardo.controlefinancas.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ricardo.controlefinancas.domain.Banco;
import com.ricardo.controlefinancas.service.BancoService;

@RestController
@RequestMapping(value="/bancos")
public class BancoResource {

	@Autowired
	private BancoService service;
	
	@GetMapping(value="{id}")
	public ResponseEntity<Banco> findById(@PathVariable Integer id) {
		
		Banco banco = service.findById(id);
		
		return ResponseEntity.ok().body(banco);
	}
	
	
	@GetMapping
	public ResponseEntity<List<Banco>> findAll(){
		List<Banco> listData = service.findAll();
		
		return ResponseEntity.ok().body(listData);
	}
	
	
	@PostMapping
	public ResponseEntity<Banco> create(@RequestBody Banco banco){
		banco = service.create(banco);
		
		return ResponseEntity.ok().body(banco);
	}
	
	
	@PutMapping(value="{id}")
	public ResponseEntity<Banco> update(@PathVariable Integer id, @RequestBody Banco obj){
		obj = service.update(id, obj);
		
		return ResponseEntity.ok().body(obj);
	}
	
	
	@DeleteMapping(value="{id}")
	public ResponseEntity<Void> delete(@PathVariable Integer id){
		service.delete(id);
		
		return ResponseEntity.noContent().build();
	}
	
}
