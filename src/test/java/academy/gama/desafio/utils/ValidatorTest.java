/**
 * 
 */
package academy.gama.desafio.utils;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;

import academy.gama.desafio.model.Conta;
import academy.gama.desafio.model.Usuario;

/**
 * @author Kellison
 *
 */
class ValidatorTest {

	@BeforeAll
	static void init() {
		System.out.println("Inicializando testes: Validator");
	}
	
	@BeforeEach
	void executandoTests(TestInfo testInfo) {
		System.out.println("  Executando teste: " + testInfo.getDisplayName());
	}
	
	@Test
	@DisplayName("Validar objeto nulo ou vazio")
	void validarObjetoNuloComBoolean() {
		Conta conta = null;

		assertTrue(Validator.valorVazioOuNull(conta));
		
		String vazia = "";
		assertTrue(Validator.valorVazioOuNull(vazia));
	}
	
	@Test
	@DisplayName("Validar objeto nulo, retornando uma exception")
	void validarObjetoNuloComException() {

		Exception exception = assertThrows(Exception.class, () -> {
			Validator.valorVazioOuNull(new Conta().getNumero(), "O objeto não pode ser null");
		});
		
		assertEquals("O objeto não pode ser null", exception.getMessage());
		
	}

}
