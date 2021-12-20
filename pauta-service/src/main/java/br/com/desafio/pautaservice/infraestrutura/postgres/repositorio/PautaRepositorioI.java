package br.com.desafio.pautaservice.infraestrutura.postgres.repositorio;


import br.com.desafio.pautaservice.infraestrutura.postgres.entidades.PautaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public interface PautaRepositorioI extends JpaRepository<PautaEntity, Long> {

    Optional<PautaEntity> findByIdentificador(String identificador);
}
