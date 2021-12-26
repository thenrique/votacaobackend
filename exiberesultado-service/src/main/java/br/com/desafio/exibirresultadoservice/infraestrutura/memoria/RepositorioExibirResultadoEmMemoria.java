package br.com.desafio.exibirresultadoservice.infraestrutura.memoria;


import br.com.desafio.exibirresultadoservice.aplicacao.dto.ResultadoDto;
import br.com.desafio.exibirresultadoservice.casodeuso.ExibirResultadoRepositorio;
import br.com.desafio.exibirresultadoservice.casodeuso.ResultadoVotacao;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import java.util.List;

import java.util.ArrayList;
import java.util.Optional;

@Profile("test")
@Component
public class RepositorioExibirResultadoEmMemoria implements ExibirResultadoRepositorio {

    private List<ResultadoVotacao> lista = new ArrayList();

    public RepositorioExibirResultadoEmMemoria() {
        lista.add(ResultadoVotacao.builder().idenficadorPauta("123").todosSim(3L).todosNao(4L).totalVotos(7L).build());

    }

    @Override
    public Optional<ResultadoVotacao> resultadoJaContabilizado(String identificadorPauta) {
        return lista.stream().filter(resultadoVotacao -> resultadoVotacao.getIdenficadorPauta().equalsIgnoreCase(identificadorPauta)).findFirst();
    }

    @Override
    public void salvarResultado(ResultadoVotacao resultadoVotacao) {
        lista.add(resultadoVotacao);
    }
}
