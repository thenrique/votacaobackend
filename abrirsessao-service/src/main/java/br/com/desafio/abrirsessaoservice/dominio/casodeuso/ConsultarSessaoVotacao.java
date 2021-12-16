package br.com.desafio.abrirsessaoservice.dominio.casodeuso;

import br.com.desafio.abrirsessaoservice.dominio.Sessao;

public interface ConsultarSessaoVotacao {

    Sessao buscarSessao(String identificadorPauta);
}
