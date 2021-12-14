package br.com.desafio.votacaobackend.dominio.casosdeuso.impl;

import br.com.desafio.votacaobackend.dominio.Pauta;
import br.com.desafio.votacaobackend.dominio.casosdeuso.ContabilizarResultadoVotacao;
import org.springframework.stereotype.Component;

@Component
public class ContabilizarVotosCasoDeUso implements ContabilizarResultadoVotacao {

    @Override
    public Pauta execute(String identificadorPauta) {
        return null;
    }
}
