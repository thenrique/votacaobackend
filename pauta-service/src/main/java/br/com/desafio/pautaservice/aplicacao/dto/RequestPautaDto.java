package br.com.desafio.pautaservice.aplicacao.dto;


import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@NoArgsConstructor
@Getter
public class RequestPautaDto {

    @NotNull @NotEmpty
    private String identificador;
    private String nome;



    public RequestPautaDto(String identificador, String nome) {
        this.identificador = identificador;
        this.nome = nome;
    }
}
