package br.com.desafio.votacaobackend.dominio.validacoes.votacao;


import br.com.desafio.votacaobackend.dominio.Pauta;
import br.com.desafio.votacaobackend.dominio.casosdeuso.dto.VotoDto;

public interface ValidacaoVotacao {

    public void validar(VotoDto votoDto, Pauta pauta);
}
