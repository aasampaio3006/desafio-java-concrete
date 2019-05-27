package br.org.desafiojavaconcrete.model;


import java.io.Serializable;
import java.util.Objects;
/**
 *
 * @author Andrade.Sampaio
 */

public class Phone implements Serializable{
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

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 97 * hash + Objects.hashCode(this.number);
        hash = 97 * hash + Objects.hashCode(this.ddd);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Phone other = (Phone) obj;
        if (!Objects.equals(this.number, other.number)) {
            return false;
        }
        if (!Objects.equals(this.ddd, other.ddd)) {
            return false;
        }
        return true;
    }
    
    
    
}
