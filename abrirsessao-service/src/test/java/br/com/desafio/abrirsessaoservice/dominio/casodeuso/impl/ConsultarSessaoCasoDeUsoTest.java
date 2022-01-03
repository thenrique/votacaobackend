package br.com.desafio.abrirsessaoservice.dominio.casodeuso.impl;

import br.com.desafio.abrirsessaoservice.dominio.PautaService;
import br.com.desafio.abrirsessaoservice.dominio.Sessao;
import br.com.desafio.abrirsessaoservice.dominio.SessaoRepositorio;
import br.com.desafio.abrirsessaoservice.dominio.casodeuso.ConsultarSessaoVotacao;
import br.com.desafio.abrirsessaoservice.dominio.dto.PautaDto;
import br.com.desafio.abrirsessaoservice.dominio.validacoes.SessaoNaoEstaAberta;
import br.com.desafio.abrirsessaoservice.dominio.validacoes.SessaoNaoExiste;
import br.com.desafio.abrirsessaoservice.infraestrutura.memoria.RepositoriodeSessaoMemoria;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;

class ConsultarSessaoCasoDeUsoTest {

    private SessaoRepositorio sessaoRepositorio = new RepositoriodeSessaoMemoria();
    private PautaService pautaService = Mockito.mock(PautaService.class);
    private String identificadorPauta="123";

    @Test
    void deveBuscarSessaoParaCadastrarAtiva() {
        ConsultarSessaoVotacao consultarSessaoVotacao = new ConsultarSessaoCasoDeUso(sessaoRepositorio,pautaService);
        Mockito.when(pautaService.buscarPauta(identificadorPauta)).thenReturn(new PautaDto(identificadorPauta,true,""));

        Sessao sessao = consultarSessaoVotacao.buscarSessao(identificadorPauta);
        assertNotNull(sessao);

    }

    @Test
    void deveLancarErroSessaoNaoExiste() {
        String pauta = "12366";
        ConsultarSessaoVotacao consultarSessaoVotacao = new ConsultarSessaoCasoDeUso(sessaoRepositorio,pautaService);
        Mockito.when(pautaService.buscarPauta(pauta)).thenReturn(new PautaDto(pauta,true,""));
        boolean erro=false;
        try {
            Sessao sessao = consultarSessaoVotacao.buscarSessao(pauta);
        }catch(SessaoNaoExiste e){
            erro=true;

        }
        assertEquals(erro,true);

    }
    @Test
    void deveLancarErroSessaoNaoEstaAberta() {
        String pauta = "1236";
        ConsultarSessaoVotacao consultarSessaoVotacao = new ConsultarSessaoCasoDeUso(sessaoRepositorio,pautaService);
        Mockito.when(pautaService.buscarPauta(pauta)).thenReturn(new PautaDto(pauta,true,""));
        boolean erro=false;
        try {
            Sessao sessao = consultarSessaoVotacao.buscarSessao(pauta);
        }catch(SessaoNaoEstaAberta e){
            erro=true;

        }
        assertEquals(erro,true);

    }

    @Test
    void deveLancarErroPautaNaoExiste() {
        String pauta = "1236";
        ConsultarSessaoVotacao consultarSessaoVotacao = new ConsultarSessaoCasoDeUso(sessaoRepositorio,pautaService);
        PautaDto pautaDto = null;
        Mockito.when(pautaService.buscarPauta(pauta)).thenReturn(pautaDto);
        assertEquals(pautaDto,null);

    }
}