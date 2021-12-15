package br.com.desafio.votacaobackend.dominio.validacoes;

import br.com.desafio.votacaobackend.dominio.Pauta;


public class SessaoNaoEstaAberta extends RuntimeException {
    public SessaoNaoEstaAberta() {
        super("A sessão da pauta não está aberta");
    }
}
