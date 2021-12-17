package br.com.desafio.abrirsessaoservice.impl;

import br.com.desafio.abrirsessaoservice.dominio.PautaService;
import br.com.desafio.abrirsessaoservice.dominio.Sessao;
import br.com.desafio.abrirsessaoservice.dominio.SessaoRepositorio;
import br.com.desafio.abrirsessaoservice.dominio.casodeuso.impl.AbrirSessaoCasoDeUso;
import br.com.desafio.abrirsessaoservice.dominio.dto.PautaDto;
import br.com.desafio.abrirsessaoservice.dominio.validacoes.PautaDeIdentificadorInexistente;
import br.com.desafio.abrirsessaoservice.dominio.validacoes.SessaoJaFoiAberta;
import br.com.desafio.abrirsessaoservice.infraestrutura.memoria.RepositoriodeSessaoMemoria;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.assertEquals;

class AbrirSessaoCasoDeUsoTest {

    private SessaoRepositorio repositorioEmMemoria = new RepositoriodeSessaoMemoria();
    private @Mock PautaService pautaService = Mockito.mock(PautaService.class);


    @Test
     void deveAbrirUmaSessao() {
        PautaDto pauta = new PautaDto("1236");

        AbrirSessaoCasoDeUso abrirSessao = new AbrirSessaoCasoDeUso(repositorioEmMemoria,pautaService);
        Mockito.when(pautaService.buscarPauta("123")).thenReturn(pauta);
        abrirSessao.execute("1236", Long.valueOf(50));

        Sessao sessao = repositorioEmMemoria.buscarSessaoPauta("123").get();

        assertEquals(true,sessao != null);
        assertEquals(50,sessao.getDuracaoSesao().toMinutes());
    }

    @Test
     void naoDeveAbrirSessaoPautaInexistente() {

        AbrirSessaoCasoDeUso abrirSessao = new AbrirSessaoCasoDeUso(repositorioEmMemoria,pautaService);
        try {
            abrirSessao.execute("1234", Long.valueOf(50));
        } catch (PautaDeIdentificadorInexistente e) {
            assertEquals( "Pauta inexistente com o identificador informado", e.getMessage());

        }

    }

    @Test
     void naoDeveAbrirSessaoPautaSessaoJaAberta() {


        AbrirSessaoCasoDeUso abrirSessao = new AbrirSessaoCasoDeUso(repositorioEmMemoria,pautaService);
        try {
            abrirSessao.execute("123", Long.valueOf(50));
            abrirSessao.execute("123", Long.valueOf(50));
        } catch (SessaoJaFoiAberta e) {
            assertEquals("A sessao de pauta 123 já está aberta",e.getMessage());

        }
    }

    @Test
     void deveAbrirSessaoComDuracaoPadrao() {


        AbrirSessaoCasoDeUso abrirSessao = new AbrirSessaoCasoDeUso(repositorioEmMemoria,pautaService);

        abrirSessao.execute("123",null);
        Sessao sessao = repositorioEmMemoria.buscarSessaoPauta("123").get();

        assertEquals( true,sessao!= null);
        assertEquals( 50,sessao.getDuracaoSesao().toMinutes());
    }


}