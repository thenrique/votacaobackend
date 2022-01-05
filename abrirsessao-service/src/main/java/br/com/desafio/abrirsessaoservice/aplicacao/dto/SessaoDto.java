package br.com.desafio.abrirsessaoservice.aplicacao.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Getter
@NoArgsConstructor
public class SessaoDto {

    @NotBlank @NotEmpty
    private String identificadorPauta;

    @NotNull @Min(1)
    private Long duracao;

    public SessaoDto(String identificadorPauta, Long duracao) {
        this.identificadorPauta = identificadorPauta;
        this.duracao = duracao;
    }

}
