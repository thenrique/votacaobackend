package br.com.desafio.votacaobackend.infraestrutura.memoria.postgres;

import br.com.desafio.votacaobackend.dominio.Pauta;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

import java.time.LocalDateTime;
import java.util.Date;

import static javax.persistence.GenerationType.SEQUENCE;

@Data
public class PautaEntidade {

    @Id
    @GeneratedValue(strategy = SEQUENCE, generator = "seqGen")
    @SequenceGenerator(name = "seqGen", sequenceName = "seq", initialValue = 1)
    private Long id;

    @Column
    private String identificador;
    @Column
    private String nome;
    @Column
    private LocalDateTime aberturaSessao;
    @Column
    private LocalDateTime dataEncerramentoSessao;


    public PautaEntidade(Pauta pauta) {
        this.identificador= pauta.getIdentificador();
        this.nome=pauta.getNome();
        if(pauta.getSessao()!=null){
            this.aberturaSessao = pauta.getSessao().getDataAbertura();
            this.dataEncerramentoSessao = pauta.getSessao().getDataEncerramento();
        }
    }
}
