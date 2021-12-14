package br.com.desafio.votacaobackend.dominio.casosdeuso.impl;

import br.com.desafio.votacaobackend.aplicacao.dto.SessaoDto;
import br.com.desafio.votacaobackend.dominio.*;
import br.com.desafio.votacaobackend.dominio.casosdeuso.AbrirSessaoVotacao;
import br.com.desafio.votacaobackend.dominio.validacoes.ValidacaoPautaInexistente;
import br.com.desafio.votacaobackend.dominio.validacoes.ValidacaoSessaoJaFoiAberta;
import br.com.desafio.votacaobackend.dominio.validacoes.ValidacoesDePautas;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Component
public class AbrirSessaoCasoDeUso implements AbrirSessaoVotacao {

    private final PautaRepositorio pautaRepositorio;

    private List<ValidacoesDePautas> validacoes;


    public AbrirSessaoCasoDeUso(PautaRepositorio pautaRepositorio) {
        this.pautaRepositorio = pautaRepositorio;
        validacoes = Arrays.asList(new ValidacaoPautaInexistente(), new ValidacaoSessaoJaFoiAberta());
    }

    @Override
    public void execute(SessaoDto sessaoDto){
        Optional<Pauta> pautaOptional = pautaRepositorio.buscarPauta(sessaoDto.getIdentificadorPauta());
        validacoes.forEach(validacoesDePautas -> validacoesDePautas.validar(pautaOptional));
        Pauta pauta = pautaOptional.get();
        pauta.abreSessao(sessaoDto.getDuracao(),pautaRepositorio);

    }
}
