package com.br.lead.filmesLead.controller.dto;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import com.br.lead.filmesLead.modelo.Categoria;
import com.br.lead.filmesLead.modelo.Estudio;
import com.br.lead.filmesLead.modelo.Filme;

public class FilmeDto {
	
	private Long id;
	private String nome;
	private LocalDate data_lancamento;
	private String diretor;
	private double duracao;
	private String sinopse;
	private Estudio estudio;
	private Categoria categoria;
	
	public FilmeDto(Filme filme) {
		this.id = filme.getId();
		this.nome = filme.getNome();
		this.data_lancamento = filme.getData_lancamento();
		this.diretor = filme.getDiretor();
		this.duracao = filme.getDuracao();
		this.sinopse = filme.getSinopse();
		this.estudio = filme.getEstudio();
		this.categoria = filme.getCategoria();
	}
	
	public Long getId() {
		return id;
	}
	public String getNome() {
		return nome;
	}
	public LocalDate getData_lancamento() {
		return data_lancamento;
	}
	public String getDiretor() {
		return diretor;
	}
	public double getDuracao() {
		return duracao;
	}
	public String getSinopse() {
		return sinopse;
	}
	public Estudio getEstudio() {
		return estudio;
	}
	public Categoria getCategoria() {
		return categoria;
	}

	public static List<FilmeDto> converter(List<Filme> filmes) {
		return filmes.stream().map(FilmeDto::new).collect(Collectors.toList());
	}
	
}
