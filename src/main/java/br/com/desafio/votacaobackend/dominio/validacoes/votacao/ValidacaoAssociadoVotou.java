package br.com.desafio.votacaobackend.dominio.validacoes.votacao;

import br.com.desafio.votacaobackend.aplicacao.dto.VotoDto;
import br.com.desafio.votacaobackend.dominio.Pauta;

public class ValidacaoAssociadoVotou implements ValidacaoVotacao {

    @Override
    public void validar(VotoDto votoDto, Pauta pauta) {

        if(pauta.isAssociadoJaVotou(votoDto.getIdentificadorAssociado())){
            throw new AssociadoJaComputouVoto(votoDto.getIdentificadorAssociado(), pauta.getIdentificador());
        }
    }
}
