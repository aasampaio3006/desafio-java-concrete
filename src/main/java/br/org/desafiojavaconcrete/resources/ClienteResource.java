/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.org.desafiojavaconcrete.resources;

import br.org.desafiojavaconcrete.service.ClienteService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import br.org.desafiojavaconcrete.model.ClienteDto;
import br.org.desafiojavaconcrete.response.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;

/**
 *
 * @author Andrade.Sampaio
 */
@RequestMapping(value = "api/v1/")
@RestController
public class ClienteResource {

    private final Logger logger = LoggerFactory.getLogger(ClienteResource.class);
    @Autowired
    ClienteService service;

    @PostMapping(value = "add")

    public ResponseEntity<Response> add(@RequestBody ClienteDto clienteDto, BindingResult result) {

        logger.debug("REST request to save Tool : {}", clienteDto);
        
        Response response = new Response();
        
        String email = clienteDto.getEmail();
        
        if (service.validaEmail(email) != null) {
            Response msgErro = new Response();
            msgErro.setMensagem("E-mail já existente");
            return ResponseEntity.badRequest().body(msgErro);
        }

        response.setMensagem(clienteDto);
        service.save(clienteDto);

        return ResponseEntity.ok(response);
        

    }

}
