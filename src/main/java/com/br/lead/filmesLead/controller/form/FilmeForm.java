package com.br.lead.filmesLead.controller.form;

import java.time.LocalDate;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.br.lead.filmesLead.model.Categoria;
import com.br.lead.filmesLead.model.Estudio;
import com.br.lead.filmesLead.model.Filme;
import com.br.lead.filmesLead.repository.CategoriaRepository;
import com.br.lead.filmesLead.repository.EstudioRepository;

public class FilmeForm {
	@NotNull @NotEmpty
	private String nome;
	@NotNull 
	private LocalDate data_lancamento;
	@NotNull @NotEmpty
	private String diretor;
	@NotNull 
	private double duracao;
	@NotNull @NotEmpty
	private String sinopse;
	
	@NotNull 
	private Long id_Estudio;
	@NotNull
	private Long id_Categoria;
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public LocalDate getData_lancamento() {
		return data_lancamento;
	}
	public void setData_lancamento(LocalDate data_lancamento) {
		this.data_lancamento = data_lancamento;
	}
	public String getDiretor() {
		return diretor;
	}
	public void setDiretor(String diretor) {
		this.diretor = diretor;
	}
	public double getDuracao() {
		return duracao;
	}
	public void setDuracao(double duracao) {
		this.duracao = duracao;
	}
	public String getSinopse() {
		return sinopse;
	}
	public void setSinopse(String sinopse) {
		this.sinopse = sinopse;
	}
	public Long getId_Estudio() {
		return id_Estudio;
	}
	public void setId_Estudio(Long id_Estudio) {
		this.id_Estudio = id_Estudio;
	}
	public Long getId_Categoria() {
		return id_Categoria;
	}
	public void setId_Categoria(Long id_Categoria) {
		this.id_Categoria = id_Categoria;
	}
	
	public Filme converter(CategoriaRepository categoriaRepository, EstudioRepository estudioRepository) {
		Categoria categoria = categoriaRepository.findById(id_Categoria).get();
		Estudio estudio = estudioRepository.findById(id_Estudio).get();
		
		return new Filme(nome, data_lancamento, diretor, duracao, categoria, estudio, sinopse);
	}
	
	
}
