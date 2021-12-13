package br.com.desafio.votacaobackend.infraestrutura.memoria.postgres;

import br.com.desafio.votacaobackend.dominio.Pauta;
import br.com.desafio.votacaobackend.dominio.PautaRepositorio;
import br.com.desafio.votacaobackend.dominio.Votacao;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class RepositorioDePautasPostgres implements PautaRepositorio {

    @Autowired
    private JpaRepository<PautaEntidade, Long> jpaRepository;


    @Override
    public void cadastrarPauta(Pauta pauta) {
        PautaEntidade pautaEntidade = new PautaEntidade(pauta);
        jpaRepository.save(pautaEntidade);
    }

    @Override
    public Optional<Pauta> buscarPauta(String identificador) {
        Optional<PautaEntidade> optionalPautaEntidade = jpaRepository.findAll().stream().filter(pautaEntidade -> pautaEntidade.getIdentificador().equalsIgnoreCase(identificador)).findFirst();
        PautaEntidade pautaEntidade = optionalPautaEntidade.get();
        Pauta pauta = new Pauta(pautaEntidade.getIdentificador(), pautaEntidade.getNome(), pautaEntidade.getAberturaSessao(), pautaEntidade.getDataEncerramentoSessao());

        return Optional.of(pauta);
    }

    @Override
    public void abrirSessao(Pauta pauta) {
        PautaEntidade pautaEntidade = new PautaEntidade(pauta);
        jpaRepository.save(pautaEntidade);
    }

    @Override
    public void votar(Votacao votacao) {

    }

}
