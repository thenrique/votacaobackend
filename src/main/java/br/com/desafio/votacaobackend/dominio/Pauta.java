package br.com.desafio.votacaobackend.dominio;

import br.com.desafio.votacaobackend.dominio.validacoes.ValidacoesDePautas;

import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;


public class Pauta {

    private String identificador;
    private String nome;

    private Sessao sessao;

    private List<ValidacoesDePautas> validacoes;

    private Set<Votacao> votos = new HashSet();


    public Pauta(String identificador) {
        this.identificador = identificador;
    }
    public Pauta(String identificador, String nome) {
        this.identificador = identificador;
        this.nome = nome;
    }

    public String getIdentificador() {
        return identificador;
    }


    public void abreSessao(Long duracao, PautaRepositorio pautaRepositorio) {
        this.sessao = new Sessao(duracao);
        pautaRepositorio.atualizaPauta(this);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pauta pauta = (Pauta) o;
        return Objects.equals(identificador, pauta.identificador) && Objects.equals(nome, pauta.nome) && Objects.equals(sessao, pauta.sessao) && Objects.equals(votos, pauta.votos);
    }

    public Sessao getSessao() {
        return sessao;
    }

    @Override
    public int hashCode() {
        return Objects.hash(identificador, nome, sessao, votos);
    }
}
