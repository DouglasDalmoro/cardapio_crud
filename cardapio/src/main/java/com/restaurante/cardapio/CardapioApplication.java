package com.restaurante.cardapio;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@EnableWebMvc
@SpringBootApplication
public class CardapioApplication {

	public static void main(String[] args) {
		SpringApplication.run(CardapioApplication.class, args);
	}

}
