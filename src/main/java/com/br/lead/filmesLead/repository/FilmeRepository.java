package com.br.lead.filmesLead.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.br.lead.filmesLead.model.Filme;

@Repository
public interface FilmeRepository extends JpaRepository<Filme, Long> {
	
	List<Filme> findByNomeContainingIgnoreCase(String nome);
	
	List<Filme> findByNomeContainingIgnoreCaseAndCategoria_id(String nome, Long categoria_id);
	
	List<Filme> findByCategoria_id(Long categoria_id);
	
	@Query(value = "SELECT * FROM filme WHERE filme.nome ILIKE '%:nome%' AND (:categoria_id IS NULL OR filme.categoria_id = :categoria_id)", nativeQuery = true) 
	List<Filme> filterNomeAndCategoria(@Param(value = "nome") String nome, @Param(value = "categoria_id") Long categoria_id);
	
	@Query("SELECT m FROM Filme m WHERE m.nome LIKE %:nome%") 
	List<Filme> searchByNomeLike(String nome);
	
}
