package br.com.desafio.exibirresultadoservice.casodeuso;

import br.com.desafio.exibirresultadoservice.aplicacao.dto.ResultadoVotacaoDto;

public interface ExibirResultadoVotacao {
    ResultadoVotacao executar(String identificadorPauta);
}
