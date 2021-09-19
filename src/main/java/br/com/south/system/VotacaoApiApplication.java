package br.com.south.system;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Classe principal da Aplicação responsável por iniciar o projeto de sistema de Votação (via Spring Boot)
 */

@SpringBootApplication
public class VotacaoApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(VotacaoApiApplication.class, args);
	}
}
