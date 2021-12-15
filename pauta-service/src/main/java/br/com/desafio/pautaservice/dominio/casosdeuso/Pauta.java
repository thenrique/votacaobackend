package br.com.desafio.pautaservice.dominio.casosdeuso;

import br.com.desafio.pautaservice.dominio.casosdeuso.validacoes.ValidacoesDePautas;
import lombok.Getter;


import java.util.List;
import java.util.Objects;



public class Pauta {

    @Getter
    private String identificador;
    @Getter
    private String nome;

    private List<ValidacoesDePautas> validacoes;


    public Pauta(String identificador) {
        this.identificador = identificador;
    }
    public Pauta(String identificador, String nome) {
        this.identificador = identificador;
        this.nome = nome;
    }



    @Override
    public int hashCode() {
        return Objects.hash(identificador, nome);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pauta pauta = (Pauta) o;
        return Objects.equals(identificador, pauta.identificador) && Objects.equals(nome, pauta.nome) ;
    }


}
