package academy.gama.desafio.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import academy.gama.desafio.model.Conta;

@Repository
public interface ContaRepository extends CrudRepository<Conta, Integer> {
	
	boolean existsByNumero(String numero);
}
