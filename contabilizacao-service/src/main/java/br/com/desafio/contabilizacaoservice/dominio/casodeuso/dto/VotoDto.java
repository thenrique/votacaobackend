package br.com.desafio.contabilizacaoservice.dominio.casodeuso.dto;

import br.com.desafio.contabilizacaoservice.dominio.casodeuso.ResultadoVotacao;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
public class VotoDto {

    private boolean voto;
    private String identificadorPauta;
    private String associado;
    private @Setter
    ResultadoVotacao resultadoVotacao;

    public VotoDto(boolean voto, String identificadorPauta) {
        this.voto = voto;
        this.identificadorPauta = identificadorPauta;
    }

    public VotoDto(boolean voto, String identificadorPauta, String associado) {
        this.voto = voto;
        this.identificadorPauta = identificadorPauta;
        this.associado = associado;
    }
}
