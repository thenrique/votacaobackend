package br.com.desafio.votacaobackend.dominio;


import java.util.Optional;

public interface PautaRepositorio {

    public void cadastrarPauta(Pauta pauta);

    public Optional<Pauta> buscarPauta(String identificador);

    void abrirSessao(Pauta pauta);

    void votar(Votacao votacao);
}
