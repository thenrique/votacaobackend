package br.com.desafio.contabilizacaoservice.infraestrutura.postgres.repositorio;


import br.com.desafio.contabilizacaoservice.infraestrutura.postgres.entidade.ResultadoVotacaoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public interface ResultadoVotacaoRepositorioI extends JpaRepository<ResultadoVotacaoEntity, Long> {

    Optional<ResultadoVotacaoEntity> findByIdentificador(String identificador);
}
