package br.com.desafio.votacaobackend.infraestrutura.memoria.postgres;

import br.com.desafio.votacaobackend.dominio.Pauta;
import br.com.desafio.votacaobackend.dominio.PautaRepositorio;
import br.com.desafio.votacaobackend.dominio.Votacao;

import java.util.Optional;


public class RepositorioDePautasPostgres implements PautaRepositorio {



    @Override
    public void cadastrarPauta(Pauta pauta) {
        PautaEntidade pautaEntidade = new PautaEntidade(pauta);
    }

    @Override
    public Optional<Pauta> buscarPauta(String identificador) {
       /* Optional<PautaEntidade> optionalPautaEntidade = jpaRepository.findAll().stream().filter(pautaEntidade -> pautaEntidade.getIdentificador().equalsIgnoreCase(identificador)).findFirst();
        PautaEntidade pautaEntidade = optionalPautaEntidade.get();
        Pauta pauta = new Pauta(pautaEntidade.getIdentificador(), pautaEntidade.getNome(), pautaEntidade.getAberturaSessao(), pautaEntidade.getDataEncerramentoSessao());

        return Optional.of(pauta);*/
        return null;
    }

    @Override
    public void abrirSessao(Pauta pauta) {
        PautaEntidade pautaEntidade = new PautaEntidade(pauta);

    }

    @Override
    public void votar(Votacao votacao) {

    }

}
