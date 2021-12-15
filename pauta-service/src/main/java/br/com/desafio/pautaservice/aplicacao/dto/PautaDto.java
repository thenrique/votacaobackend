package br.com.desafio.pautaservice.aplicacao.dto;


import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public class PautaDto {

    private String identificador;
    private String nome;



    public PautaDto(String identificador, String nome) {
        this.identificador = identificador;
        this.nome = nome;
    }
}
