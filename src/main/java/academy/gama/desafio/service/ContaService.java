package academy.gama.desafio.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import academy.gama.desafio.exceptions.ContaExistenteException;
import academy.gama.desafio.model.Conta;
import academy.gama.desafio.model.Usuario;
import academy.gama.desafio.repository.ContaRepository;

@Component
public class ContaService{
	@Autowired
	private ContaRepository contaRepository;

	/**
	 * Realiza a inserção de uma conta, validando se já existe ou não uma conta
	 * com o mesmo número
	 * 
	 * @param conta Conta a ser inserida
	 * @throws ContaExistenteException
	 */
	public Conta adicionarConta(Conta conta) throws ContaExistenteException{
		boolean contaExistente = contaRepository.existsByNumero(conta.getNumero());

		if (!contaExistente)
			return contaRepository.save(conta);
		else
			throw new ContaExistenteException("Conta Nº " + conta.getNumero() + " já existe.");
		
	}

	/**
	 * Obtém todas as contas cadastradas
	 * @return Iterable<Conta>
	 */
	public Iterable<Conta> getTodasContas(){
		return contaRepository.findAll();
	}

	/**
	 * Busca as contas pertecentes à um usuário específico
	 * @param usuario
	 * @return List<Conta>
	 */
	public List<Conta> getContasPorUsuario(Usuario usuario) {
		return contaRepository.findByUsuario(usuario);
	}
	
	public Conta getConta(String numero) {
		return contaRepository.findByNumero(numero);
	}

	
	public void removerConta(Conta conta) {
		contaRepository.delete(conta);
	}
	
}
