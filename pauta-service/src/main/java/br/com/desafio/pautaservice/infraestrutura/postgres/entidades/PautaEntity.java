package br.com.desafio.pautaservice.infraestrutura.postgres.entidades;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "pauta")
public class PautaEntity {

    @Id
    @SequenceGenerator( name="seq_id_pauta", sequenceName ="seq_id_pauta")
    @GeneratedValue( strategy = GenerationType.SEQUENCE, generator ="seq_id_pauta" )
    private Long id;
    private String identificador;
    private String nome;

    public PautaEntity(String identificador, String nome) {
        this.identificador = identificador;
        this.nome = nome;
    }
}
