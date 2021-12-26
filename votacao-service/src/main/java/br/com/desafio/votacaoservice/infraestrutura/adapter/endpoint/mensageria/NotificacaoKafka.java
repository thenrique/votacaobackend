package br.com.desafio.votacaoservice.infraestrutura.adapter.endpoint.mensageria;

import br.com.desafio.votacaoservice.dominio.NotificarVotoComputado;
import br.com.desafio.votacaoservice.dominio.Votacao;
import br.com.desafio.votacaoservice.dominio.dto.VotoDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class NotificacaoKafka implements NotificarVotoComputado {

    private static final Logger logger = LoggerFactory.getLogger(NotificacaoKafka.class);
    private String topic;
    private KafkaTemplate<String, VotoDto> kafkaTemplate;

    public NotificacaoKafka(@Value("${topic.name}") String topic, KafkaTemplate<String, VotoDto> kafkaTemplate ) {
        this.topic = topic;
        this.kafkaTemplate = kafkaTemplate;
    }

    @Override

    public void execute(VotoDto votoDto) {
        kafkaTemplate.send(topic,votoDto).
                addCallback(
                        sucess-> logger.error("Mensagem Enviada" + votoDto),
                        fail -> logger.error("Ocorreu um erro" + fail.getMessage()));
    }
}
