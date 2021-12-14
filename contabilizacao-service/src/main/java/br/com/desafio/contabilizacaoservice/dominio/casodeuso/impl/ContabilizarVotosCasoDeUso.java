package br.com.desafio.contabilizacaoservice.dominio.casodeuso.impl;


import br.com.desafio.contabilizacaoservice.dominio.casodeuso.ContabilizarResultadoVotacao;
import br.com.desafio.contabilizacaoservice.dominio.casodeuso.ResultadoVotacao;
import br.com.desafio.contabilizacaoservice.dominio.casodeuso.ResultadoVotacaoRepositorio;
import br.com.desafio.contabilizacaoservice.dominio.casodeuso.Voto;
import br.com.desafio.contabilizacaoservice.dominio.casodeuso.validacao.ResultadoJaContabilizado;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Component
public class ContabilizarVotosCasoDeUso implements ContabilizarResultadoVotacao {

    private ResultadoVotacaoRepositorio resultadoVotacaoRepositorio;

    public ContabilizarVotosCasoDeUso(ResultadoVotacaoRepositorio resultadoVotacaoRepositorio) {
        this.resultadoVotacaoRepositorio = resultadoVotacaoRepositorio;
    }

    @Override
    public void execute(String identificadorPauta) {
        Optional<ResultadoVotacao> optionalResultadoVotacao = resultadoVotacaoRepositorio.resultadoJaContabilizado(identificadorPauta);
        if(optionalResultadoVotacao.isPresent()){
           throw new ResultadoJaContabilizado();
        }
        List<Voto> votos = resultadoVotacaoRepositorio.buscarTodosVotos(identificadorPauta);
        Long total= votos.stream().count();
        Long totalSim = votos.stream().filter( voto -> voto.isVoto()).count();
        Long totalNao = total-totalSim;

        ResultadoVotacao resultadoVotacao = ResultadoVotacao.builder().idenficadorPauta(identificadorPauta).totalVotos(total).todosNao(totalNao).todosSim(totalSim).build();
        resultadoVotacaoRepositorio.salvarResultado(resultadoVotacao, votos);

    }
}
