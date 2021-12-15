package br.com.desafio.votacaobackend.dominio.casosdeuso;


import br.com.desafio.votacaobackend.dominio.validacoes.SessaoNaoEstaAberta;

public interface CadastrarVoto {
    
    void execute(String identificadorPauta, String associado, boolean voto) throws RuntimeException;
}
