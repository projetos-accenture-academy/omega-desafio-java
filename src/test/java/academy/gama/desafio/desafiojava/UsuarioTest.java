package academy.gama.desafio.desafiojava;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import academy.gama.desafio.model.Usuario;
import academy.gama.desafio.repository.UsuarioRepository;

@SpringBootTest
class UsuarioTest {

	@Autowired
	private Usuario usuario;
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@BeforeEach
	void setUp() throws Exception {
		usuario = new Usuario();		
	}

	@Test
	void testAddUsuario() {
		usuario.setNome("Alessandra");
		usuario.setCpf("000.000.000-00");
		usuario.setLogin("acanuto");
		usuario.setSenha("123456");
		assertTrue(usuarioRepository.save(usuario) != null);		
	}
	
	@Test
	void testAddUsuarioInvalido() {
		usuario.setNome("Alessandra");
		usuario.setCpf("000.000.000-00");
		usuario.setLogin("acanuto");
		usuario.setSenha("123");
		assertFalse(usuarioRepository.save(usuario) != null, String.join(", ", usuario.getListError()));
	}
	
	@Test
	void testAddUsuarioCadastrado() {
		usuario.setNome("Alessandra");
		usuario.setCpf("000.000.000-00");
		usuario.setLogin("acanuto");
		usuario.setSenha("123456");
		assertTrue(usuarioRepository.save(usuario) != null);		
		assertTrue(usuarioRepository.existsById(usuario.getId()), "teste");
	}

}
