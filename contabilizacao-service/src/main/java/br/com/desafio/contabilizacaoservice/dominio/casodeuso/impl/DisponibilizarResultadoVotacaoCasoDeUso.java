package br.com.desafio.contabilizacaoservice.dominio.casodeuso.impl;

import br.com.desafio.contabilizacaoservice.dominio.casodeuso.*;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class DisponibilizarResultadoVotacaoCasoDeUso implements DisponibilizarResultadoVotacao {

    private ResultadoVotacaoRepositorio resultadoVotacaoRepositorio;
    private NotificacaoVotacaoEncerrada notificacaoVotacaoEncerrada;


    public DisponibilizarResultadoVotacaoCasoDeUso(ResultadoVotacaoRepositorio resultadoVotacaoRepositorio, NotificacaoVotacaoEncerrada notificacaoVotacaoEncerrada) {
        this.resultadoVotacaoRepositorio = resultadoVotacaoRepositorio;
        this.notificacaoVotacaoEncerrada = notificacaoVotacaoEncerrada;
    }

    @Override
    public void execute(String identificadorPauta) {

        Optional<ResultadoVotacao> optionalResultadoVotacao = resultadoVotacaoRepositorio.resultadoJaContabilizado(identificadorPauta);

        if(optionalResultadoVotacao.isPresent()){
            ResultadoVotacao resultado = optionalResultadoVotacao.get();
            ResultadoDto resultadoDto = new ResultadoDto(resultado.getIdenficadorPauta(),resultado.getTotalVotos(), resultado.getTodosSim(),resultado.getTodosNao()  );
            notificacaoVotacaoEncerrada.executar(resultadoDto);

        }

    }
}
