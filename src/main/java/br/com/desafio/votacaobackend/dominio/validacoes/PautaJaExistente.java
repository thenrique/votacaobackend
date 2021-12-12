package br.com.desafio.votacaobackend.dominio.validacoes;

public class PautaJaExistente extends RuntimeException {


    public PautaJaExistente(String identificador) {
        super("Pauta já existente com o identificador informado: "+ identificador);
    }
}
