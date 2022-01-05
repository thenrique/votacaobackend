package br.com.desafio.votacaoservice.infraestrutura.adapter.endpoint.sessaopauta;

import br.com.desafio.votacaoservice.dominio.ConsultarSessaoPautas;
import br.com.desafio.votacaoservice.dominio.dto.PautaSessaoDto;
import br.com.desafio.votacaoservice.infraestrutura.adapter.endpoint.sessaopauta.validacao.ErroIntegracaoPautaService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class ConsultarSessaoPautasEndpoint implements ConsultarSessaoPautas {

    private RestTemplate restTemplate= new RestTemplate();

    private String enderecoapisessao;

    public ConsultarSessaoPautasEndpoint(@Value("${sessao.endereco.endpoint}") String enderecoapisessao){
        this.enderecoapisessao = enderecoapisessao;
    }

    @Override
    public PautaSessaoDto consultar(String identificadorPauta) {
        PautaSessaoDto pautaSessaoDto = restTemplate.getForObject(enderecoapisessao+identificadorPauta,PautaSessaoDto.class);
        if(pautaSessaoDto.message()==null){
            return pautaSessaoDto;
        }
        throw new ErroIntegracaoPautaService(pautaSessaoDto.message());

    }
}
