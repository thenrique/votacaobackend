package br.com.desafio.votacaobackend.restcontroler;

import br.com.desafio.votacaobackend.aplicacao.dto.PautaDto;
import br.com.desafio.votacaobackend.infraestrutura.memoria.RepositoriodePautaMemoria;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CadastrarPautaRestControlerTest {

    @Test
    public void deveCadastrarUmaPauta(){
        CadastrarPautaRestControler cadastrarPautaRestControler = new CadastrarPautaRestControler(new RepositoriodePautaMemoria());
        PautaDto pautaDto = new PautaDto("123","Pauta Teste");

    }

}