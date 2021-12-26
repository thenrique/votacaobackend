package br.com.desafio.contabilizacaoservice.infraestrutura.messageria.consumer;


import br.com.desafio.contabilizacaoservice.dominio.casodeuso.dto.VotoDto;
import br.com.desafio.contabilizacaoservice.dominio.casodeuso.ContabilizarResultadoVotacao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class NotificacaoVotoComputadoConsumer {

    private ContabilizarResultadoVotacao contabilizarResultadoVotacao;

    @Autowired
    public NotificacaoVotoComputadoConsumer(ContabilizarResultadoVotacao contabilizarResultadoVotacao) {
        this.contabilizarResultadoVotacao = contabilizarResultadoVotacao;
    }

    @KafkaListener(topics = "votonotificar", groupId = "group_voto", containerFactory = "votoKafkaListenerFactory")
    public void consume(VotoDto votoDto)
    {
        System.out.println("Consumindo"+votoDto);
        contabilizarResultadoVotacao.execute(votoDto);
    }
}
