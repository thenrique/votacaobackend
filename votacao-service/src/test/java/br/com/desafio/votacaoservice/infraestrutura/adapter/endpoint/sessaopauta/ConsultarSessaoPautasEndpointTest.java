package br.com.desafio.votacaoservice.infraestrutura.adapter.endpoint.sessaopauta;

import br.com.desafio.votacaoservice.dominio.dto.PautaSessaoDto;
import br.com.desafio.votacaoservice.infraestrutura.adapter.endpoint.sessaopauta.validacao.ErroIntegracaoPautaService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;


import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
class ConsultarSessaoPautasEndpointTest {

    @Value("${sessao.endereco.endpoint}")
    private String endereco;
    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    void deveConsultarSessaoPauta() {
        ResponseEntity<PautaSessaoDto> retorno = restTemplate.getForEntity(endereco + "/12345", PautaSessaoDto.class);

        assertEquals(HttpStatus.OK, retorno.getStatusCode());
        assertEquals(retorno.getBody().message(), null);

    }

    @ExceptionHandler(ErroIntegracaoPautaService.class)
    @Test
    void naoExisteSessaoPauta() {
        ResponseEntity<PautaSessaoDto> retorno = restTemplate.getForEntity(endereco + "/123459", PautaSessaoDto.class);
        assertEquals(HttpStatus.OK, retorno.getStatusCode());

    }
}