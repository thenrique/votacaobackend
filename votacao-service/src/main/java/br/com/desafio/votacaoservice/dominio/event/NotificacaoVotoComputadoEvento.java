package br.com.desafio.votacaoservice.dominio.event;

import br.com.desafio.votacaoservice.dominio.NotificarVotoComputado;
import br.com.desafio.votacaoservice.dominio.Votacao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class NotificacaoVotoComputadoEvento implements AcoesEventos {

    private NotificarVotoComputado notificarVotoComputado;

    @Autowired
    public NotificacaoVotoComputadoEvento(NotificarVotoComputado notificarVotoComputado) {
        this.notificarVotoComputado = notificarVotoComputado;
    }

    @Override
    public void execute(Votacao votacao) {
        notificarVotoComputado.execute(votacao);
    }
}
