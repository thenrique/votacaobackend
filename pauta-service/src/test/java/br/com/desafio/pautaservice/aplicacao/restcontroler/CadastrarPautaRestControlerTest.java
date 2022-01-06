package br.com.desafio.pautaservice.aplicacao.restcontroler;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.net.URI;

import static org.junit.jupiter.api.Assertions.*;

@ActiveProfiles("test")
@AutoConfigureMockMvc
@SpringBootTest
class CadastrarPautaRestControlerTest {


    @Autowired
    private MockMvc mockMvc;

    private String json="{\"identificador\":\"12345\",\"nome\":\"Pauta de Teste4 zdfsf\"}";

    @Test
    void deveriaConsultarPautaExistente() throws Exception {

        mockMvc.perform(MockMvcRequestBuilders.post("/v1/api/pauta/cadastrar/")
                .content(json)
                .contentType(MediaType.APPLICATION_JSON)).andExpect(MockMvcResultMatchers.status().isOk());

    }

    @Test
    void deveriaLancarErroPautaJaExistente() throws Exception {

        mockMvc.perform(MockMvcRequestBuilders.post("/v1/api/pauta/cadastrar/")
                        .content(json).contentType(MediaType.APPLICATION_JSON));

        mockMvc.perform(MockMvcRequestBuilders.post("/v1/api/pauta/cadastrar/")
                .content(json)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("erro").value("Pauta já existente com o identificador informado: 12345"));

    }
}