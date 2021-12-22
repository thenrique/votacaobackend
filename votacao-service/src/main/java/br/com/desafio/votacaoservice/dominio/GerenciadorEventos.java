package br.com.desafio.votacaoservice.dominio;

import br.com.desafio.votacaoservice.dominio.event.AcoesEventos;
import br.com.desafio.votacaoservice.dominio.event.NotificacaoVotoComputadoEvento;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

import java.util.List;

@Component
public class GerenciadorEventos {

    private final NotificarVotoComputado notificarVotoComputado;
    private List<AcoesEventos> eventos = new ArrayList();

    @Autowired
    public GerenciadorEventos(NotificarVotoComputado notificarVotoComputado) {
        this.notificarVotoComputado = notificarVotoComputado;
    }

    public List<AcoesEventos> eventosPosCadastrar(){
        eventos.add( new NotificacaoVotoComputadoEvento(notificarVotoComputado));
        return eventos;
    }


    public void executarPosCadastrado(Votacao votacao) {
        eventosPosCadastrar().forEach(e ->e.execute(votacao));
    }
}
