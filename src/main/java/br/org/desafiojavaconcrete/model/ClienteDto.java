/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.org.desafiojavaconcrete.model;


import java.util.ArrayList;
import java.util.List;


/**
 *
 * @author Andrade.Sampaio
 */
public class ClienteDto {
    
    
    private String name;  
    private String email;   
    private String password;
     private List<Phone> phones = new ArrayList<Phone>();
    
    public ClienteDto(String name, String email, String password, List phone) {
        this.name = name;
        this.email = email;
        this.password = password;    
        this.phones = phone;        
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public List<Phone> getPhones() {
        return phones;
    }

    @Override
    public String toString() {
        return "ClienteDTO{" + "name=" + name + ", email=" + email + ", password=" + password + ", phones=" + phones + '}';
    }
    
    
    
    
}
