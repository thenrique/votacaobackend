package br.com.desafio.votacaobackend.cadastrar;

import br.com.desafio.votacaobackend.aplicacao.dto.PautaDto;
import br.com.desafio.votacaobackend.dominio.Pauta;
import br.com.desafio.votacaobackend.dominio.PautaJaExistente;
import br.com.desafio.votacaobackend.dominio.PautaRepositorio;

import java.util.Optional;

public class CadastrarPautaCasoDeUso {

    private PautaRepositorio pautaRepositorio;

    public CadastrarPautaCasoDeUso(PautaRepositorio pautaRepositorio) {
        this.pautaRepositorio = pautaRepositorio;
    }

    public void execute(PautaDto pautaDto){
        Optional<Pauta> pautaJaCadastrada = pautaRepositorio.buscarPauta(pautaDto.getIdentificador());
        if(pautaJaCadastrada.isPresent()){
            throw new PautaJaExistente(pautaDto.getIdentificador());
        }
        Pauta pauta = new Pauta(pautaDto.getIdentificador(), pautaDto.getNome());
        pautaRepositorio.cadastrarPauta(pauta);

    }
}
