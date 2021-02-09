package academy.gama.desafio;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import academy.gama.desafio.app.Sistema;
import academy.gama.desafio.model.Usuario;

@SpringBootApplication
public class DesafioJavaApplication {

	public static void main(String[] args) {
		SpringApplication.run(DesafioJavaApplication.class, args);
	}

	@Bean
	public CommandLineRunner run(Sistema sistema) throws Exception {
		return args -> {
			sistema.incluirConta();		
			Usuario user = new Usuario("alessandra", "senha123", "Alessandra Canuto1", "000.000.000-00");
			sistema.salvarUsuario(user);
		};
	}
		
}
