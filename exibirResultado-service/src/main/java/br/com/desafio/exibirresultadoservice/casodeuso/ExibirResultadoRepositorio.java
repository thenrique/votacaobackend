package br.com.desafio.exibirresultadoservice.casodeuso;


import java.util.List;
import java.util.Optional;

public interface ExibirResultadoRepositorio {
    Optional<ResultadoVotacao> resultadoJaContabilizado(String identificadorPauta);
}
