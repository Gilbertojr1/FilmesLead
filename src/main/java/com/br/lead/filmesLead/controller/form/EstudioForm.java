package com.br.lead.filmesLead.controller.form;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import com.br.lead.filmesLead.modelo.Estudio;

public class EstudioForm {
	@NotNull @NotEmpty @Length(min = 1)
	private String nome;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public Estudio cadastro() {
		return new Estudio(nome);
	}
}
