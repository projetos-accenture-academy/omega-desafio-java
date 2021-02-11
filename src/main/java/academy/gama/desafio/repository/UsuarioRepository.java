package academy.gama.desafio.repository;

import org.springframework.data.repository.CrudRepository;

import academy.gama.desafio.model.Usuario;

public interface UsuarioRepository extends CrudRepository<Usuario, Integer> {

	Usuario findByLogin(String login);

}
