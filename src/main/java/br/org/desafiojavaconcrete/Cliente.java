/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.org.desafiojavaconcrete;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;

/**
 *
 * @author Andrade.Sampaio
 */

@Entity
@Table(name = "customers")
public class Cliente implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "nome")
    private String nome;

    @Column(name = "email")
    private String email;
    @Column(name = "password")
    private String password;

    // @ElementCollection
    //private List<Phone> phones = new ArrayList<Phone>();
    public Cliente(String nome, String email, String password) {
        this.nome = nome;
        this.email = email;
        this.password = password;
        // this.phones = phone;        
    }

    public Long getId() {
        return this.id;
    }

    /**
     * @return the nome
     */
    public String getNome() {
        return nome;
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    @Override
    public String toString() {
        return "Cliente{" + "id=" + id + ", nome=" + nome + ", email=" + email + ", password=" + password + '}';
    }

    /**
     * @return the phones
     */
//    public List<Phone> getPhones() {
//        return phones;
//    }
//    @Override
//    public String toString() {
//        return "Cliente{" + "nome=" + nome + ", email=" + email + ", password=" + password + ", phones=" + phones + '}';
//    }
}
