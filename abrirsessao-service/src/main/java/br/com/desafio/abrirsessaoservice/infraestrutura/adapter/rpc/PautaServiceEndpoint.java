package br.com.desafio.abrirsessaoservice.infraestrutura.adapter.rpc;

import br.com.desafio.abrirsessaoservice.dominio.PautaService;
import br.com.desafio.abrirsessaoservice.dominio.dto.PautaDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.client.RestTemplate;

public class PautaServiceEndpoint implements PautaService {


    private RestTemplate restTemplate;

    @Autowired
    public PautaServiceEndpoint(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public PautaDto buscarPauta(String identificador) {

        PautaDto pautaDto = restTemplate.getForObject("http://localhost:8082/v1/api/pauta/get/" + identificador, PautaDto.class);

        return pautaDto;
    }
}
