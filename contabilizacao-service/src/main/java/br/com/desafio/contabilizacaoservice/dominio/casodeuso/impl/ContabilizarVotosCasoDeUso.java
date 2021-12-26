package br.com.desafio.contabilizacaoservice.dominio.casodeuso.impl;


import br.com.desafio.contabilizacaoservice.dominio.casodeuso.dto.VotoDto;
import br.com.desafio.contabilizacaoservice.dominio.casodeuso.*;
import org.springframework.stereotype.Component;

import java.util.Optional;


@Component
public class ContabilizarVotosCasoDeUso implements ContabilizarResultadoVotacao {

    private ResultadoVotacaoRepositorio resultadoVotacaoRepositorio;
    private NotificacaoVotacaoEncerrada notificacaoVotacaoEncerrada;

    public ContabilizarVotosCasoDeUso(ResultadoVotacaoRepositorio resultadoVotacaoRepositorio, NotificacaoVotacaoEncerrada contabilizacaoProducer) {
        this.resultadoVotacaoRepositorio = resultadoVotacaoRepositorio;
        this.notificacaoVotacaoEncerrada = contabilizacaoProducer;
    }

    @Override
    public void execute(VotoDto votoDto) {

        Optional<ResultadoVotacao> optionalResultadoVotacao = resultadoVotacaoRepositorio.resultadoJaContabilizado(votoDto.getIdentificadorPauta());
        ResultadoVotacao resultadoVotacao =new ResultadoVotacao(votoDto.getIdentificadorPauta());
            if(optionalResultadoVotacao.isPresent()) {
                resultadoVotacao = optionalResultadoVotacao.get();
            }
            if(votoDto.isVoto()){
                resultadoVotacao.incrementaVotoSim();
            }else{
                resultadoVotacao.incrementaVotoNao();
            }

            resultadoVotacaoRepositorio.salvarResultado(resultadoVotacao);



    }
}
