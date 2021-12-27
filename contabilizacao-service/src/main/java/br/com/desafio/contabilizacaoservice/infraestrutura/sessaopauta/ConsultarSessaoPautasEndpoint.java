package br.com.desafio.contabilizacaoservice.infraestrutura.sessaopauta;

import br.com.desafio.contabilizacaoservice.dominio.ConsultarSessaoPautas;
import br.com.desafio.contabilizacaoservice.dominio.casodeuso.dto.PautaDto;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class ConsultarSessaoPautasEndpoint implements ConsultarSessaoPautas {

    private RestTemplate restTemplate= new RestTemplate();


    @Override
    public PautaDto consultar(String identificadorPauta) {
        PautaDto pautaDto = restTemplate.getForObject("http://abrirsessao:8084/v1/api/sessaoPauta/get/"+identificadorPauta,PautaDto.class);
        return pautaDto;
    }
}
