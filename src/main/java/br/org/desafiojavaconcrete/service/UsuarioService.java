/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.org.desafiojavaconcrete.service;

import br.org.desafiojavaconcrete.model.User;
import br.org.desafiojavaconcrete.model.Usuario;
import br.org.desafiojavaconcrete.repository.UsuarioRepository;
import br.org.desafiojavaconcrete.response.Response;
import java.io.Serializable;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

/**
 *
 * @author Andrade.Sampaio
 */
@Service
public class UsuarioService implements Serializable {

    private static final long serialVersionUID = 1L;

    @Autowired
    private UsuarioRepository repository;

    public Usuario save(@Valid Usuario usuario) {
        Usuario newUsuario = new Usuario(usuario.getName(), usuario.getEmail(), usuario.getPassword(), usuario.getPhones());
        Usuario user = repository.save(newUsuario);
        return createToken(user);      
    }

    public Usuario validaEmail(String email) {
        return repository.findByEmail(email);
    }

    public Usuario createToken(Usuario usuario) {
        usuario.setToken(usuario.getId());
        Usuario user = repository.save(usuario);
        return user;
    }
    
    
}
