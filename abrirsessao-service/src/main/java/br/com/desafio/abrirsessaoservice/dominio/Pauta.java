package br.com.desafio.abrirsessaoservice.dominio;

import br.com.desafio.abrirsessaoservice.dominio.validacoes.ValidacaoPautaInexistente;
import br.com.desafio.abrirsessaoservice.dominio.validacoes.ValidacaoSessaoJaFoiAberta;

import br.com.desafio.abrirsessaoservice.dominio.validacoes.ValidacoesDePautas;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.*;


public class Pauta {

    @Getter
    private String identificador;
    @Getter
    private Sessao sessao;

    @Getter
    private List<ValidacoesDePautas> validacoes = Arrays.asList(new ValidacaoPautaInexistente(), new ValidacaoSessaoJaFoiAberta()); ;

    public Pauta(String identificador) {
        this.identificador = identificador;
    }

    public Pauta(String identificador,LocalDateTime aberturaSessao, LocalDateTime dataEncerramentoSessao) {
        this.identificador = identificador;

        this.sessao = new Sessao(aberturaSessao, dataEncerramentoSessao);
    }

    public void abreSessao(Long duracao, PautaRepositorio pautaRepositorio) {
        this.sessao = new Sessao(duracao);
        pautaRepositorio.abrirSessao(this);
    }


    @Override
    public int hashCode() {
        return Objects.hash(identificador,  sessao);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pauta pauta = (Pauta) o;
        return Objects.equals(identificador, pauta.identificador)  && Objects.equals(sessao, pauta.sessao) ;
    }

}
