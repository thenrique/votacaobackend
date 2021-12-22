package br.com.desafio.contabilizacaoservice.infraestrutura.postgres.entidade;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "resultadoVotacao")
public class ResultadoVotacaoEntity {

    @Id
    @SequenceGenerator( name="seq_id_resultado", sequenceName ="seq_id_resultado")
    @GeneratedValue( strategy = GenerationType.SEQUENCE, generator ="seq_id_resultado" )
    private Long id;

    private String idenficadorPauta;
    private Long totalVotos;
    private Long todosSim;
    private Long todosNao;
}
