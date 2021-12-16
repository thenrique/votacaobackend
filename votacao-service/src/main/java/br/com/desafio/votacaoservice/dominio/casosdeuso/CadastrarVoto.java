package br.com.desafio.votacaoservice.dominio.casosdeuso;


public interface CadastrarVoto {
    
    void execute(String identificadorPauta, String associado, boolean voto) throws RuntimeException;
}
