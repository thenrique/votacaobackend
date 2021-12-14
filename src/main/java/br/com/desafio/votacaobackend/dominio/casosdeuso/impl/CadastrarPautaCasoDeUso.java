package br.com.desafio.votacaobackend.dominio.casosdeuso.impl;

import br.com.desafio.votacaobackend.dominio.Pauta;
import br.com.desafio.votacaobackend.dominio.casosdeuso.CadastrarPauta;
import br.com.desafio.votacaobackend.dominio.validacoes.PautaJaExistente;
import br.com.desafio.votacaobackend.dominio.PautaRepositorio;
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
