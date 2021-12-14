package br.com.desafio.contabilizacaoservice.dominio.casodeuso.validacao;

public class ResultadoJaContabilizado extends RuntimeException {
    public ResultadoJaContabilizado() {
        super("O resultado da pauta já foi contabilizado");
    }
}
