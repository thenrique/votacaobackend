package br.com.desafio.exibirresultadoservice.aplicacao.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@NoArgsConstructor
@Getter
@AllArgsConstructor
public class PautaDto {

    @NotEmpty @NotNull
    private String identificador;

}
