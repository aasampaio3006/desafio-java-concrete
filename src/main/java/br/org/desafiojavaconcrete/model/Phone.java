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

class Phone implements Serializable{
     private static final long serialVersionUID = 1L;

    private String number;
    private String ddd;


    public Phone(String number, String ddd) {
        this.number = number;
        this.ddd = ddd;
    }

    /**
     * @return the number
     */
    public String getNumber() {
        return number;
    }

    /**
     * @return the ddd
     */
    public String getDdd() {
        return ddd;
    }

    @Override
    public String toString() {
        return "Phone{" + "number=" + number + ", ddd=" + ddd + '}';
    }
    
}
