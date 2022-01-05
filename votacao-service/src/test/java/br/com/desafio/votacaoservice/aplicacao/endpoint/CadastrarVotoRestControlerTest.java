package br.com.desafio.votacaoservice.aplicacao.endpoint;


import br.com.desafio.votacaoservice.VotacaoServiceApplication;
import br.com.desafio.votacaoservice.aplicacao.dto.VotoDto;
import br.com.desafio.votacaoservice.dominio.CadastrarVoto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;

import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@ContextConfiguration(classes= VotacaoServiceApplication.class)
@WebMvcTest(CadastrarVotoRestControler.class)
class CadastrarVotoRestControlerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private CadastrarVoto cadastrarVoto;


    @Test
    void deveCadastrarVoto() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.post("/v1/api/voto/cadastrar").contentType(MediaType.APPLICATION_JSON)
                        .content("{ \"identificadorAssociado\": \"90890933030\", \"voto\": \"true\", \"identificadorPauta\": \"1234\" }")).andDo(print()).andExpect(status().isOk())
                .andExpect(jsonPath("sucesso").value(true))
                .andExpect(jsonPath("mensagem").value("Voto Computado"));
    }

}