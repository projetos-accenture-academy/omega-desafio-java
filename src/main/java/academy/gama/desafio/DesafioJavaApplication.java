package academy.gama.desafio;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import academy.gama.desafio.app.Sistema;
<<<<<<< HEAD
import academy.gama.desafio.model.Conta;
=======
>>>>>>> 868dfb8c83602958d5d76cae4623b0f859318e53
import academy.gama.desafio.model.Usuario;

@SpringBootApplication
public class DesafioJavaApplication {

	public static void main(String[] args) {
		SpringApplication.run(DesafioJavaApplication.class, args);
	}

	@Bean
	public CommandLineRunner run(Sistema sistema) throws Exception {
		return args -> {
<<<<<<< HEAD
			Usuario user = new Usuario("ale", "senha123", "Alessandra Canuto1", "000.000.000-00");
			
			Usuario usuarioCriado = sistema.salvarUsuario(user);
			
			if(usuarioCriado != null) {
=======
			Usuario user = new Usuario("ale", "senha123", "Alessandra Canuto", "000.000.000-00");
			
			Usuario usuarioCriado = sistema.incluirUsuario(user);
			
			if(usuarioCriado != null) {
				System.out.println(usuarioCriado);
>>>>>>> 868dfb8c83602958d5d76cae4623b0f859318e53
				sistema.incluirConta(usuarioCriado);				
			}
		};
	}
		
}
