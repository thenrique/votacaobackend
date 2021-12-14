package br.com.desafio.votacaobackend.dominio.casosdeuso.impl;

import br.com.desafio.votacaobackend.aplicacao.dto.VotoDto;
import br.com.desafio.votacaobackend.dominio.Pauta;
import br.com.desafio.votacaobackend.dominio.PautaRepositorio;
import br.com.desafio.votacaobackend.dominio.casosdeuso.CadastrarVoto;
import br.com.desafio.votacaobackend.dominio.validacoes.*;
import br.com.desafio.votacaobackend.dominio.validacoes.votacao.ValidacaoAssociadoVotou;
import br.com.desafio.votacaobackend.dominio.validacoes.votacao.ValidacaoSessaoAberta;
import br.com.desafio.votacaobackend.dominio.validacoes.votacao.ValidacaoVotacao;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Component
public class VotarCasoDeUso implements CadastrarVoto {

    private PautaRepositorio pautaRepositorio;

    private List<ValidacoesDePautas> validacaoPautas = Arrays.asList(new ValidacaoPautaInexistente(), new ValidacaoSessaoAberta());
    private List<ValidacaoVotacao> validacoesVotacao = Arrays.asList( new ValidacaoAssociadoVotou());

    public VotarCasoDeUso(PautaRepositorio pautaRepositorio) {
        this.pautaRepositorio = pautaRepositorio;
    }

    @Override
    public void execute(VotoDto votoDto) throws RuntimeException {
        Pauta pauta = buscarPauta(votoDto);
        verificarSituacaoVoto(votoDto, pauta);
        pauta.votar(votoDto.isVoto(), votoDto.getIdentificadorAssociado(), pautaRepositorio);
    }

    private void verificarSituacaoVoto(VotoDto votoDto, Pauta pauta) {
        validacoesVotacao.parallelStream().forEach(validacaoVotacao -> validacaoVotacao.validar(votoDto, pauta));
    }

    private Pauta buscarPauta(VotoDto votoDto) {
        Optional<Pauta> pautaOptional = pautaRepositorio.buscarPauta(votoDto.getIdentificadorPauta());
        validacaoPautas.parallelStream().forEach( validacoesDePautas -> validacoesDePautas.validar(pautaOptional));

        return pautaOptional.get();

    }
}
