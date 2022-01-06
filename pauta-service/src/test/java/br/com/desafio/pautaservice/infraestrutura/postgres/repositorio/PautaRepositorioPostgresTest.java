package br.com.desafio.pautaservice.infraestrutura.postgres.repositorio;

import br.com.desafio.pautaservice.dominio.casosdeuso.Pauta;
import br.com.desafio.pautaservice.dominio.casosdeuso.PautaRepositorio;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@ActiveProfiles("test")
@SpringBootTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class PautaRepositorioPostgresTest {

    @Autowired
    private PautaRepositorio pautaRepositorio;


    @Test
    void deveriaCadastrarPauta() {
        String identificadorPauta="Teste1";
        Pauta pauta = new Pauta(identificadorPauta,"teste");
        pautaRepositorio.cadastrarPauta(pauta);
        Optional<Pauta> pautaOptional = pautaRepositorio.buscarPauta(identificadorPauta);
        assertNotNull(pautaOptional);
        assertEquals(identificadorPauta, pautaOptional.get().getIdentificador());
    }

    @Test
    void deveBuscarPautaJaCadastrada() {
        String identificadorPauta="Teste1";
        Optional<Pauta> pautaOptional = pautaRepositorio.buscarPauta(identificadorPauta);
        assertNotNull(pautaOptional);
        assertEquals(identificadorPauta, pautaOptional.get().getIdentificador());
    }

    @Test
    void deveriaNaoEncontrarNadaCasoPautaInexistente() {
        String identificadorPauta="Teste12222";
        Optional<Pauta> pautaOptional = pautaRepositorio.buscarPauta(identificadorPauta);
        assertEquals(Optional.empty(), pautaOptional);
    }
}