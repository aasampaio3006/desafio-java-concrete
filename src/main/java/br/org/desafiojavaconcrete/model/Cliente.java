/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.org.desafiojavaconcrete.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author Andrade.Sampaio
 */
@Entity
@Table(name = "cliente")
public class Cliente implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue
    @Column(columnDefinition = "uuid", updatable = false)
    private UUID id;

    @Column(name = "name")
    private String name;
    @Column(name = "email")
    private String email;
    @Column(name = "password")
    private String password;
    @Column(name = "created")
    private LocalDate created;
    @Column(name = "modified")
    private LocalDate modified;
    @Column(name = "last_login")
    private LocalDate lastLogin;
    @Column(name = "token")
    private String token;

   @ElementCollection()
   private List<Phone> phones = new ArrayList<Phone>();
   
    public Cliente(){
        
    }
    
    public Cliente(String name, String email, String password, List phone) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.created = LocalDate.now().minusDays(10);
        this.phones = phone;        
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public UUID getId() {
        return id;
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

    public LocalDate getCreated() {
        return created;
    }

    public LocalDate getModified() {
        return modified;
    }

    public LocalDate getLastLogin() {
        return lastLogin;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public List<Phone> getPhones() {
        return phones;
    }

    @Override
    public String toString() {
        return "Cliente{" + "id=" + id + ", name=" + name + ", email=" + email + ", password=" + password + ", created=" + created + ", modified=" + modified + ", lastLogin=" + lastLogin + ", token=" + token + ", phones=" + phones + '}';
    }
    
    

}
