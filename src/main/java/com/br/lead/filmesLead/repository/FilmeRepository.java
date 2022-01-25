package com.br.lead.filmesLead.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.br.lead.filmesLead.modelo.Filme;

public interface FilmeRepository extends JpaRepository<Filme, Long> {

}
