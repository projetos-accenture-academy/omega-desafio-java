package academy.gama.desafio.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import academy.gama.desafio.model.Conta;
import academy.gama.desafio.model.Usuario;
import academy.gama.desafio.service.ContaService;
import academy.gama.desafio.service.UsuarioService;


@Component
public class Sistema {
	@Autowired
	private ContaService contaService = new ContaService();
	
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
	public void incluirConta(Usuario usuario){
		try {
			contaService.adicionarConta(new Conta(usuario, usuario.getLogin()));
		} catch (Exception e) {
			System.err.println("\nErro ao tentar adicionar conta ao usuario " + usuario.getNome() + ".");
			System.err.println(e.getMessage()+"\n");
		}
	}
	
}
