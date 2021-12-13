package br.com.desafio.votacaobackend.dominio.casosdeuso;

import br.com.desafio.votacaobackend.aplicacao.dto.SessaoDto;

public interface AbrirSessaoVotacao {
    void execute(SessaoDto sessaoDto);
}
