package br.com.desafio.votacaoservice.infraestrutura.postgres.repositorio;



import br.com.desafio.votacaoservice.dominio.Votacao;
import br.com.desafio.votacaoservice.dominio.VotacaoRepositorio;
import br.com.desafio.votacaoservice.infraestrutura.postgres.entidades.VotacaoEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public class VotacaoRepositorioPostgres implements VotacaoRepositorio {

    private final VotacaoRepositorioI votacaoRepositorioI;

    @Autowired
    public VotacaoRepositorioPostgres(VotacaoRepositorioI votacaoRepositorioI) {
        this.votacaoRepositorioI = votacaoRepositorioI;
    }

    @Override
    public Optional<Votacao> buscarVoto(String identificadorPauta, String idenficadorAssociado) {
        Optional<VotacaoEntity> votacaoOptional = votacaoRepositorioI.findByIdentificadorPautaAndIdentificadorAssociado(identificadorPauta, idenficadorAssociado);
        if(votacaoOptional.isPresent()){
            VotacaoEntity votacaoEntity = votacaoOptional.get();
            return Optional.of( new Votacao(votacaoEntity.getIdentificadorAssociado(),votacaoEntity.isVoto(),votacaoEntity.getIdentificadorPauta()));
        }
        return Optional.empty();
    }

    @Override
    public void votar(Votacao votacao) {
        VotacaoEntity votacaoEntity = new VotacaoEntity(votacao.getAssociado().cpf(), votacao.isVoto(), votacao.getIdentificadorPauta());
        votacaoRepositorioI.save(votacaoEntity);
    }
}
