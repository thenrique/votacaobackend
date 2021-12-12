package br.com.desafio.votacaobackend.infraestrutura.memoria;

import br.com.desafio.votacaobackend.dominio.Pauta;
import br.com.desafio.votacaobackend.dominio.PautaRepositorio;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Component
public class RepositoriodePautaMemoria implements PautaRepositorio {

    private Set<Pauta> pautas = new HashSet<>();

    @Override
    public void cadastrarPauta(Pauta pauta) {
        pautas.add(pauta);
    }

    @Override
    public Optional<Pauta> buscarPauta(String identificador) {
        return pautas.stream().filter(pauta -> pauta.getIdentificador().equalsIgnoreCase(identificador)).findFirst();
    }

    @Override
    public void atualizaPauta(Pauta pauta) {
        pautas.remove(pauta);
        pautas.add(pauta);
    }

}
