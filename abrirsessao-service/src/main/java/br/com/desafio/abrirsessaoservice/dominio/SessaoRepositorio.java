package br.com.desafio.abrirsessaoservice.dominio;


import java.util.Optional;

public interface SessaoRepositorio {

    void abrirSessao(Sessao sessao);

    Optional<Sessao> buscarSessaoPauta(String identificadorPauta);
}
