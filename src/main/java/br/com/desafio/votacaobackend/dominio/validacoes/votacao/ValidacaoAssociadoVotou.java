package br.com.desafio.votacaobackend.dominio.validacoes.votacao;

import br.com.desafio.votacaobackend.dominio.Pauta;
import br.com.desafio.votacaobackend.dominio.casosdeuso.dto.VotoDto;

public class ValidacaoAssociadoVotou implements ValidacaoVotacao {

    @Override
    public void validar(VotoDto votoDto, Pauta pauta) {

        if(pauta.isAssociadoJaVotou(votoDto.getIdentificadorAssociado())){
            throw new AssociadoJaComputouVoto(votoDto.getIdentificadorAssociado(), pauta.getIdentificador());
        }
    }
}
