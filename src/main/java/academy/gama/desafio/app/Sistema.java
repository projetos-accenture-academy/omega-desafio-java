package academy.gama.desafio.app;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import academy.gama.desafio.exceptions.ContaExistenteException;
import academy.gama.desafio.exceptions.UsuarioNuloException;
import academy.gama.desafio.model.Conta;
import academy.gama.desafio.model.Usuario;
import academy.gama.desafio.repository.ContaRepository;
import academy.gama.desafio.repository.UsuarioRepository;
import academy.gama.desafio.service.ContaService;

@Component
public class Sistema {
	@Autowired
	private ContaService contaService = new ContaService();

	@Autowired
	private UsuarioRepository usuarioRepository;

	@Transactional
	public void incluirConta(Usuario usuario){
		try {
			contaService.adicionarConta(new Conta(usuario, usuario.getLogin()));
		} catch (Exception e) {
			System.err.println("\nErro ao tentar adicionar conta ao usuario " + usuario.getNome() + ".");
			System.err.println(e.getMessage()+"\n");
		}
	}
	
	@Transactional
	public Usuario salvarUsuario(Usuario user) {
		if (!usuarioRepository.existsById(user.getId()) && user.valid()) {
			return usuarioRepository.save(user);
		}
		
		return null;
		
	}	
	
	@Transactional
	public void deletarUsuario(Usuario user) {
		usuarioRepository.delete(user);
	}
	
	@Transactional
	public void deletarUsuarioById(int id) {
		usuarioRepository.deleteById(id);
	}

	@Transactional
	public Optional<Usuario> findUsuarioById(int id) {
		return usuarioRepository.findById(id);
	}
	
	@Transactional
	public Optional<Usuario> findUsuarioByLogin(String login) {
		return usuarioRepository.findByLogin(login);
	}
	
	@Transactional
	public Iterable<Usuario> FindAllUsuarios() {
		return usuarioRepository.findAll();
	}	
	
}
