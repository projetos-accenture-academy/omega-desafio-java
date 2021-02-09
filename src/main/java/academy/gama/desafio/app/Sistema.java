package academy.gama.desafio.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import academy.gama.desafio.model.Conta;
import academy.gama.desafio.model.Usuario;
import academy.gama.desafio.repository.ContaRepository;

@Component
public class Sistema {
	@Autowired
	private ContaRepository repository;
	
	@Transactional
	public void incluirConta() {
		Usuario usuario = new Usuario("Joaquim", "00000000000");

		Conta conta = new Conta();
		conta.setNumero("gso1");
		//conta.setUsuario(usuario);
		
		//if(!repository.existsByNumero(conta.getNumero()))		
		
		repository.save(conta);	
	}
}
