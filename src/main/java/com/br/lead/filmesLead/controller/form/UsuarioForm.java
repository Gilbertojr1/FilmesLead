package com.br.lead.filmesLead.controller.form;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import com.br.lead.filmesLead.modelo.Usuario;

public class UsuarioForm {
	@NotNull @NotEmpty @Length(min = 5)
	private String nome;
	
	@NotNull @NotEmpty @Length(min = 10)
	private String email;
	
	@NotNull @NotEmpty @Length(min = 6)
	private String senha;
	
	private boolean adm = false;

	public String getNome() {
		return nome;
	}
	public String getEmail() {
		return email;
	}
	public String getSenha() {
		return senha;
	}
	public boolean isAdm() {
		return adm;
	}
	
	public Usuario cadastro() {
		return new Usuario(nome, email, senha, false);
	}
}
