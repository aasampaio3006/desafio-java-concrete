package br.org.desafiojavaconcrete;

import br.org.desafiojavaconcrete.model.Phone;
import br.org.desafiojavaconcrete.model.User;
import br.org.desafiojavaconcrete.model.Usuario;
import br.org.desafiojavaconcrete.service.UsuarioService;
import java.util.ArrayList;
import java.util.List;
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

    @Test
    public void testSave() {
        Phone dados = new Phone("1198457845", "11");
        List<Phone> listPhone = new ArrayList<Phone>();
        listPhone.add(dados);

        Usuario newUsuario = new Usuario("Andrade", "teste@gmail.com", "12456", listPhone);
        usuarioTeste = service.save(newUsuario);
        Assert.assertTrue("registros encontrados = 0", usuarioTeste.getName().equals("Andrade"));

    }

    @Test
    public void testFindEmail() {
        Usuario usuarioSaved = service.validaEmail(usuarioTeste.getEmail());
        Assert.assertTrue("registros nao encontrado na busca", usuarioSaved.getEmail().equals("teste@gmail.com"));
    }

    @Test
    public void testPassWord() {

        User user = new User("teste@gmail.com", "12456");
        Usuario usuario = service.validaEmail(usuarioTeste.getEmail());
        Assert.assertTrue("logado com sucesso",
                usuario != null && usuario.getPassword().equals(user.getPassword()));
    }

}
