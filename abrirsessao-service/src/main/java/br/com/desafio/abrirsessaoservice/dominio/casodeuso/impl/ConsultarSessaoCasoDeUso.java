package br.com.desafio.abrirsessaoservice.dominio.casodeuso.impl;

import br.com.desafio.abrirsessaoservice.dominio.Sessao;
import br.com.desafio.abrirsessaoservice.dominio.SessaoRepositorio;
import br.com.desafio.abrirsessaoservice.dominio.casodeuso.ConsultarSessaoVotacao;

import java.util.Optional;

public class ConsultarSessaoCasoDeUso implements ConsultarSessaoVotacao {

    private SessaoRepositorio sessaoRepositorio;

    public ConsultarSessaoCasoDeUso(SessaoRepositorio sessaoRepositorio) {
        this.sessaoRepositorio = sessaoRepositorio;
    }

    @Override
    public Sessao buscarSessao(String identificadorPauta) {
        Optional<Sessao> optionalSessao = sessaoRepositorio.buscarSessaoPauta(identificadorPauta);

        if(optionalSessao.isPresent())
            return optionalSessao.get();

        return null;
    }
}
