/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.org.desafiojavaconcrete.model;

import java.io.Serializable;

/**
 *
 * @author Andrade.Sampaio
 */
public class User implements Serializable{
    private static final long serialVersionUID = 1L;
       
    private String email;
    private String password;

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    
}
