package br.com.desafio.abrirsessaoservice.dominio.validacoes;

public class SessaoNaoExiste extends RuntimeException{


    public SessaoNaoExiste(String identificadorPauta) {
        super("A sessão da pauta informada "+ identificadorPauta + " não existe");
    }
}
