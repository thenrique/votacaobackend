package br.com.desafio.pautaservice.infraestrutura.memoria;

import br.com.desafio.pautaservice.dominio.casosdeuso.Pauta;
import br.com.desafio.pautaservice.dominio.casosdeuso.PautaRepositorio;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Component
@Profile("test")
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


}
