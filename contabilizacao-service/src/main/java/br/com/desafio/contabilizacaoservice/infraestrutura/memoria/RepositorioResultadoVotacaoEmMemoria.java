package br.com.desafio.contabilizacaoservice.infraestrutura.memoria;

import br.com.desafio.contabilizacaoservice.dominio.casodeuso.ResultadoVotacao;
import br.com.desafio.contabilizacaoservice.dominio.casodeuso.ResultadoVotacaoRepositorio;
import br.com.desafio.contabilizacaoservice.dominio.casodeuso.VotoDto;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import java.util.*;
import java.util.stream.Stream;

@Profile("test")
@Component
public class RepositorioResultadoVotacaoEmMemoria implements ResultadoVotacaoRepositorio {

    private List<VotoDto> votos = Arrays.asList(
            new VotoDto(true,"123"),
            new VotoDto(true,"123"),
            new VotoDto(false,"123"),
            new VotoDto(false,"123"),
            new VotoDto(false,"123"),
            new VotoDto(false,"123"),
            new VotoDto(true,"123"));
    private List<ResultadoVotacao> resultadoVotacaos = new ArrayList<>();


    @Override
    public void salvarResultado(ResultadoVotacao resultadoVotacao) {
        resultadoVotacaos.add(resultadoVotacao);
        votos.forEach( voto -> voto.setResultadoVotacao(resultadoVotacao));
    }

    @Override
    public Optional<ResultadoVotacao> resultadoJaContabilizado(String identificadorPauta) {
        Stream<ResultadoVotacao> retorno = resultadoVotacaos.stream().filter(resultadoVotacao -> resultadoVotacao.getIdenficadorPauta().equalsIgnoreCase(identificadorPauta));
        return retorno.findFirst();
    }
}
