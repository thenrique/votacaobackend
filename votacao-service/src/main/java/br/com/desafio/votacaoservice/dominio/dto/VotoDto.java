package br.com.desafio.votacaoservice.dominio.dto;

import br.com.desafio.votacaoservice.dominio.Associado;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class VotoDto {

    private String associado;
    private boolean voto;
    private String identificadorPauta;
}
