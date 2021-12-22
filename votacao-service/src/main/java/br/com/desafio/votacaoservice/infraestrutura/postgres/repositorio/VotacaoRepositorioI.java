package br.com.desafio.votacaoservice.infraestrutura.postgres.repositorio;


import br.com.desafio.votacaoservice.infraestrutura.postgres.entidades.VotacaoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public interface VotacaoRepositorioI extends JpaRepository<VotacaoEntity, Long> {


    Optional<VotacaoEntity> findByIdentificadorPautaAndIdentificadorAssociado(String identificadorPauta, String idenficadorAssociado);
}
