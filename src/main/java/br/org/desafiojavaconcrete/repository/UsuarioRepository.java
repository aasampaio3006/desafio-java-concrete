/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.org.desafiojavaconcrete.repository;


import br.org.desafiojavaconcrete.model.Usuario;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Andrade.Sampaio
 */
@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    
    Usuario findByName(String name);
    Usuario findByEmail(String email);
    Usuario findById(UUID id);
    Usuario findByToken(String token);
            
} 
    

