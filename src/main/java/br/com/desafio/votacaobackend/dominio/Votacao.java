package br.com.desafio.votacaobackend.dominio;

public class Votacao {

    private Associado associado;
    private boolean voto;
    private Pauta pauta;

    public Votacao(String cpfAssociado, boolean voto, String identificadorPauta) {
        this.associado = new Associado(cpfAssociado);
        this.voto = voto;
        this.pauta = new Pauta(identificadorPauta);
    }

}
