package br.org.desafiojavaconcrete;


import br.org.desafiojavaconcrete.repository.UsuarioRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DesafioJavaConcreteApplicationTests {

    @Autowired
    private UsuarioRepository repository;
    
	@Test
	public void contextLoads() {
       // Usuario cliente = new Cliente("Andrade", "teste@gmail.com", "12456");
       // repository.save(cliente);
       // Assert.assertTrue("registros encontrados = 0", repository.count() > 0);
            
         // read
       // Cliente clienteSaved = repository.findByNome("Andrade");
       // Assert.assertNotNull("registros nao encontrado", clienteSaved);
	}

}
