package br.com.desafio.exibirresultadoservice.infraestrutura.postgres.repositorio;



import br.com.desafio.exibirresultadoservice.aplicacao.dto.ResultadoDto;
import br.com.desafio.exibirresultadoservice.casodeuso.ExibirResultadoRepositorio;
import br.com.desafio.exibirresultadoservice.casodeuso.ResultadoVotacao;
import br.com.desafio.exibirresultadoservice.infraestrutura.postgres.entidade.ResultadoVotacaoEntidade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public class ResultadoVotacaoRepositorioPostgres implements ExibirResultadoRepositorio
{

    private final ResultadoVotacaoRepositorioI resultadoVotacaoRepositorioI;

    @Autowired
    public ResultadoVotacaoRepositorioPostgres(ResultadoVotacaoRepositorioI resultadoVotacaoRepositorioI) {
        this.resultadoVotacaoRepositorioI = resultadoVotacaoRepositorioI;
    }


    @Override
    public Optional<ResultadoVotacao> resultadoJaContabilizado(String identificadorPauta) {
        Optional<ResultadoVotacaoEntidade> resultadoEntityOptinal = resultadoVotacaoRepositorioI.findByIdenficadorPauta(identificadorPauta);
        if(resultadoEntityOptinal.isPresent()) {
            ResultadoVotacaoEntidade resultadoVotacaoEntity = resultadoEntityOptinal.get();
            return  Optional.of( ResultadoVotacao.builder().todosSim(resultadoVotacaoEntity.getTodosSim()).todosNao(resultadoVotacaoEntity.getTodosNao())
                    .idenficadorPauta(resultadoVotacaoEntity.getIdenficadorPauta()).totalVotos(resultadoVotacaoEntity.getTotalVotos()).build());

        }

        return Optional.empty();
    }

    @Override
    public void salvarResultado(ResultadoVotacao resultadoVotacao) {
        ResultadoVotacaoEntidade resultadoVotacaoEntity = ResultadoVotacaoEntidade.builder().
                idenficadorPauta(resultadoVotacao.getIdenficadorPauta())
                .todosNao(resultadoVotacao.getTodosNao())
                .totalVotos(resultadoVotacao.getTotalVotos()).todosSim(resultadoVotacao.getTodosSim()).build();
        Optional<ResultadoVotacaoEntidade> optionalResultado = resultadoVotacaoRepositorioI.findByIdenficadorPauta(resultadoVotacao.getIdenficadorPauta());

        if(optionalResultado.isPresent()){
            ResultadoVotacaoEntidade resul = optionalResultado.get();
            optionalResultado.get().setTodosNao(
                    resultadoVotacao.getTodosNao());
            optionalResultado.get().setTodosSim(resultadoVotacao.getTodosSim());
            optionalResultado.get().setTotalVotos(resultadoVotacao.getTotalVotos());
            optionalResultado.get().setVotacaoEncerrada(resultadoVotacao.isVotacaoEncerrada());

            resultadoVotacaoRepositorioI.save(optionalResultado.get());
        }else{
            resultadoVotacaoRepositorioI.save(resultadoVotacaoEntity);
        }

    }
}
