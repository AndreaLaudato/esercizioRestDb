package com.azienda.esercizioRestDB.bin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages  = "com.azienda.esercizioRestDB")
@EnableJpaRepositories(basePackages = "com.azienda.esercizioRestDB.repository")
@EntityScan(basePackages = "com.azienda.esercizioRestDB.model")
public class EsercizioRestDBApplication {

	public static void main(String[] args) {
		SpringApplication.run(EsercizioRestDBApplication.class, args);


	}

}
