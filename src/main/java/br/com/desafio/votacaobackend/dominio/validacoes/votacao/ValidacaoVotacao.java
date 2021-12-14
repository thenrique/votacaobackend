package br.com.desafio.votacaobackend.dominio.validacoes.votacao;

import br.com.desafio.votacaobackend.aplicacao.dto.VotoDto;
import br.com.desafio.votacaobackend.dominio.Pauta;

public interface ValidacaoVotacao {

    public void validar(VotoDto votoDto, Pauta pauta);
}
