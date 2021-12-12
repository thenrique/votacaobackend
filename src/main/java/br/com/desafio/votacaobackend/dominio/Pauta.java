package br.com.desafio.votacaobackend.dominio;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

public class Pauta {

    private String identificador;
    private String nome;

    private Sessao sessao;

    private Set<Votacao> votos = new HashSet();


    public Pauta(String identificador) {
        this.identificador = identificador;
    }
    public Pauta(String identificador, String nome) {
        this.identificador = identificador;
        this.nome = nome;
    }

    public String getIdentificador() {
        return identificador;
    }

}
