package br.com.desafio.votacaobackend.dominio.casosdeuso;

import br.com.desafio.votacaobackend.aplicacao.dto.VotoDto;
import br.com.desafio.votacaobackend.dominio.validacoes.SessaoNaoEstaAberta;

public interface CadastrarVoto {
    void execute(VotoDto votoDto) throws SessaoNaoEstaAberta;
}
