package academy.gama.desafio.app;

<<<<<<< HEAD
import java.util.Optional;

=======
>>>>>>> 868dfb8c83602958d5d76cae4623b0f859318e53
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import academy.gama.desafio.exceptions.ContaExistenteException;
<<<<<<< HEAD
import academy.gama.desafio.exceptions.UsuarioNuloException;
import academy.gama.desafio.model.Conta;
import academy.gama.desafio.model.Usuario;
import academy.gama.desafio.repository.ContaRepository;
import academy.gama.desafio.repository.UsuarioRepository;
import academy.gama.desafio.service.ContaService;
=======
import academy.gama.desafio.model.Conta;
import academy.gama.desafio.model.Usuario;
import academy.gama.desafio.service.ContaService;
import academy.gama.desafio.service.UsuarioService;
>>>>>>> 868dfb8c83602958d5d76cae4623b0f859318e53

@Component
public class Sistema {
	@Autowired
	private ContaService contaService = new ContaService();
<<<<<<< HEAD

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
=======
	
	@Autowired
	UsuarioService UsuarioService = new UsuarioService();

	
	@Transactional
	public Usuario incluirUsuario(Usuario usuario) {
		try {			
		 return	UsuarioService.salvarUsuario(usuario);
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
		return null;
	}	
	
	@Transactional
	public void incluirConta(Usuario usuario) {
		try {
			contaService.adicionarConta(new Conta(usuario));
		} catch (ContaExistenteException e) {
			System.err.println("\nErro ao tentar adicionar conta ao usuario " + usuario.getNome() + ".");
			System.err.println(e.getMessage()+"\n");
		}	
>>>>>>> 868dfb8c83602958d5d76cae4623b0f859318e53
	}	
	
}
