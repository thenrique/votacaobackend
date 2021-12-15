package br.com.desafio.pautaservice.dominio.casosdeuso;


import java.util.Optional;

public interface PautaRepositorio {

    public void cadastrarPauta(Pauta pauta);

    public Optional<Pauta> buscarPauta(String identificador);

}
