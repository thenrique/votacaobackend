package br.com.desafio.pautaservice.aplicacao.dto;


import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public class ResponsePautaDto {

    private String identificador;
    private String nome;



    public ResponsePautaDto(String identificador, String nome) {
        this.identificador = identificador;
        this.nome = nome;
    }
}
