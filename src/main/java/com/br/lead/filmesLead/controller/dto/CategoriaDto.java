package com.br.lead.filmesLead.controller.dto;

import java.util.List;
import java.util.stream.Collectors;

import com.br.lead.filmesLead.model.Categoria;

public class CategoriaDto {
	
	private Long id;
	private String nome;
	
	public CategoriaDto(Categoria categoria) {
		this.id = categoria.getId();
		this.nome = categoria.getNome();
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public static List<CategoriaDto> converter(List<Categoria> categorias) {
		return categorias.stream().map(CategoriaDto::new).collect(Collectors.toList());
	}
}
