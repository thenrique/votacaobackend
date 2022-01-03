package br.com.desafio.pautaservice.aplicacao.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
@AllArgsConstructor
public class ResponsePautaDto {

    private String identificador;
    private String nome;
    private boolean sucesso;
    private String erro;



    public ResponsePautaDto(String identificador, String nome, boolean sucesso) {
        this.identificador = identificador;
        this.nome = nome;
        this.sucesso = sucesso;
    }

    public ResponsePautaDto(boolean sucesso, String message) {
        this.sucesso = sucesso;
        this.erro = message;
    }
}
