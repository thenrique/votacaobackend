package br.com.desafio.pautaservice.dominio.casodeuso;

import br.com.desafio.pautaservice.dominio.casosdeuso.Pauta;
import br.com.desafio.pautaservice.dominio.casosdeuso.PautaRepositorio;
import br.com.desafio.pautaservice.dominio.casosdeuso.impl.CadastrarPautaCasoDeUso;
import br.com.desafio.pautaservice.dominio.casosdeuso.validacoes.PautaJaExistente;
import br.com.desafio.pautaservice.infraestrutura.memoria.RepositoriodePautaMemoria;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Optional;


class CadastrarPautaCasoDeUsoTest {

    private PautaRepositorio pautaRepositorio = new RepositoriodePautaMemoria();


    @Test
    void deveCadastrarUmaPauta() {
        CadastrarPautaCasoDeUso cadastrarPauta = new CadastrarPautaCasoDeUso(pautaRepositorio);
        cadastrarPauta.execute("123", "Teste Pauta");
        Optional<Pauta> pauta = pautaRepositorio.buscarPauta("123");
        Assertions.assertEquals( "123",pauta.get().getIdentificador() );
    }

    @Test
    void NaoDeveCadastrarAMesmaPautaDuasVezes() {
        CadastrarPautaCasoDeUso cadastrarPauta = new CadastrarPautaCasoDeUso(pautaRepositorio);
        cadastrarPauta.execute("123", "Teste Pauta");

        try {
            cadastrarPauta.execute("123", "Teste Pauta");
        }catch(PautaJaExistente e){
            Assertions.assertEquals("Pauta já existente com o identificador informado: 123",e.getMessage());
        }




    }
}