package br.com.desafio.abrirsessaoservice.dominio.validacoes;


public class SessaoJaFoiAberta extends RuntimeException {

    public SessaoJaFoiAberta(String identificador) {
        super("A sessao de pauta "+identificador+ " já está aberta" );
    }
}
