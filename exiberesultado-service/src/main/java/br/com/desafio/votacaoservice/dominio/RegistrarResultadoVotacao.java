package br.com.desafio.votacaoservice.dominio;

import br.com.desafio.exibirresultadoservice.casodeuso.ResultadoVotacao;
import br.com.desafio.exibirresultadoservice.casodeuso.dto.ResultadoVotacaoDto;

public interface RegistrarResultadoVotacao {

    void execute(ResultadoVotacao resultadoVotacao);
}
