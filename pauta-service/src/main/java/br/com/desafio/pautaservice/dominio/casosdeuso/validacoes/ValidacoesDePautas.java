package br.com.desafio.pautaservice.dominio.casosdeuso.validacoes;

import br.com.desafio.pautaservice.dominio.casosdeuso.Pauta;


import java.util.Optional;

public interface ValidacoesDePautas {

    public void validar(Optional<Pauta> optionalPauta);
}
