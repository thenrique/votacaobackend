package br.com.desafio.exibirresultadoservice.casodeuso.dto;


public record ResultadoVotacaoDto(String identificadorPauta, Long total, Long totalSim, Long totalNao, boolean encerrada) {

}
