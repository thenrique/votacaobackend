package br.com.desafio.abrirsessaoservice.aplicacao.restcontroler;

import br.com.desafio.abrirsessaoservice.aplicacao.dto.SessaoDetalhadaErroDto;
import br.com.desafio.abrirsessaoservice.aplicacao.dto.SessaoDto;
import br.com.desafio.abrirsessaoservice.dominio.casodeuso.AbrirSessaoVotacao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/v1/api/sessaoPauta/")
public class AbrirSessaoPautaRestControler {

    private static final Logger LOGGER = LoggerFactory.getLogger(AbrirSessaoPautaRestControler.class);
    private final AbrirSessaoVotacao abrirSessaoVotacao;

    @Autowired
    public AbrirSessaoPautaRestControler(AbrirSessaoVotacao abrirSessaoVotacao) {
        this.abrirSessaoVotacao = abrirSessaoVotacao;
    }

    @PostMapping(value = "abrirSessao", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity abrirSessao(@RequestBody @Valid SessaoDto sessaoDto){
        try {
            abrirSessaoVotacao.execute(sessaoDto.getIdentificadorPauta(),sessaoDto.getDuracao());
            return ResponseEntity.ok().build();
        }catch (Exception e){
            LOGGER.error(e.getMessage());
            return ResponseEntity.ok(new SessaoDetalhadaErroDto(false, e.getMessage()));
        }

    }
}
