package br.com.desafio.abrirsessaoservice.aplicacao.restcontroler;

import br.com.desafio.abrirsessaoservice.aplicacao.dto.SessaoDetalhadaDto;
import br.com.desafio.abrirsessaoservice.aplicacao.dto.SessaoDetalhadaErroDto;
import br.com.desafio.abrirsessaoservice.dominio.Sessao;
import br.com.desafio.abrirsessaoservice.dominio.casodeuso.AbrirSessaoVotacao;
import br.com.desafio.abrirsessaoservice.dominio.casodeuso.ConsultarSessaoVotacao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@RestController
@RequestMapping("/v1/api/sessaoPauta/")
public class ConsultarSessaoPautaRestControler {

    private static final Logger LOGGER = LoggerFactory.getLogger(ConsultarSessaoPautaRestControler.class);
    private final ConsultarSessaoVotacao consultarSessaoVotacao;

    @Autowired
    public ConsultarSessaoPautaRestControler(ConsultarSessaoVotacao consultarSessaoVotacao) {
        this.consultarSessaoVotacao = consultarSessaoVotacao;
    }


    @GetMapping("/get/{identificadorPauta}")
    public ResponseEntity buscar(@PathVariable @NotEmpty @NotNull String identificadorPauta){
        try {
            LOGGER.info("Consultando sessoes");
            Sessao sessaoDto = consultarSessaoVotacao.buscarSessao(identificadorPauta);
            return ResponseEntity.ok(new SessaoDetalhadaDto(sessaoDto.getIdentificadorPauta(),sessaoDto.getDataAbertura(),sessaoDto.getDataEncerramento()));

        }catch (Exception e){
            LOGGER.error(e.getMessage());
            return ResponseEntity.ok(new SessaoDetalhadaErroDto(false, e.getMessage()));
        }
    }

}
