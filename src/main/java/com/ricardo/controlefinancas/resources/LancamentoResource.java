package com.ricardo.controlefinancas.resources;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ricardo.controlefinancas.domain.Lancamento;
import com.ricardo.controlefinancas.dtos.LancamentoDTO;
import com.ricardo.controlefinancas.service.LancamentoService;

@RestController
@RequestMapping(value="/lancamentos")
public class LancamentoResource {
	
	@Autowired
	private LancamentoService service;	
	
	
	@GetMapping(value="{id}")
	public ResponseEntity<Lancamento> findById(@PathVariable Integer id){
		Lancamento lancamento = service.findById(id);
		
		return ResponseEntity.ok().body(lancamento);
	}
	
	
	@GetMapping
	public ResponseEntity<List<LancamentoDTO>> findAll(@RequestParam(value = "banco", defaultValue = "0") Integer idBanco){
		List<Lancamento> list = service.findAll(idBanco);
		List<LancamentoDTO> listDTO = list.stream().map(obj -> new LancamentoDTO(obj)).collect(Collectors.toList());
		
		return ResponseEntity.ok().body(listDTO);
	}
	
	
	@PostMapping
	public ResponseEntity<Lancamento> create(@RequestBody Lancamento obj,
											 @RequestParam(value = "banco", defaultValue = "0") Integer idBanco,
											 @RequestParam(value = "categoria", defaultValue = "0") Integer idCategoria){
		Lancamento lancamento = service.create(obj, idCategoria, idBanco);
		
		return ResponseEntity.ok().body(lancamento);
	}
	
	
	@PutMapping(value="{id}")
	public ResponseEntity<Lancamento> update(@PathVariable Integer id,
											 @RequestBody Lancamento obj,
			 								 @RequestParam(value = "categoria", defaultValue = "0") Integer idCategoria){
		
		Lancamento lancamento = service.update(id, obj, idCategoria);
		return ResponseEntity.ok().body(lancamento);
	}
	
	
	@DeleteMapping(value="{id}")
	public ResponseEntity<Void> delete(@PathVariable Integer id){
		service.delete(id);
		
		return ResponseEntity.noContent().build();
	}
	
} 
