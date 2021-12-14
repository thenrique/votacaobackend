package br.com.desafio.votacaobackend.dominio;

import br.com.desafio.votacaobackend.dominio.validacoes.ValidacoesDePautas;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;


public class Pauta {

    @Getter
    private String identificador;
    @Getter
    private String nome;
    @Getter
    private Sessao sessao;

    private List<ValidacoesDePautas> validacoes;
    private Set<Votacao> votosDaPauta = new HashSet<>();


    public Pauta(String identificador) {
        this.identificador = identificador;
    }
    public Pauta(String identificador, String nome) {
        this.identificador = identificador;
        this.nome = nome;
    }

    public Pauta(String identificador, String nome, LocalDateTime aberturaSessao, LocalDateTime dataEncerramentoSessao) {
        this.identificador = identificador;
        this.nome = nome;
        this.sessao = new Sessao(aberturaSessao, dataEncerramentoSessao);
    }

    public void abreSessao(Long duracao, PautaRepositorio pautaRepositorio) {
        this.sessao = new Sessao(duracao);
        pautaRepositorio.abrirSessao(this);
    }

    public boolean isSessaoAberta(){
        return getSessao()!=null && getSessao().isAberta();
    }


    public void votar(boolean voto, String identificadorAssociado, PautaRepositorio pautaRepositorio) {
        Votacao votacao = new Votacao(identificadorAssociado,voto, this );
        this.votosDaPauta.add(votacao);
        pautaRepositorio.votar(votacao);
    }



    @Override
    public int hashCode() {
        return Objects.hash(identificador, nome, sessao, votosDaPauta);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pauta pauta = (Pauta) o;
        return Objects.equals(identificador, pauta.identificador) && Objects.equals(nome, pauta.nome) && Objects.equals(sessao, pauta.sessao) && Objects.equals(votosDaPauta, pauta.votosDaPauta);
    }

    public boolean isAssociadoJaVotou(String identificadorAssociado) {
        return votosDaPauta.parallelStream().anyMatch( votacao ->  votacao.getAssociado().getCpf().equalsIgnoreCase(identificadorAssociado));
    }
}
