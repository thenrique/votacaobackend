package br.com.desafio.contabilizacaoservice.dominio.casodeuso.impl;

import br.com.desafio.contabilizacaoservice.dominio.ConsultarSessaoPautas;
import br.com.desafio.contabilizacaoservice.dominio.casodeuso.*;
import br.com.desafio.contabilizacaoservice.dominio.casodeuso.dto.PautaDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class DisponibilizarResultadoVotacaoCasoDeUso implements DisponibilizarResultadoVotacao {

    private ResultadoVotacaoRepositorio resultadoVotacaoRepositorio;
    private NotificacaoVotacaoEncerrada notificacaoVotacaoEncerrada;
    private ConsultarSessaoPautas consultarSessaoPautas;


    @Autowired
    public DisponibilizarResultadoVotacaoCasoDeUso(ResultadoVotacaoRepositorio resultadoVotacaoRepositorio, NotificacaoVotacaoEncerrada notificacaoVotacaoEncerrada, ConsultarSessaoPautas consultarSessaoPautas) {
        this.resultadoVotacaoRepositorio = resultadoVotacaoRepositorio;
        this.notificacaoVotacaoEncerrada = notificacaoVotacaoEncerrada;
        this.consultarSessaoPautas = consultarSessaoPautas;
    }

    @Override
    public void execute(String identificadorPauta) {

        Optional<ResultadoVotacao> optionalResultadoVotacao = resultadoVotacaoRepositorio.resultadoJaContabilizado(identificadorPauta);

        if(optionalResultadoVotacao.isPresent()){

            PautaDto pauta = consultarSessaoPautas.consultar(identificadorPauta);

            ResultadoVotacao resultado = optionalResultadoVotacao.get();
            ResultadoDto resultadoDto = ResultadoDto.builder().identificadorPauta(resultado.getIdenficadorPauta()).total(resultado.getTotalVotos())
                            .totalNao(resultado.getTodosNao())
                                    .totalSim(resultado.getTodosSim()).build();

            resultadoDto.defineVotacaoEncerrou(pauta.dataAbertura(),pauta.dataEncerramento());
            notificacaoVotacaoEncerrada.executar(resultadoDto);


        }

    }
}
