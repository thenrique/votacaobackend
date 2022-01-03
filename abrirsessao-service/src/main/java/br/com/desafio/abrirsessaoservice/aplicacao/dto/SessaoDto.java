package br.com.desafio.abrirsessaoservice.aplicacao.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

@Getter
@NoArgsConstructor
public class SessaoDto {

    @NotBlank @NotEmpty
    private String identificadorPauta;

    @NotBlank @NotEmpty
    private Long duracao;

    public SessaoDto(String identificadorPauta, Long duracao) {
        this.identificadorPauta = identificadorPauta;
        this.duracao = duracao;
    }

}
