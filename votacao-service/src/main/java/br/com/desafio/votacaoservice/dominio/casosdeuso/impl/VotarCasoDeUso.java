package br.com.desafio.votacaoservice.dominio.casosdeuso.impl;


import br.com.desafio.votacaoservice.dominio.*;
import br.com.desafio.votacaoservice.dominio.CadastrarVoto;
import br.com.desafio.votacaoservice.dominio.dto.PautaSessaoDto;
import br.com.desafio.votacaoservice.dominio.validacao.AssociadoJaComputouVoto;
import br.com.desafio.votacaoservice.dominio.validacao.CPFInvalido;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class VotarCasoDeUso implements CadastrarVoto {

    private final VotacaoRepositorio votacaoRepositorio;
    private final ConsultarSessaoPautas consultarSessaoPautas;
    private final ValidacaoCpf validacaoCPF;
    private final GerenciadorEventos gerenciadorEventos;

    public VotarCasoDeUso(VotacaoRepositorio votacaoRepositorio, ConsultarSessaoPautas consultarSessaoPautas, ValidacaoCpf validacaoCPF, GerenciadorEventos gerenciadorEventos) {
        this.votacaoRepositorio = votacaoRepositorio;
        this.consultarSessaoPautas = consultarSessaoPautas;
        this.validacaoCPF = validacaoCPF;
        this.gerenciadorEventos = gerenciadorEventos;
    }

    @Override
    public void execute(String identificadorPauta, String associado, boolean voto) throws RuntimeException {
       if(!validacaoCPF.isPermitidoVotar(associado)) {
            throw new CPFInvalido(associado);
        }
        PautaSessaoDto sessaoPauta = consultarSessaoPautas.consultar(identificadorPauta);

        if(isSessaoPautaExiste(sessaoPauta)){
            Votacao votacao = new Votacao(associado,voto,identificadorPauta);
            Optional<Votacao> votacaoOptional = votacaoRepositorio.buscarVoto(identificadorPauta, associado);
            if(votacaoOptional.isPresent()){
                throw new AssociadoJaComputouVoto(associado,identificadorPauta);
            }
            votacao.votar(votacao, votacaoRepositorio);
            gerenciadorEventos.executarPosCadastrado(votacao);
        }

    }

    private boolean isSessaoPautaExiste(PautaSessaoDto sessaoPauta) {
        return sessaoPauta != null;
    }

}
