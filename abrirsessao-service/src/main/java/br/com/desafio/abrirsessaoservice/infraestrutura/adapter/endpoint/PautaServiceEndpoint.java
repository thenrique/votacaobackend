package br.com.desafio.abrirsessaoservice.infraestrutura.adapter.endpoint;

import br.com.desafio.abrirsessaoservice.dominio.PautaService;
import br.com.desafio.abrirsessaoservice.dominio.dto.PautaDto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.circuitbreaker.CircuitBreaker;
import org.springframework.cloud.client.circuitbreaker.CircuitBreakerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.HashSet;
import java.util.Set;

@Component
public class PautaServiceEndpoint implements PautaService {


    private RestTemplate  restTemplate; ;

    @Autowired
    private CircuitBreakerFactory circuitBreakerFactory;

    private Set<PautaDto> pautasCache = new HashSet();

    private PautaServiceEndpoint instance;


    @Override
    public PautaDto buscarPauta(String identificador) {
        CircuitBreaker circuitbreak = circuitBreakerFactory.create("pautaServiceCircuitBreaker");
        PautaDto pautaCache = getPautasEmCache(identificador);
        if(pautaCache!=null)
            return pautaCache;

        String url = "http://localhost:8082/v1/api/pauta/get/" + identificador;
        PautaDto pautaDto = circuitbreak.run(() -> restTemplate.getForObject(url, PautaDto.class));
        pautasCache.add(pautaDto);
        return pautaDto;
    }

    private PautaDto getPautasEmCache(String identificador) {
        if(instance==null){
            instance = new PautaServiceEndpoint();
            restTemplate = new RestTemplate();
            return null;
        }
        return instance.pautasCache.stream().filter(pautaDto -> pautaDto.identificador().equalsIgnoreCase(identificador)).findFirst().get();
    }
}
