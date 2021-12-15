package br.com.desafio.votacaobackend.dominio.validacoes.votacao;

import br.com.desafio.votacaobackend.dominio.Pauta;
import br.com.desafio.votacaobackend.dominio.validacoes.SessaoNaoEstaAberta;
import br.com.desafio.votacaobackend.dominio.validacoes.ValidacoesDePautas;

import java.util.Optional;

public class ValidacaoSessaoAberta implements ValidacoesDePautas {
    @Override
    public void validar(Optional<Pauta> optionalPauta) {
        Pauta pauta = optionalPauta.get();
        if(!pauta.isSessaoAberta()){
            throw new SessaoNaoEstaAberta();
        }
    }
}
