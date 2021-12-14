package br.com.desafio.contabilizacaoservice.infraestrutura.memoria;

import br.com.desafio.contabilizacaoservice.dominio.casodeuso.ResultadoVotacao;
import br.com.desafio.contabilizacaoservice.dominio.casodeuso.ResultadoVotacaoRepositorio;
import br.com.desafio.contabilizacaoservice.dominio.casodeuso.Voto;
import org.springframework.stereotype.Component;

import java.util.*;
import java.util.stream.Collectors;

@Component
public class RepositorioResultadoVotacaoEmMemoria implements ResultadoVotacaoRepositorio {

    private List<Voto> votos = Arrays.asList(
            new Voto(true,"123"),
            new Voto(true,"123"),
            new Voto(false,"123"),
            new Voto(false,"123"),
            new Voto(false,"123"),
            new Voto(false,"123"),
            new Voto(true,"123"));
    private List<ResultadoVotacao> resultadoVotacaos = new ArrayList<>();


    @Override
    public List<Voto> buscarTodosVotos(String identificadorPauta) {
        return votos.stream().filter(voto -> voto.getIdentificadorPauta().equalsIgnoreCase(identificadorPauta)).collect(Collectors.toList());
    }

    @Override
    public void salvarResultado(ResultadoVotacao resultadoVotacao, List<Voto> votos) {
        resultadoVotacaos.add(resultadoVotacao);
        votos.forEach( voto -> voto.setResultadoVotacao(resultadoVotacao));
    }

    @Override
    public Optional<ResultadoVotacao> resultadoJaContabilizado(String identificadorPauta) {
        return resultadoVotacaos.stream().filter(resultadoVotacao -> resultadoVotacao.getIdenficadorPauta().equalsIgnoreCase(identificadorPauta)).findFirst();
    }
}
