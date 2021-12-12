package br.com.desafio.votacaobackend.aplicacao.dto;

import lombok.Data;
import lombok.Getter;

@Getter
public class PautaDto {

    private String identificador;
    private String nome;

    public PautaDto(String identificador, String nome) {
        this.identificador = identificador;
        this.nome = nome;
    }
}
