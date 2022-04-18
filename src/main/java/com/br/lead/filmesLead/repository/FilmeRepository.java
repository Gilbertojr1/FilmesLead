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
	
	List<Filme> findByDiretorContainingIgnoreCase(String diretor);
	
	List<Filme> findByNomeContainingIgnoreCaseAndCategoria_idAndEstudio_id(String nome, Long categoria_id, Long estudio_id);
	
	List<Filme> findByNomeContainingIgnoreCaseAndDiretorContainingIgnoreCaseAndCategoria_idAndEstudio_id(String nome, String diretor, Long categoria_id, Long estudio_id);
	
	List<Filme> findByNomeContainingIgnoreCaseAndCategoria_id(String nome, Long categoria_id);
	
	List<Filme> findByNomeContainingIgnoreCaseAndEstudio_id(String nome, Long estudio_id);
	
	List<Filme> findByCategoria_idAndEstudio_id(Long categoria_id, Long estudio_id);
	
	List<Filme> findByCategoria_id(Long categoria_id);
	
	List<Filme> findByEstudio_id(Long estudio_id);
	
	/*
	@Query(value = "SELECT * FROM filme WHERE filme.nome ILIKE CONCAT('%', :nome, '%') AND (:categoriaId IS NULL OR filme.categoria_id = :categoriaId)", nativeQuery = true) 
	List<Filme> filterNomeAndCategoria(@Param(value = "nome") String nome, @Param(value = "categoriaId") Long categoria);
	
	@Query("SELECT m FROM Filme m WHERE m.nome LIKE %:nome%") 
	List<Filme> searchByNomeLike(String nome);
	*/
}
