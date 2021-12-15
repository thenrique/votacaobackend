package br.com.desafio.abrirsessaoservice.infraestrutura.memoria;


import br.com.desafio.abrirsessaoservice.dominio.Pauta;
import br.com.desafio.abrirsessaoservice.dominio.PautaRepositorio;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Component
public class RepositoriodePautaMemoria implements PautaRepositorio {

    private Set<Pauta> pautas = new HashSet<>();

    public RepositoriodePautaMemoria() {
        pautas.add(new Pauta("123"));
    }

    @Override
    public Optional<Pauta> buscarPauta(String identificador) {
        return pautas.stream().filter(pauta -> pauta.getIdentificador().equalsIgnoreCase(identificador)).findFirst();
    }

    @Override
    public void abrirSessao(Pauta pauta) {
        pautas.remove(pauta);
        pautas.add(pauta);
    }



}
