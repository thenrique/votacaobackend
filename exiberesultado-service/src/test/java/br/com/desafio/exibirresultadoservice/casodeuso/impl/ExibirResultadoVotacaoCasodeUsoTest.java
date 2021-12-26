package br.com.desafio.exibirresultadoservice.casodeuso.impl;


import br.com.desafio.exibirresultadoservice.casodeuso.ExibirResultadoRepositorio;
import br.com.desafio.exibirresultadoservice.casodeuso.ExibirResultadoVotacao;
import br.com.desafio.exibirresultadoservice.casodeuso.ResultadoVotacao;
import br.com.desafio.exibirresultadoservice.casodeuso.validacao.ResultadoVotacaoNaoContabilizado;
import br.com.desafio.exibirresultadoservice.infraestrutura.memoria.RepositorioExibirResultadoEmMemoria;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ExibirResultadoVotacaoCasodeUsoTest {

    private ExibirResultadoRepositorio exibirResultadoRepositorio = new RepositorioExibirResultadoEmMemoria();
    private String identificadorPauta="123";

    @Test
    void deveExibirResultadoVotacao() {

        ExibirResultadoVotacao exibirResultadoVotacao = new ExibirResultadoVotacaoCasodeUso(exibirResultadoRepositorio);
        ResultadoVotacao resultado = exibirResultadoVotacao.executar(identificadorPauta);
        assertEquals(3,resultado.getTodosSim());
        assertEquals(4,resultado.getTodosNao());
        assertEquals(7,resultado.getTotalVotos());

    }

    @Test
    void naoDeveExibirResultadoVotacaoPendenciaContabilizacao() {

        ExibirResultadoVotacao exibirResultadoVotacao = new ExibirResultadoVotacaoCasodeUso(exibirResultadoRepositorio);
        try {
            ResultadoVotacao resultado = exibirResultadoVotacao.executar("12346");
        }catch(ResultadoVotacaoNaoContabilizado e){
            assertEquals("O resultado da votação ainda não foi contabilizado.",e.getMessage());
        }

    }
}