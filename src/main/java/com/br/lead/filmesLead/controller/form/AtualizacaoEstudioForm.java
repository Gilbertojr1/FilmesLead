package com.br.lead.filmesLead.controller.form;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.br.lead.filmesLead.model.Estudio;
import com.br.lead.filmesLead.repository.EstudioRepository;

public class AtualizacaoEstudioForm {
	@NotNull @NotEmpty
	private String nome;

	public String getNome() {
		return nome;
	}
	
	public Estudio atualizar(Long id, EstudioRepository estudioRepository) {
		Estudio estudio = estudioRepository.getOne(id);
		
		estudio.setNome(this.nome);
		
		return estudio;
	}
}
