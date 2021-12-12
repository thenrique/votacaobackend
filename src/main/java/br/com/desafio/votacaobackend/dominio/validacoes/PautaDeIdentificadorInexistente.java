package br.com.desafio.votacaobackend.dominio.validacoes;

public class PautaDeIdentificadorInexistente extends  RuntimeException{
    public PautaDeIdentificadorInexistente() {
        super("Pauta inexistente com o identificador informado" );
    }
}
