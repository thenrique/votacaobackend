package br.com.desafio.pautaservice.dominio.casosdeuso.validacoes;

public class PautaInexistente extends RuntimeException {
    public PautaInexistente(String identificador) {
        super("A pauta de identificador "+identificador +" não existe");
    }
}
