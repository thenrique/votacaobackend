package br.com.desafio.exibirresultadoservice.infraestrutura.mensageria.consumer;

import br.com.desafio.exibirresultadoservice.casodeuso.ResultadoVotacao;
import br.com.desafio.exibirresultadoservice.casodeuso.dto.ResultadoVotacaoDto;
import br.com.desafio.votacaoservice.dominio.RegistrarResultadoVotacao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class ResultadoVotacaoConsumer {

    private static final Logger logger = LoggerFactory.getLogger(ResultadoVotacaoConsumer.class);

    private RegistrarResultadoVotacao registrarResultadoVotacao;


    @KafkaListener(topics = "resultadovotacao", groupId = "group_resultado", containerFactory = "resultadoKafkaListenerFactory")
    public void consumir(ResultadoVotacaoDto resultadoVotacaoDto){
        logger.info("Construindo");

        ResultadoVotacao resultadoVotacao =
                ResultadoVotacao.builder().totalVotos(resultadoVotacaoDto.total()).idenficadorPauta(resultadoVotacaoDto.identificadorPauta()
        ).todosNao( resultadoVotacaoDto.totalNao()
        ).votacaoEncerrada(resultadoVotacaoDto.encerrada()).todosSim(resultadoVotacaoDto.totalSim()).build();
        registrarResultadoVotacao.execute(resultadoVotacao);
    }


}
