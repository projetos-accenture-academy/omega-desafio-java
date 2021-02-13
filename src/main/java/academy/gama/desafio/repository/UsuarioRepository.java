package academy.gama.desafio.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import academy.gama.desafio.model.Usuario;

public interface UsuarioRepository extends CrudRepository<Usuario, Integer> {

	
	Optional<Usuario> findByLogin(String login);
	
}
