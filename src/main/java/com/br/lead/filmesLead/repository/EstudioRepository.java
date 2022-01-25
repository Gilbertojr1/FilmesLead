package com.br.lead.filmesLead.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.br.lead.filmesLead.modelo.Estudio;

public interface EstudioRepository extends JpaRepository<Estudio, Long> {
	
	Estudio findByNome(String nomeEstudio);
}
