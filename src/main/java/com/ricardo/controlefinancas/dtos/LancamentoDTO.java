package com.ricardo.controlefinancas.dtos;

import java.io.Serializable;

import com.ricardo.controlefinancas.domain.Lancamento;

public class LancamentoDTO implements Serializable{

	private static final long serialVersionUID = 1L;
	private Integer id;
	private Character tipo;
	private String descricao;
	private Integer situacao;
	
	public LancamentoDTO() {
		super();
	}

	public LancamentoDTO(Lancamento obj) {
		super();
		this.id = obj.getId();
		this.tipo = obj.getTipo();
		this.descricao = obj.getDescricao();
		this.situacao = obj.getSituacao();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Character getTipo() {
		return tipo;
	}

	public void setTipo(Character tipo) {
		this.tipo = tipo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Integer getSituacao() {
		return situacao;
	}

	public void setSituacao(Integer situacao) {
		this.situacao = situacao;
	}
}
