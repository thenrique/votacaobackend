package br.com.desafio.votacaoservice.dominio.validacao;


import br.com.desafio.votacaoservice.dominio.Votacao;

public interface ValidacaoVotacao {

    void validar(Votacao votacao);
}
