package br.com.desafio.exibirresultadoservice.infraestrutura.mensageria.consumer;

import br.com.desafio.exibirresultadoservice.casodeuso.ResultadoVotacao;
import br.com.desafio.exibirresultadoservice.casodeuso.dto.ResultadoDto;
import br.com.desafio.votacaoservice.dominio.RegistrarResultadoVotacao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class ResultadoVotacaoConsumer {

    private static final Logger logger = LoggerFactory.getLogger(ResultadoVotacaoConsumer.class);

    private RegistrarResultadoVotacao registrarResultadoVotacao;

    @Autowired
    public ResultadoVotacaoConsumer(RegistrarResultadoVotacao registrarResultadoVotacao) {
        this.registrarResultadoVotacao = registrarResultadoVotacao;
    }

    @KafkaListener(topics = "resultado", groupId = "group_exibirresultado", containerFactory = "resultadoKafkaListenerFactory")
    public void consumir(ResultadoDto resultadoDto){
        logger.info("Construindo");

        ResultadoVotacao resultadoVotacao =
                ResultadoVotacao.builder().totalVotos(resultadoDto.total()).idenficadorPauta(resultadoDto.identificadorPauta()
        ).todosNao( resultadoDto.totalNao()
        ).votacaoEncerrada(resultadoDto.encerrada()).todosSim(resultadoDto.totalSim()).build();
        registrarResultadoVotacao.execute(resultadoVotacao);
    }


}
