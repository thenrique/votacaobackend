package br.com.desafio.contabilizacaoservice.dominio.casodeuso.impl;

import br.com.desafio.contabilizacaoservice.aplicacao.dto.ResultadoVotacaoDto;
import br.com.desafio.contabilizacaoservice.dominio.casodeuso.ContabilizarResultadoVotacao;
import br.com.desafio.contabilizacaoservice.dominio.casodeuso.ExibirResultadoVotacao;
import br.com.desafio.contabilizacaoservice.dominio.casodeuso.ResultadoVotacaoRepositorio;
import br.com.desafio.contabilizacaoservice.dominio.casodeuso.validacao.ResultadoVotacaoNaoContabilizado;
import br.com.desafio.contabilizacaoservice.infraestrutura.memoria.RepositorioResultadoVotacaoEmMemoria;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ExibirResultadoVotacaoCasodeUsoTest {

    private ResultadoVotacaoRepositorio resultadoVotacaoRepositorio = new RepositorioResultadoVotacaoEmMemoria();
    private String identificadorPauta="123";

    @Test
    void deveExibirResultadoVotacao() {
        ContabilizarResultadoVotacao contabilizarResultadoVotacao = new ContabilizarVotosCasoDeUso(resultadoVotacaoRepositorio);
        contabilizarResultadoVotacao.execute(identificadorPauta);

        ExibirResultadoVotacao exibirResultadoVotacao = new ExibirResultadoVotacaoCasodeUso(resultadoVotacaoRepositorio);
        ResultadoVotacaoDto resultado = exibirResultadoVotacao.executar(identificadorPauta);

        assertEquals(3,resultado.getVotosSim());
        assertEquals(4,resultado.getVotosNao());
        assertEquals(7,resultado.getTotalVotos());

    }

    @Test
    void naoDeveExibirResultadoVotacaoPendenciaContabilizacao() {

        ExibirResultadoVotacao exibirResultadoVotacao = new ExibirResultadoVotacaoCasodeUso(resultadoVotacaoRepositorio);
        try {
            ResultadoVotacaoDto resultado = exibirResultadoVotacao.executar("12346");
        }catch(ResultadoVotacaoNaoContabilizado e){
            assertEquals("O resultado da votação ainda não foi contabilizado.",e.getMessage());
        }

    }
}