package br.com.desafio.abrirsessaoservice.dominio.validacoes;


import br.com.desafio.abrirsessaoservice.dominio.Sessao;

public class SessaoNaoEstaAberta extends RuntimeException {
    public SessaoNaoEstaAberta(Sessao sessao) {
        super("A sessão da pauta não está aberta data início " + sessao.getDataAbertura() + " data fim" + sessao.getDataEncerramento());
    }
}
