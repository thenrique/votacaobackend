package br.com.desafio.abrirsessaoservice.dominio;


import java.util.Optional;

public interface PautaRepositorio {

    Optional<Pauta> buscarPauta(String identificador);

    void abrirSessao(Pauta pauta);

}
