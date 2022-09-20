package com.example.demo;

import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class GraphQlDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(GraphQlDemoApplication.class, args);
	}

	@Bean
	ApplicationRunner applicationRunner(AuthorRepository authorRepository, BookRepository bookRepository) {
		return args -> {
			Author haider = authorRepository.save(new Author("Haider"));
			Author girish = authorRepository.save(new Author("Girish"));

			bookRepository.saveAll(List.of(
					new Book("Java", "Amdocs", haider),
					new Book("Apache Sparks", "amdocs", girish)
			));
		};
	}

}
