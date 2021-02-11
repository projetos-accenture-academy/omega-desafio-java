package academy.gama.desafio.repository;

<<<<<<< HEAD
import java.util.Optional;

=======
>>>>>>> 868dfb8c83602958d5d76cae4623b0f859318e53
import org.springframework.data.repository.CrudRepository;

import academy.gama.desafio.model.Usuario;

public interface UsuarioRepository extends CrudRepository<Usuario, Integer> {

<<<<<<< HEAD
	
	Optional<Usuario> findByLogin(String login);
	
}
=======
	Usuario findByLogin(String login);

}
>>>>>>> 868dfb8c83602958d5d76cae4623b0f859318e53
