package br.com.desafio.contabilizacaoservice.dominio.casodeuso.impl;

import br.com.desafio.contabilizacaoservice.dominio.casodeuso.ContabilizarResultadoVotacao;
import br.com.desafio.contabilizacaoservice.dominio.casodeuso.ResultadoVotacao;
import br.com.desafio.contabilizacaoservice.dominio.casodeuso.ResultadoVotacaoRepositorio;
import br.com.desafio.contabilizacaoservice.dominio.casodeuso.validacao.ResultadoJaContabilizado;
import br.com.desafio.contabilizacaoservice.infraestrutura.memoria.RepositorioResultadoVotacaoEmMemoria;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ContabilizarVotosCasoDeUsoTest {

    private ResultadoVotacaoRepositorio resultadoVotacaoRepositorio = new RepositorioResultadoVotacaoEmMemoria();

    private String identificadorPauta= "123";

    @Test
    void deveContabilizarTodosVotos() {
        ContabilizarResultadoVotacao contabilizarVotosCasoDeUso = new ContabilizarVotosCasoDeUso(resultadoVotacaoRepositorio);

        contabilizarVotosCasoDeUso.execute(identificadorPauta);

        Optional<ResultadoVotacao> optinal = resultadoVotacaoRepositorio.resultadoJaContabilizado(identificadorPauta);

        assertEquals(3,optinal.get().getTodosSim());
        assertEquals(4,optinal.get().getTodosNao());
        assertEquals(7,optinal.get().getTotalVotos());
    }

    @Test
    void deveContabilizarTodosVotosApenasUmaVez() {
        ContabilizarResultadoVotacao contabilizarVotosCasoDeUso = new ContabilizarVotosCasoDeUso(resultadoVotacaoRepositorio);

        try {

            contabilizarVotosCasoDeUso.execute(identificadorPauta);
        }catch (ResultadoJaContabilizado e){
            assertEquals("O resultado da pauta já foi contabilizado",e.getMessage());
        }

    }
}
