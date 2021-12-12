package br.com.desafio.votacaobackend.dominio.validacoes;

import br.com.desafio.votacaobackend.dominio.Pauta;

import java.util.Optional;

public interface ValidacoesDePautas {

    public void validar(Optional<Pauta> optionalPauta);
}
