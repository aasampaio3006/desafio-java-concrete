/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.org.desafiojavaconcrete.resources;

import br.org.desafiojavaconcrete.model.Cliente;
import br.org.desafiojavaconcrete.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Andrade.Sampaio
 */
//@RequestMapping(value= "api/v1/")
@RestController
public class ClienteResource {
    
    @Autowired
    ClienteService service;
    
  @PostMapping
  public Cliente add(@RequestBody Cliente cliente){
      return service.save(cliente);
      
  }  

 

    
}
