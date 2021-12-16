package br.com.desafio.votacaoservice.dominio.casosdeuso.impl;


import br.com.desafio.votacaoservice.dominio.Votacao;
import br.com.desafio.votacaoservice.dominio.VotacaoRepositorio;
import br.com.desafio.votacaoservice.dominio.casosdeuso.CadastrarVoto;
import br.com.desafio.votacaoservice.dominio.validacao.AssociadoJaComputouVoto;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Component
public class VotarCasoDeUso implements CadastrarVoto {

    private VotacaoRepositorio votacaoRepositorio;

    public VotarCasoDeUso(VotacaoRepositorio votacaoRepositorio) {
        this.votacaoRepositorio = votacaoRepositorio;
    }

    @Override
    public void execute(String identificadorPauta, String associado, boolean voto) throws RuntimeException {
        Votacao votacao = new Votacao(associado,voto,identificadorPauta);
        Optional<Votacao> votacaoOptional = votacaoRepositorio.buscarVoto(identificadorPauta, associado);
        if(votacaoOptional.isPresent()){
            throw new AssociadoJaComputouVoto(identificadorPauta,associado);
        }
        votacao.votar(votacao, votacaoRepositorio);

    }

}
