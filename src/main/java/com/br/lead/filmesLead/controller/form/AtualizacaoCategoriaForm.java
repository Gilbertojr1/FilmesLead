package com.br.lead.filmesLead.controller.form;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.br.lead.filmesLead.model.Categoria;
import com.br.lead.filmesLead.repository.CategoriaRepository;

public class AtualizacaoCategoriaForm {
	@NotNull @NotEmpty
	private String nome;

	public String getNome() {
		return nome;
	}
	
	public Categoria atualizar(Long id,  CategoriaRepository categoriaRepository) {
		Categoria categoria = categoriaRepository.getOne(id);
		
		categoria.setNome(this.nome);
		
		return categoria;
	}
}
