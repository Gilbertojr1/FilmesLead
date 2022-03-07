package com.br.lead.filmesLead.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.br.lead.filmesLead.model.Categoria;

public interface CategoriaRepository extends JpaRepository<Categoria, Long> {

	Categoria findByNome(String nomeCategoria);

}
