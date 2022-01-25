package com.br.lead.filmesLead.controller.dto;

import java.util.List;
import java.util.stream.Collectors;

import com.br.lead.filmesLead.modelo.Estudio;

public class EstudioDto {
	
	private Long id;
	private String nome;
	
	public EstudioDto(Estudio estudio) {
		this.id = estudio.getId();
		this.nome = estudio.getNome();
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
	
	public static List<EstudioDto> converter(List<Estudio> estudios) {
		return estudios.stream().map(EstudioDto::new).collect(Collectors.toList());
	}
}
