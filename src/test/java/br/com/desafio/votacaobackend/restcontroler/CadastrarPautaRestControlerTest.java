package br.com.desafio.votacaobackend.restcontroler;

import br.com.desafio.votacaobackend.aplicacao.dto.PautaDto;
import br.com.desafio.votacaobackend.dominio.casosdeuso.CadastrarPauta;
import br.com.desafio.votacaobackend.dominio.casosdeuso.impl.CadastrarPautaCasoDeUso;
import br.com.desafio.votacaobackend.infraestrutura.memoria.RepositoriodePautaMemoria;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CadastrarPautaRestControlerTest {

    @Test
    public void deveCadastrarUmaPauta(){
        CadastrarPauta cadastrarPauta = new CadastrarPautaCasoDeUso(new RepositoriodePautaMemoria());
        CadastrarPautaRestControler cadastrarPautaRestControler = new CadastrarPautaRestControler(cadastrarPauta);
        PautaDto pautaDto = new PautaDto("123","Pauta Teste");

    }

}