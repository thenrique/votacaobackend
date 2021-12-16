package br.com.desafio.votacaoservice.aplicacao.dto;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class VotoDto {

    private String identificadorAssociado;
    private boolean voto;
    private String identificadorPauta;

    public VotoDto(String identificadorAssociado, boolean voto, String identificadorPauta) {
        this.identificadorAssociado = identificadorAssociado;
        this.voto = voto;
        this.identificadorPauta = identificadorPauta;
    }

    public String getIdentificadorPauta() {
        return identificadorPauta;
    }

    public String getIdentificadorAssociado() {
        return identificadorAssociado;
    }

    public boolean isVoto() {
        return voto;
    }
}
