package br.com.desafio.exibirresultadoservice.aplicacao.validacao;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class ErroValidacao {

    private String campo;
    private String erro;

}
