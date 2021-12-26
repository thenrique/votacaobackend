package br.com.desafio.contabilizacaoservice.infraestrutura.messageria.producer;

import br.com.desafio.contabilizacaoservice.dominio.casodeuso.NotificacaoVotacaoEncerrada;
import br.com.desafio.contabilizacaoservice.dominio.casodeuso.ResultadoDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;


@Service
public class NotificacaoVotacaoEncerradaKafka implements NotificacaoVotacaoEncerrada {
    private static final Logger logger = LoggerFactory.getLogger(NotificacaoVotacaoEncerradaKafka.class);
    private String topic;
    private  KafkaTemplate<String, ResultadoDto> kafkaTemplate;

    public NotificacaoVotacaoEncerradaKafka(@Value("${topic.name}") String topic, KafkaTemplate<String, ResultadoDto> kafkaTemplate ) {
        this.topic = topic;
        this.kafkaTemplate = kafkaTemplate;
    }

    @Override
    public void executar(ResultadoDto resultadoDto) {
        kafkaTemplate.send(topic,resultadoDto).
                addCallback(
                        sucess-> logger.info("Mensagem Enviada" + resultadoDto.getIdentificadorPauta()),
                        fail -> logger.info("Deu erro" + fail.getMessage()));
    }
}
