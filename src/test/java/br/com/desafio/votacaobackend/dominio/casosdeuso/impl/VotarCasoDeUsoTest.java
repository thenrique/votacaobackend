package br.com.desafio.votacaobackend.dominio.casosdeuso.impl;


import br.com.desafio.votacaobackend.dominio.Pauta;
import br.com.desafio.votacaobackend.dominio.PautaRepositorio;
import br.com.desafio.votacaobackend.dominio.casosdeuso.CadastrarVoto;
import br.com.desafio.votacaobackend.dominio.validacoes.SessaoNaoEstaAberta;
import br.com.desafio.votacaobackend.dominio.validacoes.votacao.AssociadoJaComputouVoto;
import br.com.desafio.votacaobackend.infraestrutura.memoria.RepositoriodePautaMemoria;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class VotarCasoDeUsoTest {

    private String identificadorPauta="1234";
    private PautaRepositorio pautaRepositorio = new RepositoriodePautaMemoria();
    private String cpfAssociado="95346141065";


    @Test
    void deveCadastrarVotoAssociado() {


        CadastrarVoto cadastrarVoto = new VotarCasoDeUso(pautaRepositorio);

        cadastrarVoto.execute(identificadorPauta,cpfAssociado,true);

        Optional<Pauta> pautaOptional = pautaRepositorio.buscarPauta(identificadorPauta);
        assertEquals(true, pautaOptional.get().isAssociadoJaVotou(cpfAssociado));

    }

    @Test
    void naoDeveCadastrarVotoDuplicado() {
          CadastrarVoto cadastrarVoto = new VotarCasoDeUso(pautaRepositorio);
        cadastrarVoto.execute(identificadorPauta,cpfAssociado,true);
        try {
            cadastrarVoto.execute(identificadorPauta,cpfAssociado,true);
        }catch(AssociadoJaComputouVoto e){
            assertEquals(" O associado de identificador " + cpfAssociado + " já votou na pauta de número " + identificadorPauta, e.getMessage());
        }

    }

    @Test
    void naoDeveVotarComSessaoNaoAberta() {

        CadastrarVoto cadastrarVoto = new VotarCasoDeUso(pautaRepositorio);
        Optional<Pauta> pautaOptional = pautaRepositorio.buscarPauta("123456");
        SessaoNaoEstaAberta expected = new SessaoNaoEstaAberta();
        boolean erro=false;
        try {
            cadastrarVoto.execute("123456",cpfAssociado,true);
        }catch(SessaoNaoEstaAberta e){
            erro = true;
        }

        assertEquals(true,erro);
    }
}