package br.com.desafio.contabilizacaoservice.infraestrutura.messageria.consumer;


import br.com.desafio.contabilizacaoservice.dominio.casodeuso.ContabilizarResultadoVotacao;

import br.com.desafio.contabilizacaoservice.dominio.casodeuso.VotoDto;
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

    @KafkaListener(topics = "votoacomputar", groupId = "group_json", containerFactory = "votoKafkaListenerFactory")
    public void consume(VotoDto votoDto)
    {
        System.out.println(votoDto);
        //contabilizarResultadoVotacao.execute(votoDto);
    }
}
