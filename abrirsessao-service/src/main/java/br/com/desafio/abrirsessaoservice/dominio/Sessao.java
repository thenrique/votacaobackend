package br.com.desafio.abrirsessaoservice.dominio;

import lombok.Getter;

import java.time.Duration;
import java.time.LocalDateTime;

public class Sessao {

    private static final long DURACAO_PADRAO =1 ;
    @Getter
    private LocalDateTime dataAbertura;
    @Getter
    private LocalDateTime dataEncerramento;

    @Getter
    private String identificadorPauta;

    public Sessao(Long duracao, String identificadorPauta) {
        this.dataAbertura = LocalDateTime.now();
        this.identificadorPauta = identificadorPauta;
        if(duracao==null) {
            duracao=DURACAO_PADRAO;
        }
        this.dataEncerramento = dataAbertura.plusMinutes(duracao);
    }
    public Sessao(Long duracao, String identificadorPauta, LocalDateTime dataAbertura, LocalDateTime dataEncerramento) {
        this.dataAbertura = dataAbertura;
        this.identificadorPauta = identificadorPauta;
        if(duracao==null) {
            duracao=DURACAO_PADRAO;
        }
        this.dataEncerramento = dataAbertura.plusMinutes(duracao);
    }

    public Sessao(LocalDateTime aberturaSessao, LocalDateTime dataEncerramentoSessao) {
        this.dataAbertura = aberturaSessao;
        this.dataEncerramento = dataEncerramentoSessao;
    }

    public Duration getDuracaoSesao() {
        return Duration.between(dataAbertura,  dataEncerramento);
    }

    public boolean isAberta() {
        return dataAbertura.isBefore(dataEncerramento);
    }

    public void abrir(SessaoRepositorio sessaoRepositorio) {
        sessaoRepositorio.abrirSessao(this);
    }
}
