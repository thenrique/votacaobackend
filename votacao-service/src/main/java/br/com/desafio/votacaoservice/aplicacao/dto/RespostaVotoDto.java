package br.com.desafio.votacaoservice.aplicacao.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class RespostaVotoDto {
    private boolean sucesso;
    private String mensagem;

    public RespostaVotoDto(boolean sucesso) {
        this.sucesso= true;
    }
}
