package br.com.desafio.contabilizacaoservice.dominio.casodeuso;

import lombok.Getter;
import lombok.Setter;

@Getter
public class Voto {

    private boolean voto;
    private String identificadorPauta;
    private @Setter  ResultadoVotacao resultadoVotacao;

    public Voto(boolean voto, String identificadorPauta) {
        this.voto = voto;
        this.identificadorPauta = identificadorPauta;
    }

}
