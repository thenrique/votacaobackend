package br.com.desafio.abrirsessaoservice.infraestrutura.postgres.repositorio;


import br.com.desafio.abrirsessaoservice.infraestrutura.postgres.entidades.SessaoEntity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public interface SessaoRepositorioI extends JpaRepository<SessaoEntity, Long> {

    Optional<SessaoEntity> findByIdentificadorPauta(String identificador);
}
