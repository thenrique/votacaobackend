package br.com.desafio.votacaoservice.infraestrutura.adapter.endpoint.heroku;

import br.com.desafio.votacaoservice.dominio.ValidacaoCpf;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.cloud.client.circuitbreaker.CircuitBreaker;
import org.springframework.cloud.client.circuitbreaker.CircuitBreakerFactory;
import org.springframework.web.client.RestTemplate;

import static org.junit.jupiter.api.Assertions.*;

class ValidacaoCPFHerokuTest {

    private CircuitBreakerFactory circuitBreakerFactory = Mockito.mock(CircuitBreakerFactory.class);
    private CircuitBreaker circuitbreak = Mockito.mock(CircuitBreaker.class);
    private RestTemplate restTemplate = Mockito.mock(RestTemplate.class);


    void devePermitirCPFParaVotar() {
        ValidacaoCpf validacaoCPFHeroku = new ValidacaoCPFHeroku(circuitBreakerFactory);
        String cpf = "96607625002";

        String retornoapi = new String("ABLE_TO_VOTE");
        Mockito.when(circuitBreakerFactory.create("validacaoCPFCircuitBreaker")).thenReturn(circuitbreak );

        Mockito.when(circuitbreak.run(()->{
            Mockito.when(restTemplate.getForObject("https://user-info.herokuapp.com/users/"+cpf, String.class)).thenReturn(retornoapi);
            return retornoapi;
        } )).thenReturn(retornoapi);
        boolean retorno = validacaoCPFHeroku.isPermitidoVotar(cpf);
        assertEquals(retorno, true);

    }
}