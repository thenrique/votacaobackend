package br.com.desafio.votacaobackend.dominio.casosdeuso.impl;

import br.com.desafio.votacaobackend.aplicacao.dto.PautaDto;
import br.com.desafio.votacaobackend.dominio.Pauta;
import br.com.desafio.votacaobackend.dominio.casosdeuso.impl.CadastrarPautaCasoDeUso;
import br.com.desafio.votacaobackend.dominio.validacoes.PautaJaExistente;
import br.com.desafio.votacaobackend.dominio.PautaRepositorio;
import br.com.desafio.votacaobackend.infraestrutura.memoria.RepositoriodePautaMemoria;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class CadastrarPautaCasoDeUsoTest {

    private PautaRepositorio pautaRepositorio = new RepositoriodePautaMemoria();


    @Test
    void deveCadastrarUmaPauta() {
        CadastrarPautaCasoDeUso cadastrarPauta = new CadastrarPautaCasoDeUso(pautaRepositorio);
        cadastrarPauta.execute(new PautaDto("123", "Teste Pauta"));
        Optional<Pauta> pauta = pautaRepositorio.buscarPauta("123");
        assertEquals( "123",pauta.get().getIdentificador() );
    }

    @Test
    void NaoDeveCadastrarAMesmaPautaDuasVezes() {
        CadastrarPautaCasoDeUso cadastrarPauta = new CadastrarPautaCasoDeUso(pautaRepositorio);
        cadastrarPauta.execute(new PautaDto("123", "Teste Pauta"));

        try {
            cadastrarPauta.execute(new PautaDto("123", "Teste Pauta"));
        }catch(PautaJaExistente e){
            assertEquals("Pauta já existente com o identificador informado: 123",e.getMessage());
        }




    }
}