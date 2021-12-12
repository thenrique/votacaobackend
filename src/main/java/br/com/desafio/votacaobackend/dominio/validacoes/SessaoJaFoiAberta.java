package br.com.desafio.votacaobackend.dominio.validacoes;

import br.com.desafio.votacaobackend.dominio.Pauta;

public class SessaoJaFoiAberta extends RuntimeException {

    public SessaoJaFoiAberta(Pauta pauta) {
        super("A sessao de pauta "+pauta.getIdentificador() + " já está aberta" );
    }
}
