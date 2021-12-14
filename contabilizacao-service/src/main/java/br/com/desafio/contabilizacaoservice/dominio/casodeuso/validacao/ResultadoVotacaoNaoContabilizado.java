package br.com.desafio.contabilizacaoservice.dominio.casodeuso.validacao;

public class ResultadoVotacaoNaoContabilizado extends RuntimeException {

    public ResultadoVotacaoNaoContabilizado(){
        super("O resultado da votação ainda não foi contabilizado.");
    }
}
