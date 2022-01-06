package br.com.desafio.pautaservice.dominio.casosdeuso;


import java.util.Optional;

public interface PautaRepositorio {

    void cadastrarPauta(Pauta pauta);

    Optional<Pauta> buscarPauta(String identificador);

}
