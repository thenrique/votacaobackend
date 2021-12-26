package br.com.desafio.exibirresultadoservice.casodeuso.impl;

import br.com.desafio.exibirresultadoservice.casodeuso.ExibirResultadoRepositorio;
import br.com.desafio.exibirresultadoservice.casodeuso.ExibirResultadoVotacao;
import br.com.desafio.exibirresultadoservice.casodeuso.ResultadoVotacao;
import br.com.desafio.exibirresultadoservice.casodeuso.dto.ResultadoVotacaoDto;
import br.com.desafio.votacaoservice.dominio.RegistrarResultadoVotacao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RegistrarResultadoVotacaoCasoDeUso implements RegistrarResultadoVotacao {

    private ExibirResultadoRepositorio exibirResultadoRepositorio;

    @Autowired
    public RegistrarResultadoVotacaoCasoDeUso(ExibirResultadoRepositorio exibirResultadoRepositorio) {
        this.exibirResultadoRepositorio = exibirResultadoRepositorio;
    }

    @Override
    public void execute(ResultadoVotacao resultadoVotacao) {
            exibirResultadoRepositorio.salvarResultado(resultadoVotacao);
    }
}
