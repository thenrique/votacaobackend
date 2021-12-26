package br.com.desafio.exibirresultadoservice.casodeuso.dto;


public record ResultadoDto(String identificadorPauta, Long total, Long totalSim, Long totalNao, boolean encerrada) {

}
