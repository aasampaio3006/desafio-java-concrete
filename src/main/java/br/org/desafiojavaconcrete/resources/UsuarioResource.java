/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.org.desafiojavaconcrete.resources;

import br.org.desafiojavaconcrete.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import br.org.desafiojavaconcrete.response.Response;
import br.org.desafiojavaconcrete.service.UsuarioService;
import br.org.desafiojavaconcrete.model.Usuario;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
/**
 *
 * @author Andrade.Sampaio
 */
@RequestMapping(value = "api/v1/")
@RestController
public class UsuarioResource {

    private final Logger logger = LoggerFactory.getLogger(UsuarioResource.class);

    @Autowired
    UsuarioService service;

    /**
     * POST / : register usuario.
     *
     * body:{ "name": value "email": value "password": value "phones":[ {
     * "number": value "ddd": value } ] }
     *
     * @param {Usuario} - Usuario object
     *
     * @return 200 - OK and Usuario created
     *
     */
    @PostMapping(value = "create")
    public ResponseEntity add(@RequestBody Usuario usuario) {

        logger.debug("REST request to save Tool : {}", usuario);        
        
        if (service.validaEmail(usuario.getEmail()) != null) {
             Response response = new Response();
             response.setMensagem("E-mail já existente");
            return ResponseEntity.badRequest().body(response);
        }
        return ResponseEntity.status(HttpStatus.OK).body(service.save(usuario));

    }

    /**
     * POST / : check usuario.
     *
     * body:{ "email": value "password": value }
     *
     * @param {email} - Email Usuario
     * @param {password} - Password Usuario
     *
     * @return 200 - OK
     * @return 401 - Invalid user and or password
     * @return 401 - Invalid user and or password
     *
     */
    @PostMapping(value = "access")
    public ResponseEntity access(@RequestBody User user) {

        logger.debug("REST request validate access : {}", user);
        Usuario usuario = service.validaEmail(user.getEmail());
        Response response = new Response();
        if (usuario != null && usuario.getPassword().equals(user.getPassword())) {
            return ResponseEntity.ok().body(usuario);           
        } else {
            response.setMensagem("Usuário e/ou senha inválidos");
           return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(response);
        }
       

    }
}
