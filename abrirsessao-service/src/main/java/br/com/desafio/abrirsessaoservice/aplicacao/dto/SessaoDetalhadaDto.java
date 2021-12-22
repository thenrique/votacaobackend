package br.com.desafio.abrirsessaoservice.aplicacao.dto;

import java.time.LocalDateTime;

public record SessaoDetalhadaDto (String identificadorPauta, LocalDateTime dataAbertura, LocalDateTime dataEncerramento) {
}
