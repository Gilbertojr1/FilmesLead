package com.br.lead.filmesLead.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.br.lead.filmesLead.model.Categoria;

public interface CategoriaRepository extends JpaRepository<Categoria, Long> {
	
	List<Categoria> findByNomeContainingIgnoreCase(String nome);

	Categoria findByNome(String nomeCategoria);

}
