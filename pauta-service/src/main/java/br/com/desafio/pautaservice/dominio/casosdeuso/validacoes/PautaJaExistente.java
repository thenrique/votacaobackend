package br.com.desafio.pautaservice.dominio.casosdeuso.validacoes;

public class PautaJaExistente extends RuntimeException {


    public PautaJaExistente(String identificador) {
        super("Pauta já existente com o identificador informado: "+ identificador);
    }
}
