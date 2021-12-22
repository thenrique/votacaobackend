package br.com.desafio.votacaoservice.infraestrutura.postgres.entidades;

import br.com.desafio.votacaoservice.dominio.Associado;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "votacao")
public class VotacaoEntity {

    @Id
    @SequenceGenerator( name="seq_id_votacao", sequenceName ="seq_id_votacao")
    @GeneratedValue( strategy = GenerationType.SEQUENCE, generator ="seq_id_votacao" )
    private Long id;
    private String identificadorAssociado;
    private boolean voto;
    private String identificadorPauta;

    public VotacaoEntity(String identificadorAssociado, boolean voto, String identificadorPauta) {
        this.identificadorAssociado = identificadorAssociado;
        this.voto = voto;
        this.identificadorPauta = identificadorPauta;
    }
}
