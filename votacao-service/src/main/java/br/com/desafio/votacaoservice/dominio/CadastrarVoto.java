package br.com.desafio.votacaoservice.dominio;


public interface CadastrarVoto {
    
    void execute(String identificadorPauta, String associado, boolean voto) throws RuntimeException;
}
