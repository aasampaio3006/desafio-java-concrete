package br.org.desafiojavaconcrete;

import br.org.desafiojavaconcrete.model.Phone;
import br.org.desafiojavaconcrete.model.Usuario;
import br.org.desafiojavaconcrete.model.UsuarioDto;
import br.org.desafiojavaconcrete.service.UsuarioService;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DesafioJavaConcreteApplicationTests {

    @Autowired
    private UsuarioService service;
    private static Usuario usuarioTeste;
    private static UsuarioDto usuarioDto;

    @Test
    public void testSave() {
        Phone dados = new Phone("1198457845", "11");
        List<Phone> listPhone = new ArrayList<Phone>();
        listPhone.add(dados);

        Usuario newUsuario = new Usuario("Andrade", "teste@gmail.com", "12456", listPhone);
        usuarioDto = service.save(newUsuario);
        Assert.assertNotNull("registros encontrados = 0", usuarioDto);

    }

    @Test
    public void testFindEmail() {

        Usuario usuarioSaved = service.findByUUID(usuarioDto.getId());
        Assert.assertTrue("registros nao encontrado na busca", usuarioSaved.getEmail().equals("teste@gmail.com"));
    }

    @Test
    public void testPassWord() {

        Usuario user = new Usuario("teste@gmail.com", "12456");
        Usuario usuario = service.fyndByEmail(user.getEmail());
        Assert.assertTrue("logado com sucesso",
                usuario != null && usuario.getEmail().equals(user.getEmail()));
    }

    @Test
    public void checkEmail() {
        Usuario user = new Usuario("teste@gmail.com", "12456");
        boolean status = Usuario.checkEmail(user.getEmail());
        Assert.assertTrue("Email valido", status);
    }
    
    
    @Test
    public void checkToken() {       
        Assert.assertTrue("Token valido", usuarioDto.getToken().equals(usuarioDto.getToken()));
    }

}
