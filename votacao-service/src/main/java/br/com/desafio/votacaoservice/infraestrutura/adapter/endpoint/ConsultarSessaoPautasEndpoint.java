package br.com.desafio.votacaoservice.infraestrutura.adapter.endpoint;

import br.com.desafio.votacaoservice.dominio.ConsultarSessaoPautas;
import br.com.desafio.votacaoservice.dominio.dto.PautaSessaoDto;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class ConsultarSessaoPautasEndpoint implements ConsultarSessaoPautas {

    private RestTemplate restTemplate= new RestTemplate();


    @Override
    public PautaSessaoDto consultar(String identificadorPauta) {
        PautaSessaoDto pautaSessaoDto = restTemplate.getForObject("http://localhost:8084/v1/api/sessaoPauta/get/"+identificadorPauta,PautaSessaoDto.class);
        return pautaSessaoDto;
    }
}
