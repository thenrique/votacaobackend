package br.com.desafio.votacaobackend.dominio.casosdeuso;

import br.com.desafio.votacaobackend.aplicacao.dto.PautaDto;

public interface CadastrarPauta {
    void execute(PautaDto pautaDto);
}
