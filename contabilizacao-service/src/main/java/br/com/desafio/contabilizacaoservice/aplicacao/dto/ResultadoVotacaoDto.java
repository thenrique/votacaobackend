package br.com.desafio.contabilizacaoservice.aplicacao.dto;

import br.com.desafio.contabilizacaoservice.dominio.casodeuso.ResultadoVotacao;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class ResultadoVotacaoDto {

    private String identificadorPauta;
    private Long totalVotos;
    private Long votosSim;
    private Long votosNao;

    public ResultadoVotacaoDto(String identificadorPauta, Long totalVotos, Long votosSim, Long votosNao) {
        this.identificadorPauta = identificadorPauta;
        this.totalVotos = totalVotos;
        this.votosSim = votosSim;
        this.votosNao = votosNao;
    }

    public ResultadoVotacaoDto(ResultadoVotacao resultadoVotacao) {
        this.identificadorPauta=resultadoVotacao.getIdenficadorPauta();
        this.votosSim =  resultadoVotacao.getTodosSim();
        this.votosNao = resultadoVotacao.getTodosNao();
        this.totalVotos = resultadoVotacao.getTotalVotos();
    }
}
