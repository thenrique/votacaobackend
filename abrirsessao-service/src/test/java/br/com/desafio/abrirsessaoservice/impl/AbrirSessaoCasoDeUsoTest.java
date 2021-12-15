package br.com.desafio.abrirsessaoservice.impl;

import br.com.desafio.abrirsessaoservice.dominio.Pauta;
import br.com.desafio.abrirsessaoservice.dominio.PautaRepositorio;
import br.com.desafio.abrirsessaoservice.dominio.casodeuso.impl.AbrirSessaoCasoDeUso;
import br.com.desafio.abrirsessaoservice.dominio.validacoes.PautaDeIdentificadorInexistente;
import br.com.desafio.abrirsessaoservice.dominio.validacoes.SessaoJaFoiAberta;
import br.com.desafio.abrirsessaoservice.infraestrutura.memoria.RepositoriodePautaMemoria;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class AbrirSessaoCasoDeUsoTest {

    private PautaRepositorio repositorioEmMemoria = new RepositoriodePautaMemoria();


    @Test
     void deveAbrirUmaSessao() {
        AbrirSessaoCasoDeUso abrirSessao = new AbrirSessaoCasoDeUso(repositorioEmMemoria);
        abrirSessao.execute("123", Long.valueOf(50));

        Pauta pauta = repositorioEmMemoria.buscarPauta("123").get();

        assertEquals(true,pauta.getSessao() != null);
        assertEquals(50,pauta.getSessao().getDuracaoSesao().toMinutes());
    }

    @Test
     void naoDeveAbrirSessaoPautaInexistente() {

        AbrirSessaoCasoDeUso abrirSessao = new AbrirSessaoCasoDeUso(repositorioEmMemoria);
        try {
            abrirSessao.execute("1234", Long.valueOf(50));
        } catch (PautaDeIdentificadorInexistente e) {
            assertEquals( "Pauta inexistente com o identificador informado", e.getMessage());

        }

    }

    @Test
     void naoDeveAbrirSessaoPautaSessaoJaAberta() {


        AbrirSessaoCasoDeUso abrirSessao = new AbrirSessaoCasoDeUso(repositorioEmMemoria);
        try {
            abrirSessao.execute("123", Long.valueOf(50));
            abrirSessao.execute("123", Long.valueOf(50));
        } catch (SessaoJaFoiAberta e) {
            assertEquals("A sessao de pauta 123 já está aberta",e.getMessage());

        }
    }

    @Test
     void deveAbrirSessaoComDuracaoPadrao() {


        AbrirSessaoCasoDeUso abrirSessao = new AbrirSessaoCasoDeUso(repositorioEmMemoria);

        abrirSessao.execute("123",null);
        Pauta pauta = repositorioEmMemoria.buscarPauta("123").get();

        assertEquals( true,pauta.getSessao() != null);
        assertEquals( 1,pauta.getSessao().getDuracaoSesao().toMinutes());
    }


}