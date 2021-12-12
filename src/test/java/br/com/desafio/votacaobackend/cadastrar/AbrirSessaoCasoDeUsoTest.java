package br.com.desafio.votacaobackend.cadastrar;

import br.com.desafio.votacaobackend.aplicacao.dto.PautaDto;
import br.com.desafio.votacaobackend.aplicacao.dto.SessaoDto;
import br.com.desafio.votacaobackend.dominio.Pauta;
import br.com.desafio.votacaobackend.dominio.PautaRepositorio;
import br.com.desafio.votacaobackend.dominio.validacoes.PautaDeIdentificadorInexistente;
import br.com.desafio.votacaobackend.dominio.validacoes.SessaoJaFoiAberta;
import br.com.desafio.votacaobackend.infraestrutura.memoria.RepositoriodePautaMemoria;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AbrirSessaoCasoDeUsoTest {

    private PautaRepositorio repositorioEmMemoria = new RepositoriodePautaMemoria();


    @Test
    public void deveAbrirUmaSessao() {
        AbrirSessaoCasoDeUso abrirSessao = new AbrirSessaoCasoDeUso(repositorioEmMemoria);
        abrirSessao.execute(new SessaoDto("123", Long.valueOf(50)));

        Pauta pauta = repositorioEmMemoria.buscarPauta("123").get();

        assertEquals(pauta.getSessao() != null, true);
        assertEquals(pauta.getSessao().getDuracaoSesao().toMinutes(), 50);
    }

    @Test
    public void naoDeveAbrirSessaoPautaInexistente() {

        AbrirSessaoCasoDeUso abrirSessao = new AbrirSessaoCasoDeUso(repositorioEmMemoria);
        try {
            abrirSessao.execute(new SessaoDto("1234", Long.valueOf(50)));
        } catch (PautaDeIdentificadorInexistente e) {
            assertEquals(e.getMessage(), "Pauta inexistente com o identificador informado");

        }

    }

    @Test
    public void naoDeveAbrirSessaoPautaSessaoJaAberta() {


        AbrirSessaoCasoDeUso abrirSessao = new AbrirSessaoCasoDeUso(repositorioEmMemoria);
        try {
            abrirSessao.execute(new SessaoDto("123", Long.valueOf(50)));
            abrirSessao.execute(new SessaoDto("123", Long.valueOf(50)));
        } catch (SessaoJaFoiAberta e) {
            assertEquals(e.getMessage(), "A sessao de pauta 123 já está aberta");

        }
    }

    @Test
    public void deveAbrirSessaoComDuracaoPadrao() {


        AbrirSessaoCasoDeUso abrirSessao = new AbrirSessaoCasoDeUso(repositorioEmMemoria);

        abrirSessao.execute(new SessaoDto("123",null));
        Pauta pauta = repositorioEmMemoria.buscarPauta("123").get();

        assertEquals(pauta.getSessao() != null, true);
        assertEquals(pauta.getSessao().getDuracaoSesao().toMinutes(), 1);
    }

    @BeforeEach
    void setUp() {
        CadastrarPautaCasoDeUso cadastrarPauta = new CadastrarPautaCasoDeUso(repositorioEmMemoria);
        cadastrarPauta.execute(new PautaDto("123", "Teste Pauta"));
    }
}