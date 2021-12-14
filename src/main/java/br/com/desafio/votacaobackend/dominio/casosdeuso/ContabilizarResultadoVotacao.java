package br.com.desafio.votacaobackend.dominio.casosdeuso;


import br.com.desafio.votacaobackend.dominio.Pauta;



public interface ContabilizarResultadoVotacao {
    Pauta execute(String identificadorPauta);
}
