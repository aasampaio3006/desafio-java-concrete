/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.org.desafiojavaconcrete;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Andrade.Sampaio
 */
@RestController
public class ClienteResource {
 @Autowired
    private ClienteRepository repository;
 
  @RequestMapping(value = "/add", method = RequestMethod.GET)
  public List<Cliente> add() {
     Cliente cliente = new Cliente("Andrade", "teste@gmail.com", "12456");
     repository.save(cliente);
     
    return repository.findAll();

  }
    
}
