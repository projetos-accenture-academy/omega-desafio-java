package academy.gama.desafio.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import academy.gama.desafio.model.Usuario;
import academy.gama.desafio.repository.UsuarioRepository;

@Component
public class UsuarioService {

	@Autowired
	private UsuarioRepository usuarioRepository;

	public Usuario salvarUsuario(Usuario user) throws Exception {
		if (usuarioRepository.existsById(user.getId())) {
			throw new Exception("Usuário já cadastrado!");
		} else if (!user.valid()) {
			throw new Exception(
					String.format("Falha ao inserir usuário: {0}{1}", System.lineSeparator(), user.getListError()));
		} else {
			return usuarioRepository.save(user);
		}
	}
	
	public Usuario alterarUsuario(Usuario user) throws Exception {
		if (!usuarioRepository.existsById(user.getId())) {
			throw new Exception("Usuário não cadastrado!");
		} else if (!user.valid()) {
			throw new Exception(
					String.format("Falha ao alterar usuário: {0}{1}", System.lineSeparator(), user.getListError()));
		} else {
			return usuarioRepository.save(user);
		}
	}
	
	public void deletarUsuario(Usuario user) {
		usuarioRepository.delete(user);
	}

	public void deletarUsuarioById(int id) {
		usuarioRepository.deleteById(id);
	}

	public Optional<Usuario> findUsuarioById(int id) {
		return usuarioRepository.findById(id);
	}

	public Usuario findUsuarioByLogin(String login) {
		return usuarioRepository.findByLogin(login);
	}

	public Iterable<Usuario> FindAllUsuarios() {
		return usuarioRepository.findAll();
	}

}
