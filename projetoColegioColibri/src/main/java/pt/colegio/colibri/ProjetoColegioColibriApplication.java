package pt.colegio.colibri;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//esta classe é essencial para iniciar uma aplicação Spring Boot. Ela utiliza a anotação @SpringBootApplication para
// indicar ao Spring Boot que esta é a classe principal da aplicação, permitindo que o framework configure
// automaticamente a aplicação e inicie os serviços necessários.

@SpringBootApplication
public class ProjetoColegioColibriApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProjetoColegioColibriApplication.class, args);
	}
}
