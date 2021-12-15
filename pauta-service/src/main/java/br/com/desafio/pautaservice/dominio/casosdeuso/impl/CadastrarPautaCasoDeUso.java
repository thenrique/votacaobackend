package br.com.desafio.pautaservice.dominio.casosdeuso.impl;

import br.com.desafio.pautaservice.dominio.casosdeuso.CadastrarPauta;
import br.com.desafio.pautaservice.dominio.casosdeuso.Pauta;
import br.com.desafio.pautaservice.dominio.casosdeuso.PautaRepositorio;

import br.com.desafio.pautaservice.dominio.casosdeuso.validacoes.PautaJaExistente;
import org.springframework.stereotype.Component;

import java.util.Optional;


@Component
public class CadastrarPautaCasoDeUso implements CadastrarPauta {

    private PautaRepositorio pautaRepositorio;

    public CadastrarPautaCasoDeUso(PautaRepositorio pautaRepositorio) {
        this.pautaRepositorio = pautaRepositorio;
    }

    @Override
    public void execute(String identificadorPauta, String nome){
        Optional<Pauta> pautaJaCadastrada = pautaRepositorio.buscarPauta(identificadorPauta);
        if(pautaJaCadastrada.isPresent()){
            throw new PautaJaExistente(identificadorPauta);
        }
        Pauta pauta = new Pauta(identificadorPauta, nome);
        pautaRepositorio.cadastrarPauta(pauta);

    }
}
