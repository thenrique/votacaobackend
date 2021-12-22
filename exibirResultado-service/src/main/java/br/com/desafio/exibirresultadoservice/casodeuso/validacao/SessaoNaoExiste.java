package br.com.desafio.exibirresultadoservice.casodeuso.validacao;

public class SessaoNaoExiste extends RuntimeException {
    public SessaoNaoExiste(String identificadorPauta) {
        super("A sessão da pauta não est");
    }
}
