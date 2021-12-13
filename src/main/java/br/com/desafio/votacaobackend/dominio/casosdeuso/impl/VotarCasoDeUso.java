package br.com.desafio.votacaobackend.dominio.casosdeuso.impl;

import br.com.desafio.votacaobackend.aplicacao.dto.VotoDto;
import br.com.desafio.votacaobackend.dominio.Pauta;
import br.com.desafio.votacaobackend.dominio.PautaRepositorio;
import br.com.desafio.votacaobackend.dominio.casosdeuso.CadastrarVoto;
import br.com.desafio.votacaobackend.dominio.validacoes.PautaDeIdentificadorInexistente;

import java.util.Optional;

public class VotarCasoDeUso implements CadastrarVoto {

    private PautaRepositorio pautaRepositorio;

    public VotarCasoDeUso(PautaRepositorio pautaRepositorio) {
        this.pautaRepositorio = pautaRepositorio;
    }

    @Override
    public void execute(VotoDto votoDto){
        Optional<Pauta> pautaOptional = pautaRepositorio.buscarPauta(votoDto.getIdentificadorPauta());

        pautaOptional.ifPresentOrElse(pauta -> {
            if(pauta.isSessaoAberta()){
                pauta.votar(votoDto.isVoto(), votoDto.getIdentificadorAssociado(), pautaRepositorio);
            }
        },() -> new PautaDeIdentificadorInexistente());


    }
}
