package com.br.lead.filmesLead.controller.form;

import java.time.LocalDate;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.br.lead.filmesLead.model.Categoria;
import com.br.lead.filmesLead.model.Estudio;
import com.br.lead.filmesLead.model.Filme;
import com.br.lead.filmesLead.repository.CategoriaRepository;
import com.br.lead.filmesLead.repository.EstudioRepository;
import com.br.lead.filmesLead.repository.FilmeRepository;

public class AtualizacaoFilmeForm {
	
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
	public Long getId_Estudio() {
		return id_Estudio;
	}
	public Long getId_Categoria() {
		return id_Categoria;
	}
	public Filme atualizar(Long id, FilmeRepository filmeRepository, CategoriaRepository categoriaRepository, EstudioRepository estudioRepository) {
		Filme filme = filmeRepository.getOne(id);
		Categoria categoria = categoriaRepository.findById(id_Categoria).get();
		Estudio estudio = estudioRepository.findById(id_Estudio).get();
		
		filme.setNome(this.nome);
		filme.setData_lancamento(this.data_lancamento);
		filme.setDiretor(this.diretor);
		filme.setDuracao(this.duracao);
		filme.setSinopse(this.sinopse);
		filme.setCategoria(categoria);
		filme.setEstudio(estudio);
		
		return filme;
	}
	
}







