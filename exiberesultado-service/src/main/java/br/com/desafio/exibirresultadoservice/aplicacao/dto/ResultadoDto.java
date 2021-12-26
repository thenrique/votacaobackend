package br.com.desafio.exibirresultadoservice.aplicacao.dto;

import br.com.desafio.exibirresultadoservice.casodeuso.ResultadoVotacao;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ResultadoDto {

    private String identificadorPauta;
    private Long totalVotos;
    private Long votosSim;
    private Long votosNao;
    private boolean votacaoEncerrada;
    private LocalDateTime dataInicio;
    private LocalDateTime dataEncerramentodo;


    public ResultadoDto(String identificadorPauta, Long totalVotos, Long votosSim, Long votosNao) {
        this.identificadorPauta = identificadorPauta;
        this.totalVotos = totalVotos;
        this.votosSim = votosSim;
        this.votosNao = votosNao;
    }

    public ResultadoDto(ResultadoVotacao resultadoVotacao) {
        this.identificadorPauta=resultadoVotacao.getIdenficadorPauta();
        this.votosSim =  resultadoVotacao.getTodosSim();
        this.votosNao = resultadoVotacao.getTodosNao();
        this.totalVotos = resultadoVotacao.getTotalVotos();
    }
}
