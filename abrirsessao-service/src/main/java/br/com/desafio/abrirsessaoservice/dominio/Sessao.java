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

    public Sessao(Long duracao) {
        this.dataAbertura = LocalDateTime.now();
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
        return LocalDateTime.now().isBefore(dataEncerramento);
    }
}
