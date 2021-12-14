package br.com.desafio.contabilizacaoservice.dominio.casodeuso;


import java.util.List;
import java.util.Optional;

public interface ResultadoVotacaoRepositorio {

    List<Voto> buscarTodosVotos(String identificadorPauta);
    void salvarResultado(ResultadoVotacao resultadoVotacao, List<Voto> votos);

    Optional<ResultadoVotacao> resultadoJaContabilizado(String identificadorPauta);
}
