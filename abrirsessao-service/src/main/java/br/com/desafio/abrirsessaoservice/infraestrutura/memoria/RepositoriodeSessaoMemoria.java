package br.com.desafio.abrirsessaoservice.infraestrutura.memoria;


import br.com.desafio.abrirsessaoservice.dominio.Sessao;
import br.com.desafio.abrirsessaoservice.dominio.SessaoRepositorio;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Component
@Profile("test")
public class RepositoriodeSessaoMemoria implements SessaoRepositorio {

    private Set<Sessao> sessoesAbertas = new HashSet<>();

    public RepositoriodeSessaoMemoria() {

        sessoesAbertas.add(new Sessao(Long.valueOf(50),"123"));
        sessoesAbertas.add(new Sessao(Long.valueOf(50),"1235"));
        sessoesAbertas.add(new Sessao(Long.valueOf(-1),"1236"));
    }

    @Override
    public void abrirSessao(Sessao sessao) {
        sessoesAbertas.add(sessao);
    }

    @Override
    public Optional<Sessao> buscarSessaoPauta(String identificador) {
        return sessoesAbertas.stream().filter(sessao -> sessao.getIdentificadorPauta().equalsIgnoreCase(identificador)).findFirst();
    }





}
