package com.br.lead.filmesLead.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.br.lead.filmesLead.modelo.Filme;

public interface FilmeRepository extends JpaRepository<Filme, Long> {
	
	List<Filme> findByNomeContainingIgnoreCase(String nome);
	
	List<Filme> findByNomeOrderByNomeAsc(String nome);
	
	/*
	 * @Query("SELECT m FROM filme m WHERE m.nome LIKE %:nome%") List<Filme>
	 * searchByNomeLike(String nome);
	 */
}
