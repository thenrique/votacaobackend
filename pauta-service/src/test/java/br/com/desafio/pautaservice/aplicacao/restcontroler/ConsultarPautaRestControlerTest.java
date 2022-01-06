package br.com.desafio.pautaservice.aplicacao.restcontroler;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.net.URI;

import static org.junit.jupiter.api.Assertions.*;
@ActiveProfiles("test")
@AutoConfigureMockMvc
@SpringBootTest
class ConsultarPautaRestControlerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void deveriaConsultarPautaExistente() throws Exception {
        String identificador="1234";

        URI uri = new URI("/v1/api/pauta/get/"+identificador);

        mockMvc.perform(MockMvcRequestBuilders.post("/v1/api/pauta/cadastrar/")
                .content("{\"identificador\":\"1234\",\"nome\":\"Pauta de Teste4 zdfsf\"}")
                .contentType(MediaType.APPLICATION_JSON)).andExpect(MockMvcResultMatchers.status().isOk());

        mockMvc.perform(MockMvcRequestBuilders.get(uri).contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("identificador").value(identificador))
                .andExpect(MockMvcResultMatchers.jsonPath("sucesso").value(true));
    }



    @Test
    void deveLancarQueNaoExistePautaComIdentificadorInformado() throws Exception {
        String identificador="12349";

        URI uri = new URI("/v1/api/pauta/get/"+identificador);

        mockMvc.perform(MockMvcRequestBuilders.get(uri).contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk()).andExpect(MockMvcResultMatchers.jsonPath("erro").value("A pauta de identificador "+identificador +" não existe"));

    }
}