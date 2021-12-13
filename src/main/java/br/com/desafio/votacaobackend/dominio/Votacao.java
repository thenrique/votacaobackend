package br.com.desafio.votacaobackend.dominio;

public class Votacao {

    private Associado associado;
    private boolean voto;
    private Pauta pauta;

    public Votacao(String cpfAssociado, boolean voto, Pauta pauta) {
        this.associado = new Associado(cpfAssociado);
        this.voto = voto;
        this.pauta = pauta;
    }

    public Associado getAssociado() {
        return associado;
    }

    public Pauta getPauta() {
        return pauta;
    }

    public boolean isVoto() {
        return voto;
    }
}
