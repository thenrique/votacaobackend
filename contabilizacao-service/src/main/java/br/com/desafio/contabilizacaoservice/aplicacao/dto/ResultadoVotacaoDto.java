package br.com.desafio.contabilizacaoservice.aplicacao.dto;

import br.com.desafio.contabilizacaoservice.dominio.casodeuso.ResultadoVotacao;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class ResultadoVotacaoDto {

    private String identificadorPauta;
    private Long totalVotos;
    private Opcao votosSim;
    private Opcao votosNao;

    public ResultadoVotacaoDto(String identificadorPauta, Long totalVotos, Opcao vencedor, Opcao perdedor) {
        this.identificadorPauta = identificadorPauta;
        this.totalVotos = totalVotos;
        this.votosSim = vencedor;
        this.votosNao = perdedor;
    }

    public ResultadoVotacaoDto(ResultadoVotacao resultadoVotacao) {
        this.identificadorPauta=resultadoVotacao.getIdenficadorPauta();
        this.votosSim = new Opcao("SIM", resultadoVotacao.getTodosSim());
        this.votosNao = new Opcao("NÃO", resultadoVotacao.getTodosNao());
        this.totalVotos = resultadoVotacao.getTotalVotos();
    }
}
