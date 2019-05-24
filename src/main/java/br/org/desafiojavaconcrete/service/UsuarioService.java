/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.org.desafiojavaconcrete.service;


import br.org.desafiojavaconcrete.model.Usuario;
import br.org.desafiojavaconcrete.model.UsuarioDto;
import br.org.desafiojavaconcrete.repository.UsuarioRepository;
import br.org.desafiojavaconcrete.utils.SenhaUtils;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.UUID;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Andrade.Sampaio
 */
@Service
public class UsuarioService implements Serializable {

    private static final long serialVersionUID = 1L;
    private UsuarioDto usuarioDto;

    @Autowired
    private UsuarioRepository repository;

    public UsuarioDto save(Usuario usuario) {
        String senhaEncoded = SenhaUtils.gerarBCrypt(usuario.getPassword());         
        
        Usuario newUsuario = new Usuario(usuario.getName(), usuario.getEmail(), senhaEncoded, usuario.getPhones());
        
        Usuario user = repository.save(newUsuario);
        
        Usuario userUpdate = createToken(user);
         usuarioDto = new UsuarioDto(userUpdate.getId(), userUpdate.getCreated(), 
                                     userUpdate.getModified(), userUpdate.getLast_login(), userUpdate.getToken());
         
         
        return usuarioDto;      
    }

    public Usuario fyndByEmail(String email) {
        return repository.findByEmail(email);
    }

    public Usuario createToken(Usuario usuario) {        
        String senhaEncoded = SenhaUtils.gerarBCrypt(usuario.getId().toString());
        usuario.setToken(senhaEncoded);
        Usuario user = repository.save(usuario);
        return user;
    }

    public Usuario validaToken(String token) {        
        return repository.findByToken(token);
    }
    public Usuario findByUUID(UUID id) {        
        return repository.findById(id);
    }
    
    
    
    
}
