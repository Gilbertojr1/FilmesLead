package com.br.lead.filmesLead.controller.form;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.br.lead.filmesLead.model.Usuario;

public class UsuarioForm {
	@NotNull @NotEmpty
	private String nome;
	
	@NotNull @NotEmpty
	private String email;
	
	@NotNull @NotEmpty
	private String senha;
	
	private boolean adm = false;

	public void setNome(String nome) {
		this.nome = nome;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public void setSenha(String senha) {
		this.senha = new BCryptPasswordEncoder().encode(senha);
	}
	public void setAdm(boolean adm) {
		this.adm = adm;
	}
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
