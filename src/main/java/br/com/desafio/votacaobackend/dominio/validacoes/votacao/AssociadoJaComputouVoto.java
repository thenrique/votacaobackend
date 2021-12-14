package br.com.desafio.votacaobackend.dominio.validacoes.votacao;


public class AssociadoJaComputouVoto extends RuntimeException {
    public AssociadoJaComputouVoto(String identificadorAssociado, String identificadorPauta ) {
        super(" O associado de identificador " + identificadorAssociado + " já votou na pauta de número " + identificadorPauta);
    }
}
