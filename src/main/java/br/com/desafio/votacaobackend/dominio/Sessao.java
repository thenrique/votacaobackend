package br.com.desafio.votacaobackend.dominio;

import java.time.Duration;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.temporal.TemporalUnit;

public class Sessao {

    private static final long DURACAO_PADRAO =1 ;
    private LocalDateTime dataAbertura;

    private Duration duracaoEmMinutos;

    public Sessao(Long duracao) {
        this.dataAbertura = LocalDateTime.now();
        if(duracao==null) {
            duracao=DURACAO_PADRAO;
        }
        this.duracaoEmMinutos = Duration.ofMinutes(duracao);
    }

    public Duration getDuracaoSesao() {
        return Duration.between(dataAbertura,  dataAbertura.plusMinutes(duracaoEmMinutos.toMinutes()));
    }
}
