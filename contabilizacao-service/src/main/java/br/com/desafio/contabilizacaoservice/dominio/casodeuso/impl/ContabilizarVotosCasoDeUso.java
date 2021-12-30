package br.com.desafio.contabilizacaoservice.dominio.casodeuso.impl;


import br.com.desafio.contabilizacaoservice.dominio.casodeuso.dto.VotoDto;
import br.com.desafio.contabilizacaoservice.dominio.casodeuso.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;


@Component
public class ContabilizarVotosCasoDeUso implements ContabilizarResultadoVotacao {

    private ResultadoVotacaoRepositorio resultadoVotacaoRepositorio;

    @Autowired
    public ContabilizarVotosCasoDeUso(ResultadoVotacaoRepositorio resultadoVotacaoRepositorio) {
        this.resultadoVotacaoRepositorio = resultadoVotacaoRepositorio;
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
