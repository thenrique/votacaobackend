package br.com.desafio.abrirsessaoservice.dominio.validacoes;


import br.com.desafio.abrirsessaoservice.dominio.Pauta;

import java.util.Optional;

public class ValidacaoSessaoJaFoiAberta implements ValidacoesDePautas {



    @Override
    public void validar(Optional<Pauta> optionalPauta) {
        if(optionalPauta.get().getSessao()!=null){
            throw new SessaoJaFoiAberta(optionalPauta.get());
        }
    }
}
