package com.br.lead.filmesLead;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class FilmesLeadApplication {

	public static void main(String[] args) {
		SpringApplication.run(FilmesLeadApplication.class, args);
	}

}