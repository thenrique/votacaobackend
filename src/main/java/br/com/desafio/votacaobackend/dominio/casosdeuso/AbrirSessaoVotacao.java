package br.com.desafio.votacaobackend.dominio.casosdeuso;


public interface AbrirSessaoVotacao {
    void execute(String identificadorPauta, Long duracao);
}
