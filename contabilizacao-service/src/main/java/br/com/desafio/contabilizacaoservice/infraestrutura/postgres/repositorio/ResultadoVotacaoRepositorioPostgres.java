package br.com.desafio.contabilizacaoservice.infraestrutura.postgres.repositorio;


import br.com.desafio.contabilizacaoservice.dominio.casodeuso.ResultadoVotacao;
import br.com.desafio.contabilizacaoservice.dominio.casodeuso.ResultadoVotacaoRepositorio;
import br.com.desafio.contabilizacaoservice.infraestrutura.postgres.entidade.ResultadoVotacaoEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


import java.util.Optional;


@Repository
public class
ResultadoVotacaoRepositorioPostgres implements ResultadoVotacaoRepositorio {

    private final ResultadoVotacaoRepositorioI resultadoVotacaoRepositorioI;

    @Autowired
    public ResultadoVotacaoRepositorioPostgres(ResultadoVotacaoRepositorioI resultadoVotacaoRepositorioI) {
        this.resultadoVotacaoRepositorioI = resultadoVotacaoRepositorioI;
    }

    @Override
    public void salvarResultado(ResultadoVotacao resultadoVotacao) {

        ResultadoVotacaoEntity resultadoVotacaoEntity = ResultadoVotacaoEntity.builder().
                                        idenficadorPauta(resultadoVotacao.getIdenficadorPauta())
                                        .todosNao(resultadoVotacao.getTodosNao())
                .totalVotos(resultadoVotacao.getTotalVotos()).todosSim(resultadoVotacao.getTodosSim()).build();
        Optional<ResultadoVotacaoEntity> optionalResultado = resultadoVotacaoRepositorioI.findByIdenficadorPauta(resultadoVotacao.getIdenficadorPauta());

        if(optionalResultado.isPresent()){
            optionalResultado.get().setTodosNao(resultadoVotacaoEntity.getTodosNao());
            optionalResultado.get().setTodosSim(resultadoVotacao.getTodosSim());
            optionalResultado.get().setTotalVotos(resultadoVotacao.getTotalVotos());
            resultadoVotacaoRepositorioI.save(optionalResultado.get());
        }else{
            resultadoVotacaoRepositorioI.save(resultadoVotacaoEntity);
        }

    }

    @Override
    public Optional<ResultadoVotacao> resultadoJaContabilizado(String identificadorPauta) {
        Optional<ResultadoVotacaoEntity> resultadoEntityOptinal = resultadoVotacaoRepositorioI.findByIdenficadorPauta(identificadorPauta);
        if(resultadoEntityOptinal.isPresent()) {
            ResultadoVotacaoEntity resultadoVotacaoEntity = resultadoEntityOptinal.get();
            return  Optional.of(new ResultadoVotacao(resultadoVotacaoEntity.getIdenficadorPauta(), resultadoVotacaoEntity.getTotalVotos(),resultadoVotacaoEntity.getTodosSim(),resultadoVotacaoEntity.getTodosNao()));
        }
        return Optional.empty();
    }
}
