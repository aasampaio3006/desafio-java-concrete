/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.org.desafiojavaconcrete.response;

import java.io.Serializable;

/**
 *
 * @author Andrade.Sampaio
 */
public class Response<T> implements Serializable {

    private static final long serialVersionUID = 1L;

    private T mensagem;

    public Response() {
    }

    public T getMensagem() {
        return mensagem;
    }

    public void setMensagem(T mensagem) {
        this.mensagem = mensagem;
    }
}
