package br.com.desafio.votacaoservice.dominio.event;

import br.com.desafio.votacaoservice.dominio.Votacao;

public interface AcoesEventos {

    public void execute( Votacao votacao);
}
