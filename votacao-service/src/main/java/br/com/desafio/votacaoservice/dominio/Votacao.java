package br.com.desafio.votacaoservice.dominio;

import lombok.Getter;

import java.util.Optional;

@Getter
public class Votacao {

    private Associado associado;
    private boolean voto;
    private String identificadorPauta;

    public Votacao(String cpfAssociado, boolean voto, String identificadorPauta) {
        this.associado = new Associado(cpfAssociado);
        this.voto = voto;
        this.identificadorPauta = identificadorPauta;
    }

    public void votar(Votacao votacao, VotacaoRepositorio votacaoRepositorio) {
        votacaoRepositorio.votar(votacao);
    }

    public boolean isAssociadoJaVotou(String cpfAssociado, String identificadorPauta, VotacaoRepositorio votacaoRepositorio) {
        Optional<Votacao> votacaoOptional = votacaoRepositorio.buscarVoto(identificadorPauta, cpfAssociado);
        return votacaoOptional.isPresent();
    }

    @Override
    public String toString() {
        return "Votacao{" +
                "associado=" + associado +
                ", voto=" + voto +
                ", identificadorPauta='" + identificadorPauta + '\'' +
                '}';
    }
}
