package br.com.desafio.votacaobackend.dominio;

import lombok.Data;


public class Associado {

    private String cpf;


    public Associado( String cpf) {

        this.cpf = cpf;
    }

}
