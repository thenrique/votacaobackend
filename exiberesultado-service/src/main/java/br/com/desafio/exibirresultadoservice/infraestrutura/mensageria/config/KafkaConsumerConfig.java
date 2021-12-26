
package br.com.desafio.exibirresultadoservice.infraestrutura.mensageria.config;

import br.com.desafio.exibirresultadoservice.casodeuso.dto.ResultadoDto;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.support.serializer.ErrorHandlingDeserializer;
import org.springframework.kafka.support.serializer.JsonDeserializer;
import org.springframework.kafka.support.serializer.JsonSerializer;

import java.util.HashMap;
import java.util.Map;

@EnableKafka
@Configuration
public class KafkaConsumerConfig {

    @Value(value = "${spring.kafka.bootstrap-servers}")
    private String bootstrapAddress;

    @Bean
    public ConsumerFactory<String, ResultadoDto> resultadoConsumerFactory()
    {

        Map<String, Object> config = new HashMap<>();

        config.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG,bootstrapAddress);
        config.put(ConsumerConfig.GROUP_ID_CONFIG, "group_exibirresultado");
        config.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
        config.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, JsonDeserializer.class);
        config.put(ErrorHandlingDeserializer.KEY_DESERIALIZER_CLASS, StringDeserializer.class);
        config.put(ErrorHandlingDeserializer.VALUE_DESERIALIZER_CLASS, JsonDeserializer.class);


        return new DefaultKafkaConsumerFactory<>(config, new StringDeserializer(),
                new JsonDeserializer<>(
                        ResultadoDto.class));
    }

    @Bean
    public ConcurrentKafkaListenerContainerFactory<String, ResultadoDto> resultadoKafkaListenerFactory()
    {
        ConcurrentKafkaListenerContainerFactory<String, ResultadoDto> factory = new ConcurrentKafkaListenerContainerFactory<>();
        factory.setMissingTopicsFatal(false);
        factory.setConsumerFactory(resultadoConsumerFactory());

        return  factory;
    }
}
