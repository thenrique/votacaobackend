package br.com.desafio.votacaobackend.aplicacao.dto;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class ResultadoVotacaoDto {

    private String identificadorPauta;
    private Long totalVotos;
    private Opcao vencedor;
    private Opcao perdedor;


}
