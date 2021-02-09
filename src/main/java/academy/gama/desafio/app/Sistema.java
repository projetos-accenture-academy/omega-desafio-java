package academy.gama.desafio.app;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import academy.gama.desafio.model.Conta;
import academy.gama.desafio.model.Usuario;
import academy.gama.desafio.repository.ContaRepository;
import academy.gama.desafio.repository.UsuarioRepository;

@Component
public class Sistema {
	@Autowired
	private ContaRepository repository;
	
	@Transactional
	public void incluirConta() {
//		Usuario usuario = new Usuario("alessandra", "senha123", "Alessandra Canuto", "000.000.000-00"); 

		Conta conta = new Conta();
		conta.setNumero("gso1");
		//conta.setUsuario(usuario);
		
		//if(!repository.existsByNumero(conta.getNumero()))		
		
		repository.save(conta);	
	}
	
	@Autowired
	private UsuarioRepository usuarioRepository;

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
