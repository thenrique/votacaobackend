package br.com.desafio.contabilizacaoservice.dominio.casodeuso.dto;

import java.time.LocalDateTime;

public record PautaDto(String identificacaoPauta, LocalDateTime dataAbertura, LocalDateTime dataEncerramento) {
}
