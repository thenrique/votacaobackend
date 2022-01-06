package br.com.desafio.pautaservice.infraestrutura.postgres.repositorio;

import br.com.desafio.pautaservice.infraestrutura.postgres.entidades.PautaEntity;
import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.ActiveProfiles;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@ActiveProfiles("test")
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class PautaRepositorioITest {

    @Autowired
    private PautaRepositorioI pautaRepositorioI;

    @Autowired
    private TestEntityManager testEntityManager;


    @Test
    void deveriaBuscarPautaPorIdentificadorPauta() {
        String identificador = "123499";
        PautaEntity pautaEntity = new PautaEntity(identificador,"Tteste");
        testEntityManager.persist(pautaEntity);

        Optional<PautaEntity> pautaOptional = pautaRepositorioI.findByIdentificador(identificador);

        assertNotNull(pautaOptional);
        assertEquals(pautaOptional.get().getIdentificador(), identificador);

    }

    @Test
    void deveriaRetornarVazioQuandoPautaNaoExistir() {
        String identificador = "Teste123";
        Optional<PautaEntity> pautaOptional = pautaRepositorioI.findByIdentificador(identificador);
        assertEquals(Optional.empty(), pautaOptional);
    }
}