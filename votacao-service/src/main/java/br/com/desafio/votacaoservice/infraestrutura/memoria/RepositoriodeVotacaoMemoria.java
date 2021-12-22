package br.com.desafio.votacaoservice.infraestrutura.memoria;


import br.com.desafio.votacaoservice.dominio.Votacao;
import br.com.desafio.votacaoservice.dominio.VotacaoRepositorio;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Component
@Profile("test")
public class RepositoriodeVotacaoMemoria implements VotacaoRepositorio {

    private Set<Votacao> votosPauta = new HashSet<>();

    public RepositoriodeVotacaoMemoria() {
        votosPauta.add(new Votacao("95346141065",true,"1234"));
        votosPauta.add(new Votacao("67103239002",false,"1234"));
        votosPauta.add(new Votacao("05207600001",true,"1234"));
        votosPauta.add(new Votacao("73742158007",true,"1234"));

    }

    @Override
    public void votar(Votacao votacao) {
        votosPauta.add(votacao);
    }

    @Override
    public Optional<Votacao> buscarVoto(String identificadorPauta, String idenficadorAssociado) {
        return votosPauta.stream().filter(votacao -> votacao.getIdentificadorPauta().equalsIgnoreCase(identificadorPauta) && votacao.getAssociado().cpf().equalsIgnoreCase(idenficadorAssociado)).findFirst();
    }
}
