package br.com.desafio.contabilizacaoservice.dominio.casodeuso;



import java.util.Optional;

public interface ResultadoVotacaoRepositorio {

    void salvarResultado(ResultadoVotacao resultadoVotacao);

    Optional<ResultadoVotacao> resultadoJaContabilizado(String identificadorPauta);
}
