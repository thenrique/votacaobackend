package br.com.desafio.votacaoservice.infraestrutura.adapter.endpoint.heroku;

import br.com.desafio.votacaoservice.dominio.ValidacaoCpf;
import br.com.desafio.votacaoservice.infraestrutura.adapter.endpoint.heroku.erro.ServicoIndisponivel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.circuitbreaker.CircuitBreaker;
import org.springframework.cloud.client.circuitbreaker.CircuitBreakerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class ValidacaoCPFHeroku implements ValidacaoCpf {

    private final static String  ENDERECO="https://user-info.herokuapp.com/users/";
    private final RestTemplate  restTemplate = new RestTemplate();


    private CircuitBreakerFactory circuitBreakerFactory;

    @Autowired
    public ValidacaoCPFHeroku(CircuitBreakerFactory circuitBreakerFactory) {
        this.circuitBreakerFactory = circuitBreakerFactory;
    }

    @Override
    public boolean isPermitidoVotar(String cpf) throws RuntimeException {
        try {
            CircuitBreaker circuitbreak = circuitBreakerFactory.create("validacaoCPFCircuitBreaker");
            String retorno = circuitbreak.run(() -> restTemplate.getForObject(ENDERECO+cpf
                    , String.class));
            return retorno.equalsIgnoreCase("ABLE_TO_VOTE");
        }catch(Exception e){
            throw new ServicoIndisponivel("Heroku");
        }

    }
}
