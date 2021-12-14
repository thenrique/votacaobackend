package br.com.desafio.contabilizacaoservice.dominio.casodeuso;

import br.com.desafio.contabilizacaoservice.aplicacao.dto.ResultadoVotacaoDto;

public interface ExibirResultadoVotacao {
    ResultadoVotacaoDto executar(String identificadorPauta);
}
