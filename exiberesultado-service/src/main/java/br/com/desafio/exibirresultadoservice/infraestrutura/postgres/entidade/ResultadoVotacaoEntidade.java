package br.com.desafio.exibirresultadoservice.infraestrutura.postgres.entidade;


import lombok.*;
import org.springframework.data.annotation.Id;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.SequenceGenerator;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity(name = "resultadoVotacao")
public class ResultadoVotacaoEntidade {


    @Id
    @SequenceGenerator( name="seq_id_resultado", sequenceName ="seq_id_resultado")
    @GeneratedValue( strategy = GenerationType.SEQUENCE, generator ="seq_id_resultado" )
    private Long id;
    private String idenficadorPauta;
    private Long totalVotos;

    private Long todosSim;
    private Long todosNao;
    private boolean votacaoEncerrada;


}
