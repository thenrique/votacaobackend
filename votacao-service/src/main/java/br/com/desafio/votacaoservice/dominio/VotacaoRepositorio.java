package br.com.desafio.votacaoservice.dominio;


import java.util.Optional;

public interface VotacaoRepositorio {

    Optional<Votacao> buscarVoto(String identificadorPauta, String idenficadorAssociado);

    void votar(Votacao votacao);
}
