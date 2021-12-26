package br.com.desafio.contabilizacaoservice.dominio.casodeuso;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Builder
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ResultadoDto {
    private String identificadorPauta;
    private Long total;
    private Long totalSim;
    private Long totalNao;
    boolean encerrada;

    public void defineVotacaoEncerrou(LocalDateTime dataInicio, LocalDateTime dataEncerramento){
        this.encerrada = dataEncerramento.isBefore(dataInicio);
    }


}
