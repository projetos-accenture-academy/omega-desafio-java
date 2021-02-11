package academy.gama.desafio.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

import org.springframework.data.repository.CrudRepository;

import academy.gama.desafio.model.Conta;
import academy.gama.desafio.model.PlanoContas;
import academy.gama.desafio.model.Usuario;

public interface PlanoContasRepository extends JpaRepository<PlanoContas, Long> {

	
}
