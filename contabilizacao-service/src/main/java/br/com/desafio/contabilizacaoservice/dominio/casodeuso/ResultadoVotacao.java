package br.com.desafio.contabilizacaoservice.dominio.casodeuso;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Builder
@Getter
@AllArgsConstructor

public class ResultadoVotacao {

    private String idenficadorPauta;
    private long totalVotos;
    private long todosSim;
    private long todosNao;

    public ResultadoVotacao(String identificadorPauta) {
        this.idenficadorPauta = identificadorPauta;
    }

    public void incrementaVotoSim() {
        todosSim++;
        totalVotos++;
    }

    public void incrementaVotoNao() {
        todosNao++;
        totalVotos++;
    }
}
