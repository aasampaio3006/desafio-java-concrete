/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.org.desafiojavaconcrete.repository;

import br.org.desafiojavaconcrete.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Andrade.Sampaio
 */
@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long> {
    
    Cliente findByName(String name);
    Cliente findByEmail(String email);
} 
    

