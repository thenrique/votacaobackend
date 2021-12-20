package br.com.desafio.pautaservice.dominio.casosdeuso.impl;

import br.com.desafio.pautaservice.dominio.casosdeuso.ConsultarPauta;
import br.com.desafio.pautaservice.dominio.casosdeuso.Pauta;
import br.com.desafio.pautaservice.dominio.casosdeuso.PautaRepositorio;
import br.com.desafio.pautaservice.dominio.casosdeuso.validacoes.PautaInexistente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class ConsultarPautaCasoDeUso implements ConsultarPauta {

    private PautaRepositorio pautaRepositorio;

    @Autowired
    public ConsultarPautaCasoDeUso(PautaRepositorio pautaRepositorio) {
        this.pautaRepositorio = pautaRepositorio;
    }

    @Override
    public Pauta execute(String identificador) {

        Optional<Pauta> pautaOptional = pautaRepositorio.buscarPauta(identificador);
        if(pautaOptional.isPresent())
            return pautaOptional.get();
        throw new PautaInexistente(identificador);
    }
}
