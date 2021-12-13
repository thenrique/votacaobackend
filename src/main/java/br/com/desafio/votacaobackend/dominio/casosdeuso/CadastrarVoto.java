package br.com.desafio.votacaobackend.dominio.casosdeuso;

import br.com.desafio.votacaobackend.aplicacao.dto.VotoDto;

public interface CadastrarVoto {
    void execute(VotoDto votoDto);
}
