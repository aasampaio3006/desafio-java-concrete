/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.org.desafiojavaconcrete.service;

import br.org.desafiojavaconcrete.model.Cliente;
import br.org.desafiojavaconcrete.repository.ClienteRepository;
import java.io.Serializable;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Andrade.Sampaio
 */
@Service
public class ClienteService implements Serializable{
    private static final long serialVersionUID = 1L;
    
    @Autowired
    private ClienteRepository repository;
    
    public Cliente save(@Valid Cliente cliente){
        Cliente clienteDto = new Cliente(cliente.getName(), cliente.getEmail(), cliente.getPassword(), cliente.getPhones());
        return repository.save(clienteDto);

        
        
        
        
    }
    
}
