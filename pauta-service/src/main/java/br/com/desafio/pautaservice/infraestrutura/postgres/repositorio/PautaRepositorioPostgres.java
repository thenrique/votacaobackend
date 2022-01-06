package br.com.desafio.pautaservice.infraestrutura.postgres.repositorio;


import br.com.desafio.pautaservice.dominio.casosdeuso.Pauta;
import br.com.desafio.pautaservice.dominio.casosdeuso.PautaRepositorio;
import br.com.desafio.pautaservice.infraestrutura.postgres.entidades.PautaEntity;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Component()
public class PautaRepositorioPostgres implements PautaRepositorio {

    private final PautaRepositorioI pautaRepository;

    @Autowired
    public PautaRepositorioPostgres(PautaRepositorioI pautaRepository) {
        this.pautaRepository = pautaRepository;
    }

    @Override
    public void cadastrarPauta(Pauta pauta) {
        PautaEntity pautaEntity = new PautaEntity(pauta.getIdentificador(),pauta.getNome());
        pautaRepository.save(pautaEntity);
    }

    @Override
    public Optional<Pauta> buscarPauta(String identificador) {
        Optional<PautaEntity> pautaEntity = pautaRepository.findByIdentificador(identificador);

       if(pautaEntity.isPresent())
           return Optional.of(new Pauta(pautaEntity.get().getIdentificador(), pautaEntity.get().getNome()));

        return Optional.ofNullable(null);
    }
}
