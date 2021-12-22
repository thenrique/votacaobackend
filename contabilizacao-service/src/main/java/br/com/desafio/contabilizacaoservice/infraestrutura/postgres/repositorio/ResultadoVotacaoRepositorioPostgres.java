package br.com.desafio.contabilizacaoservice.infraestrutura.postgres.repositorio;


import br.com.desafio.contabilizacaoservice.dominio.casodeuso.ResultadoVotacao;
import br.com.desafio.contabilizacaoservice.dominio.casodeuso.ResultadoVotacaoRepositorio;
import br.com.desafio.contabilizacaoservice.dominio.casodeuso.Voto;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Repository
public class ResultadoVotacaoRepositorioPostgres implements ResultadoVotacaoRepositorio {

    @Override
    public List<Voto> buscarTodosVotos(String identificadorPauta) {
        return null;
    }

    @Override
    public void salvarResultado(ResultadoVotacao resultadoVotacao, List<Voto> votos) {

    }

    @Override
    public Optional<ResultadoVotacao> resultadoJaContabilizado(String identificadorPauta) {
        return Optional.empty();
    }
}
