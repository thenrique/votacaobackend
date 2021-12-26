package br.com.desafio.exibirresultadoservice.casodeuso.impl;

import br.com.desafio.exibirresultadoservice.casodeuso.ExibirResultadoRepositorio;
import br.com.desafio.exibirresultadoservice.casodeuso.ExibirResultadoVotacao;
import br.com.desafio.exibirresultadoservice.casodeuso.ResultadoVotacao;
import br.com.desafio.exibirresultadoservice.casodeuso.validacao.ResultadoVotacaoNaoContabilizado;
import org.springframework.stereotype.Component;

import java.util.Optional;
@Component
public class ExibirResultadoVotacaoCasodeUso implements ExibirResultadoVotacao {

    private ExibirResultadoRepositorio exibirResultadoRepositorio;

    public ExibirResultadoVotacaoCasodeUso(ExibirResultadoRepositorio exibirResultadoRepositorio) {
        this.exibirResultadoRepositorio = exibirResultadoRepositorio;
    }

    @Override
    public ResultadoVotacao executar(String identificadorPauta) {
        Optional<ResultadoVotacao> resultadoVotacaoOptional = exibirResultadoRepositorio.resultadoJaContabilizado(identificadorPauta);
        if(resultadoVotacaoOptional.isPresent()){
            return resultadoVotacaoOptional.get();
        }
        throw new ResultadoVotacaoNaoContabilizado();

    }
}
