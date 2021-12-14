package br.com.desafio.votacaobackend.infraestrutura.memoria.postgres;

import br.com.desafio.votacaobackend.dominio.Pauta;
import lombok.Data;


import java.io.Serializable;
import java.time.LocalDateTime;

public class PautaEntidade implements Serializable {

      private Long id;

     private String identificador;
    private String nome;
    private LocalDateTime aberturaSessao;
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
