package br.com.desafio.abrirsessaoservice.dominio.validacoes;

public class PautaDeIdentificadorInexistente extends  RuntimeException{
    public PautaDeIdentificadorInexistente() {
        super("Pauta inexistente com o identificador informado" );
    }
}
