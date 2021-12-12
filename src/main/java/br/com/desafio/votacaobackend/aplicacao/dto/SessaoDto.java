package br.com.desafio.votacaobackend.aplicacao.dto;

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
