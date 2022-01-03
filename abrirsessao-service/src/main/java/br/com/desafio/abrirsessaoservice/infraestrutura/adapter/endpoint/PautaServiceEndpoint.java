package br.com.desafio.abrirsessaoservice.infraestrutura.adapter.endpoint;

import br.com.desafio.abrirsessaoservice.dominio.PautaService;
import br.com.desafio.abrirsessaoservice.dominio.dto.PautaDto;

import br.com.desafio.abrirsessaoservice.infraestrutura.adapter.endpoint.validacao.ErroIntegracaoPautaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.circuitbreaker.CircuitBreaker;
import org.springframework.cloud.client.circuitbreaker.CircuitBreakerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Stream;

@Component
public class PautaServiceEndpoint implements PautaService {


    private RestTemplate  restTemplate = new RestTemplate() ;

    private String enderecoPautaService;
    @Autowired
    private CircuitBreakerFactory circuitBreakerFactory;

    private Set<PautaDto> pautasCache = new HashSet();

    public PautaServiceEndpoint(CircuitBreakerFactory circuitBreakerFactory,
                                @Value("${pauta.endereco.endpoint}") String enderecoPautaService) {
        this.circuitBreakerFactory = circuitBreakerFactory;
        this.enderecoPautaService = enderecoPautaService;
    }

    @Override
    public PautaDto buscarPauta(String identificador) {
        var circuitbreak = circuitBreakerFactory.create("pautaServiceCircuitBreaker");
        PautaDto pautaCache = getPautasEmCache(identificador);
        if(pautaCache!=null)
            return pautaCache;

        String url = enderecoPautaService+ identificador;
        var pautaDto = circuitbreak.run(() -> restTemplate.getForObject(url, PautaDto.class));

        if(pautaDto.sucesso()){
            pautasCache.add(pautaDto);
            return pautaDto;
        }
        throw new ErroIntegracaoPautaService(pautaDto.erro());

    }

    private PautaDto getPautasEmCache(String identificador) {
        Optional<PautaDto> optionalPautaDto = pautasCache.stream().filter(pautaDto -> pautaDto.identificador().equalsIgnoreCase(identificador)).findFirst();
        if(optionalPautaDto.isPresent()){
            return optionalPautaDto.get();
        }

        return null;
    }
}
