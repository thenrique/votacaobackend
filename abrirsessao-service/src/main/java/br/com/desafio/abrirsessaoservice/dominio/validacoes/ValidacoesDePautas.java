package br.com.desafio.abrirsessaoservice.dominio.validacoes;


import br.com.desafio.abrirsessaoservice.dominio.Pauta;

import java.util.Optional;

public interface ValidacoesDePautas {

     void validar(Optional<Pauta> optionalPauta);
}
