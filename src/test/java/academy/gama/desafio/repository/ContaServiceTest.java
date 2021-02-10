package academy.gama.desafio.repository;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.FixMethodOrder;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.bind.Name;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit4.SpringRunner;

import academy.gama.desafio.exceptions.ContaExistenteException;
import academy.gama.desafio.model.Conta;
import academy.gama.desafio.model.Usuario;
import academy.gama.desafio.service.ContaService;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ContaServiceTest {

    @Autowired
    ContaService ContaService;
   
    @Autowired
    UsuarioRepository usuarioRepository;

	Usuario usuarioTeste = new Usuario("aabc", "123456", "A", "00100200399");
    
    @Test
    @DisplayName("Criar conta para um usuário")
    public void criarContaA() throws Exception {
        Usuario usuarioCriado = usuarioRepository.save(usuarioTeste);
        
    	assertNotNull(usuarioCriado);
    	
        assertNotNull(ContaService.adicionarConta(new Conta(usuarioCriado)));

    }
    
    @Test
    @DisplayName("Criar conta com número já existente para um usuário deve falhar")
    public void criarContaExistente() throws Exception {   
    	// Procura pelo usuário cadastrado no teste anterior para tentar adicionar uma nova conta
    	// com o mesmo número para este usuário
    	Usuario usuarioCriado = usuarioRepository.findByLogin(usuarioTeste.getLogin());
    	Conta conta = new Conta(usuarioCriado);

    	assertNotNull(usuarioCriado);
    	
        Exception exception = assertThrows(ContaExistenteException.class, () -> {
        	ContaService.adicionarConta(conta);
        });

        
        String expectedMessage = "Conta Nº " + conta.getNumero() + " já existe.";
        String actualMessage = exception.getMessage();
        
        assertTrue(actualMessage.contains(expectedMessage));

    }
}