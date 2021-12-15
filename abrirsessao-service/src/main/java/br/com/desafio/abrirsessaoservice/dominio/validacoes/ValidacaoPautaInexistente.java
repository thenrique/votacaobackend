package br.com.desafio.abrirsessaoservice.dominio.validacoes;



import br.com.desafio.abrirsessaoservice.dominio.Pauta;

import java.util.Optional;

public class ValidacaoPautaInexistente implements ValidacoesDePautas {

    @Override
    public void validar(Optional<Pauta> optionalPauta) {

        if(optionalPauta.isEmpty()){
            throw new PautaDeIdentificadorInexistente();
        }
    }
}
