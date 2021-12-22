package br.com.desafio.abrirsessaoservice.infraestrutura.postgres.repositorio;



import br.com.desafio.abrirsessaoservice.dominio.Sessao;
import br.com.desafio.abrirsessaoservice.dominio.SessaoRepositorio;
import br.com.desafio.abrirsessaoservice.infraestrutura.postgres.entidades.SessaoEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public class SessaoRepositorioPostgres implements SessaoRepositorio {

    private final SessaoRepositorioI sessaoRepositorio;

    @Autowired
    public SessaoRepositorioPostgres(SessaoRepositorioI sessaoRepositorio) {
        this.sessaoRepositorio = sessaoRepositorio;
    }


    @Override
    public void abrirSessao(Sessao sessao) {
        SessaoEntity sessaoEntity = SessaoEntity.builder().identificadorPauta(sessao.getIdentificadorPauta()).dataAbertura(sessao.getDataAbertura())
                        .dataEncerramento(sessao.getDataEncerramento()).duracao(sessao.getDuracaoSesao().toMinutes()).build();
        sessaoRepositorio.save(sessaoEntity);
    }

    @Override
    public Optional<Sessao> buscarSessaoPauta(String identificadorPauta) {
        Optional<SessaoEntity> sessaoEntityOptional = sessaoRepositorio.findByIdentificadorPauta(identificadorPauta);
        if(sessaoEntityOptional.isPresent()){
            SessaoEntity sessaoEntity = sessaoEntityOptional.get();
            return Optional.of(new Sessao(sessaoEntity.getDuracao(),sessaoEntity.getIdentificadorPauta(), sessaoEntity.getDataAbertura(),sessaoEntity.getDataEncerramento()));
        }
        return Optional.ofNullable(null);
    }
}
