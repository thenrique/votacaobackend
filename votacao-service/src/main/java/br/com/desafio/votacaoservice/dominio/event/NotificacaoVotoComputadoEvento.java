package br.com.desafio.votacaoservice.dominio.event;

import br.com.desafio.votacaoservice.dominio.NotificarVotoComputado;
import br.com.desafio.votacaoservice.dominio.Votacao;
import br.com.desafio.votacaoservice.dominio.dto.VotoDto;
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
        VotoDto votoDto = new VotoDto(votacao.getAssociado().cpf(),votacao.isVoto(),votacao.getIdentificadorPauta());
        notificarVotoComputado.execute(votoDto);
    }
}
