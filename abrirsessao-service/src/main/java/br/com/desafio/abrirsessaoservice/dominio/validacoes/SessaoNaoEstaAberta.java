package br.com.desafio.abrirsessaoservice.dominio.validacoes;

import br.com.desafio.abrirsessaoservice.dominio.Pauta;


public class SessaoNaoEstaAberta extends RuntimeException {
    public SessaoNaoEstaAberta(Pauta pauta) {
        super("A sessão da pauta não está aberta data início " + pauta.getSessao().getDataAbertura() + " datafim" + pauta.getSessao().getDataEncerramento());
    }
}
