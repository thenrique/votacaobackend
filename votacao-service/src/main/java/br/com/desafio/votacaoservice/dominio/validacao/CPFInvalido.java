package br.com.desafio.votacaoservice.dominio.validacao;

public class CPFInvalido extends RuntimeException {

    public CPFInvalido(String cpf) {
        super("O CPF informado " + cpf + " é invalido");
    }
}
