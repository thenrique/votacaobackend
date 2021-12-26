package br.com.desafio.contabilizacaoservice.dominio.casodeuso;


import br.com.desafio.contabilizacaoservice.dominio.VotoDto;

public interface ContabilizarResultadoVotacao {

    void execute(VotoDto votoDto);
}
