package com.br.lead.filmesLead.controller.form;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.br.lead.filmesLead.model.Usuario;

public class UsuarioForm {
	@NotNull @NotEmpty
	private String nome;
	
	@NotNull @NotEmpty
	private String email;
	
	@NotNull @NotEmpty
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
