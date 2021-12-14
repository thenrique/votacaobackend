package br.com.desafio.contabilizacaoservice.dominio.casodeuso.impl;

import br.com.desafio.contabilizacaoservice.aplicacao.dto.ResultadoVotacaoDto;
import br.com.desafio.contabilizacaoservice.dominio.casodeuso.ExibirResultadoVotacao;
import br.com.desafio.contabilizacaoservice.dominio.casodeuso.ResultadoVotacao;
import br.com.desafio.contabilizacaoservice.dominio.casodeuso.ResultadoVotacaoRepositorio;
import br.com.desafio.contabilizacaoservice.dominio.casodeuso.validacao.ResultadoVotacaoNaoContabilizado;
import org.springframework.stereotype.Component;

import java.util.Optional;
@Component
public class ExibirResultadoVotacaoCasodeUso implements ExibirResultadoVotacao {

    private ResultadoVotacaoRepositorio resultadoVotacaoRepositorio;

    public ExibirResultadoVotacaoCasodeUso(ResultadoVotacaoRepositorio resultadoVotacaoRepositorio) {
        this.resultadoVotacaoRepositorio = resultadoVotacaoRepositorio;
    }

    @Override
    public ResultadoVotacaoDto executar(String identificadorPauta) {
        Optional<ResultadoVotacao> resultadoVotacaoOptional = resultadoVotacaoRepositorio.resultadoJaContabilizado(identificadorPauta);
        if(resultadoVotacaoOptional.isPresent()){
            return new ResultadoVotacaoDto(resultadoVotacaoOptional.get());
        }
        throw new ResultadoVotacaoNaoContabilizado();

    }
}
