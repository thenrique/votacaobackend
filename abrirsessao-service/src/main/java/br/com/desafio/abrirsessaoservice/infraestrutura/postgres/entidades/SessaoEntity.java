package br.com.desafio.abrirsessaoservice.infraestrutura.postgres.entidades;

import lombok.*;


import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "sessao")
public class SessaoEntity {

    @Id
    @SequenceGenerator( name="seq_id_sessao", sequenceName ="seq_id_sessao")
    @GeneratedValue( strategy = GenerationType.SEQUENCE, generator ="seq_id_sessao" )
    private Long id;
    private String identificadorPauta;
    private LocalDateTime dataAbertura;
    private LocalDateTime dataEncerramento;
    private Long duracao;

}
