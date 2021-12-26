package br.com.desafio.exibirresultadoservice.infraestrutura.postgres.repositorio;


import br.com.desafio.exibirresultadoservice.infraestrutura.postgres.entidade.ResultadoVotacaoEntidade;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public interface
ResultadoVotacaoRepositorioI extends JpaRepository<ResultadoVotacaoEntidade, Long> {


    Optional<ResultadoVotacaoEntidade> findByIdenficadorPauta(String identificadorPauta);
}
