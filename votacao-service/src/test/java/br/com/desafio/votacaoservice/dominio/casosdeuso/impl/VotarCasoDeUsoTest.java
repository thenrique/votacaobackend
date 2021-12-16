package br.com.desafio.votacaoservice.dominio.casosdeuso.impl;

import br.com.desafio.votacaoservice.dominio.Votacao;
import br.com.desafio.votacaoservice.dominio.VotacaoRepositorio;
import br.com.desafio.votacaoservice.dominio.casosdeuso.CadastrarVoto;
import br.com.desafio.votacaoservice.dominio.validacao.AssociadoJaComputouVoto;
import br.com.desafio.votacaoservice.infraestrutura.memoria.RepositoriodeVotacaoMemoria;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class VotarCasoDeUsoTest {


    private String identificadorPauta="1234";
    private VotacaoRepositorio votacaoRepositorio = new RepositoriodeVotacaoMemoria();
    private String cpfAssociado="28669963051";


    @Test
    void deveCadastrarVotoAssociado() {


        CadastrarVoto cadastrarVoto = new VotarCasoDeUso(votacaoRepositorio);

        cadastrarVoto.execute(identificadorPauta,cpfAssociado,true);

        Optional<Votacao> votacaoOptional = votacaoRepositorio.buscarVoto(identificadorPauta, cpfAssociado);
        assertEquals(true, votacaoOptional.get().isVoto());

    }

    @Test
    void naoDeveCadastrarVotoDuplicado() {
        CadastrarVoto cadastrarVoto = new VotarCasoDeUso(votacaoRepositorio);
        cadastrarVoto.execute("15694916077",cpfAssociado,true);
        try {
            cadastrarVoto.execute(identificadorPauta,cpfAssociado,true);
        }catch(AssociadoJaComputouVoto e){
            assertEquals(" O associado de identificador " + cpfAssociado + " já votou na pauta de número " + identificadorPauta, e.getMessage());
        }

    }


}