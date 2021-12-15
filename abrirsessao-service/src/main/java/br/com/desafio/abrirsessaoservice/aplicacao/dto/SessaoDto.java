package br.com.desafio.abrirsessaoservice.aplicacao.dto;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class SessaoDto {

    private String identificadorPauta;
    private Long duracao;

    public SessaoDto(String identificadorPauta, Long duracao) {
        this.identificadorPauta = identificadorPauta;
        this.duracao = duracao;
    }

    public Long getDuracao() {
        return duracao;
    }

    public String getIdentificadorPauta() {
        return identificadorPauta;
    }
}
