/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.org.desafiojavaconcrete.resources;

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
import br.org.desafiojavaconcrete.model.UsuarioDto;
import br.org.desafiojavaconcrete.utils.SenhaUtils;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.UUID;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author Andrade.Sampaio
 */
@RequestMapping(value = "api/v1/")
@RestController
public class UsuarioResource {

    private final Logger logger = LoggerFactory.getLogger(UsuarioResource.class);
    private UsuarioDto usuarioDto;
    
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
        Response response = new Response();
        logger.debug("REST request to save Tool : {}", usuario);

        if (usuario.getName().isEmpty() || usuario.getPassword().isEmpty()) {
            response.setMensagem("Os campos nome e/ou password não podem se vazio!");
            return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).body(response);
        }

        if (!Usuario.checkEmail(usuario.getEmail())) {
            response.setMensagem("Digite um email valido!");
            return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).body(response);
        }

        if (service.fyndByEmail(usuario.getEmail()) != null) {
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
    public ResponseEntity access(@RequestBody Usuario user) {

        logger.debug("REST request validate access : {}", user);
        Usuario usuario = service.fyndByEmail(user.getEmail());
        Response response = new Response();
        if (usuario != null && (SenhaUtils.senhaValida(user.getPassword(), usuario.getPassword())) == true) {

            usuarioDto = new UsuarioDto(usuario.getId(), usuario.getCreated(),
                    usuario.getModified(), usuario.getLast_login(), usuario.getToken());

            return ResponseEntity.ok().body(usuarioDto);
        } else {
            response.setMensagem("Usuário e/ou senha inválidos");
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(response);
        }

    }

    /**
     * POST / : check token.
     *
     * body:{ "token": value}
     *
     * @param {id} - Id Usuario
     * 
     *
     * @return 200 - OK
     * @return 401 - Invalid user and or password
     * @return 401 - Invalid user and or password
     * 
     *
     */
    @PostMapping(value = "token")
    public ResponseEntity token(@RequestHeader(value = "token") String token, @RequestParam String id) {

        logger.debug("REST request validate access : {}", token);
        Response response = new Response();

        if (token.isEmpty() || id.isEmpty()) {
            response.setMensagem("Os campo token e/ou id não podem se vazio!");
            return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).body(response);
        }

        Usuario user = service.validaToken(token);

        if (user == null) {
            response.setMensagem("Não autorizado");
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(response);
        }

        UUID uuid = UUID.fromString(id);

        Usuario userUUid = service.findByUUID(uuid);

        if (userUUid == null) {
            response.setMensagem("Não autorizado");
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(response);
        }

        if (userUUid.getToken().equals(token)) {

            LocalDateTime dataNow = LocalDateTime.now();
            LocalDateTime lastLogin = userUUid.getLast_login();
            Duration duracao = Duration.between(dataNow, lastLogin);

            if (duracao.toMinutes() > 30) {
                response.setMensagem("Sessão inválida");
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(response);
            } else {

                usuarioDto = new UsuarioDto(userUUid.getId(), userUUid.getCreated(),
                        userUUid.getModified(), userUUid.getLast_login(), userUUid.getToken());
                return ResponseEntity.ok().body(usuarioDto);
            }

        } else {
            response.setMensagem("Não autorizado");
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(response);

        }
    }

}
