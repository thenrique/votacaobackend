package br.com.desafio.abrirsessaoservice.dominio.validacoes;


import br.com.desafio.abrirsessaoservice.dominio.Pauta;

public class SessaoJaFoiAberta extends RuntimeException {

    public SessaoJaFoiAberta(Pauta pauta) {
        super("A sessao de pauta "+pauta.getIdentificador() + " já está aberta" );
    }
}
