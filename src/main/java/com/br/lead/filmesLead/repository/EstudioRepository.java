package com.br.lead.filmesLead.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.br.lead.filmesLead.model.Estudio;

public interface EstudioRepository extends JpaRepository<Estudio, Long> {
	
	List<Estudio> findByNomeContainingIgnoreCase(String nome);
	
	Estudio findByNome(String nomeEstudio);
	
}
