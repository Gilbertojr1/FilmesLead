package com.br.lead.filmesLead.controller;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.br.lead.filmesLead.controller.dto.FilmeDto;
import com.br.lead.filmesLead.controller.form.AtualizacaoFilmeForm;
import com.br.lead.filmesLead.controller.form.FilmeForm;
import com.br.lead.filmesLead.modelo.Categoria;
import com.br.lead.filmesLead.modelo.Estudio;
import com.br.lead.filmesLead.modelo.Filme;
import com.br.lead.filmesLead.repository.CategoriaRepository;
import com.br.lead.filmesLead.repository.EstudioRepository;
import com.br.lead.filmesLead.repository.FilmeRepository;

@RestController
@RequestMapping("/api/filmes")
public class FilmesController {
	
	@Autowired
	private FilmeRepository filmeRepository;
	
	@Autowired
	private CategoriaRepository categoriaRepository;
	
	@Autowired
	private EstudioRepository estudioRepository;
	
	@GetMapping
	public List<FilmeDto> lista(){
		List<Filme> filmes = filmeRepository.findAll();
		return FilmeDto.converter(filmes);
	}
	
	@PostMapping
	@Transactional
	public ResponseEntity<FilmeDto> cadastrar(@RequestBody @Valid FilmeForm form, UriComponentsBuilder uriBuilder) {
		Optional<Estudio> estudioOptional = estudioRepository.findById(form.getId_Estudio());
		Optional<Categoria> categoriaOptional = categoriaRepository.findById(form.getId_Categoria());
		
		if (estudioOptional.isPresent() && categoriaOptional.isPresent()) {
			Filme filme = form.converter(categoriaRepository, estudioRepository);
			filmeRepository.save(filme);
			
			URI uri = uriBuilder.path("/filmes/{id}").buildAndExpand(filme.getId()).toUri();
			return ResponseEntity.created(uri).body(new FilmeDto(filme));
		} 
		 return ResponseEntity.badRequest().build();
		 
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<FilmeDto> detalhar(@PathVariable Long id) {
 		Optional<Filme> filme = filmeRepository.findById(id);
 		if(filme.isPresent()) {
 			return ResponseEntity.ok(new FilmeDto(filme.get()));
 		}
		
 		return ResponseEntity.notFound().build();
	}
	
	@PutMapping("/{id}")
	@Transactional
	public ResponseEntity<FilmeDto> atualizar(@PathVariable Long id, @RequestBody @Valid AtualizacaoFilmeForm form){
		Optional<Filme> optional = filmeRepository.findById(id);
		Optional<Estudio> estudioOptional = estudioRepository.findById(form.getId_Estudio());
		Optional<Categoria> categoriaOptional = categoriaRepository.findById(form.getId_Categoria());
		
 		if(optional.isPresent() && estudioOptional.isPresent() && categoriaOptional.isPresent()) {
 			Filme filme = form.atualizar(id, filmeRepository, categoriaRepository, estudioRepository);
 			return ResponseEntity.ok(new FilmeDto(filme));
 		}
 		return ResponseEntity.notFound().build();
	}
	
	@DeleteMapping("/{id}")
	@Transactional
	public ResponseEntity<?> remover(@PathVariable Long id){
		Optional<Filme> optional = filmeRepository.findById(id);
		if(optional.isPresent()) {
			filmeRepository.deleteById(id);
			return ResponseEntity.ok().build();
 		}
		
		return ResponseEntity.notFound().build();
	}
}

