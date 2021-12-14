package br.com.desafio.contabilizacaoservice.aplicacao.dto;


import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public class PautaDto {

    private String identificador;

    public PautaDto(String identificador) {
        this.identificador = identificador;
    }
}
