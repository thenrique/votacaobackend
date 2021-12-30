package br.com.desafio.votacaoservice.aplicacao.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Getter
@NoArgsConstructor
public class VotoDto {

    @NotNull
    @NotEmpty
    private String identificadorAssociado;
    @NotNull
    private Boolean voto;
    @NotNull @NotEmpty
    private String identificadorPauta;

    public VotoDto(String identificadorAssociado, Boolean voto, String identificadorPauta) {
        this.identificadorAssociado = identificadorAssociado;
        this.voto = voto;
        this.identificadorPauta = identificadorPauta;
    }

}
