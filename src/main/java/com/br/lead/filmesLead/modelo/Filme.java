package com.br.lead.filmesLead.modelo;

import java.time.LocalDate;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "filme")
public class Filme {
	
	@Id @Column(name = "id") @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "nome")
	private String nome; 
	
	@Column(name = "data_lancamento")
	private LocalDate data_lancamento;
	
	@Column(name = "diretor")
	private String diretor;
	
	@Column(name = "duracao")
	private double duracao;
	
	@Column(name = "sinopse")
	private String sinopse;
	
	@ManyToOne
	@JoinColumn(name = "estudio_id")
	private Estudio estudio;
	
	@ManyToOne
	@JoinColumn(name = "categoria_id")
	private Categoria categoria;
	
	public Filme() {
		
	}
	
	public Filme(String nome, LocalDate data_lancamento, String diretor, double duracao, Categoria categoria, Estudio estudio, String sinopse) {
		super();
		this.nome = nome;
		this.data_lancamento = data_lancamento;
		this.diretor = diretor;
		this.duracao = duracao;
		this.categoria = categoria;
		this.estudio = estudio;
		this.sinopse = sinopse;
	}

	@Override
	public int hashCode() {
		return Objects.hash(categoria, data_lancamento, diretor, duracao, estudio, id, nome, sinopse);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Filme other = (Filme) obj;
		return Objects.equals(categoria, other.categoria) && Objects.equals(data_lancamento, other.data_lancamento)
				&& Objects.equals(diretor, other.diretor)
				&& Double.doubleToLongBits(duracao) == Double.doubleToLongBits(other.duracao)
				&& Objects.equals(estudio, other.estudio) && Objects.equals(id, other.id)
				&& Objects.equals(nome, other.nome) && Objects.equals(sinopse, other.sinopse);
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

	public String getSinopse() {
		return sinopse;
	}

	public void setSinopse(String sinopse) {
		this.sinopse = sinopse;
	}

	public Estudio getEstudio() {
		return estudio;
	}

	public void setEstudio(Estudio estudio) {
		this.estudio = estudio;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	public double getDuracao() {
		return duracao;
	}

	public void setDuracao(double duracao) {
		this.duracao = duracao;
	}
	
}
