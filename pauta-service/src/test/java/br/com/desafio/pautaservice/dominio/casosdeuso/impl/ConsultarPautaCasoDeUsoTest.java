package br.com.desafio.pautaservice.dominio.casosdeuso.impl;

import br.com.desafio.pautaservice.dominio.casosdeuso.Pauta;
import br.com.desafio.pautaservice.dominio.casosdeuso.validacoes.PautaInexistente;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.web.bind.annotation.ExceptionHandler;

import static org.junit.jupiter.api.Assertions.*;

@ActiveProfiles("test")
@SpringBootTest
class ConsultarPautaCasoDeUsoTest {

    @Autowired
    private ConsultarPautaCasoDeUso consultarPautaCasoDeUso;

    @Autowired
    private CadastrarPautaCasoDeUso cadastrarPautaCasoDeUso;




    @Test
    void deveConsultarPautaExistente() {

        String identificador="12345";
        String nome="pauta";
        try {
            cadastrarPautaCasoDeUso.execute(identificador, nome);
        }catch(Exception e){

        }

        Pauta pauta = consultarPautaCasoDeUso.execute(identificador);
        assertNotNull(pauta);
        assertEquals(identificador, pauta.getIdentificador());
    }


    @Test
    void deveLancarMensagemErroPautaInexistente() {

        String identificador="12345";
        try {
            Pauta pauta = consultarPautaCasoDeUso.execute(identificador);
        }catch (PautaInexistente p){
            assertEquals("A pauta de identificador "+identificador +" não existe", p.getMessage());
        }


    }
}