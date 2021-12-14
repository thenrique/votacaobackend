package br.com.desafio.contabilizacaoservice.dominio.casodeuso;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class ResultadoVotacao {

    private String idenficadorPauta;
    private Long totalVotos;
    private Long todosSim;
    private Long todosNao;

}