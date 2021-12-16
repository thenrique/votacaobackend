package br.com.desafio.abrirsessaoservice.aplicacao.restcontroler;

import br.com.desafio.abrirsessaoservice.aplicacao.dto.SessaoDto;
import br.com.desafio.abrirsessaoservice.dominio.casodeuso.AbrirSessaoVotacao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/api/sessaoPauta/")
public class AbrirSessaoPautaRestControler {

    private final AbrirSessaoVotacao abrirSessaoVotacao;

    @Autowired
    public AbrirSessaoPautaRestControler(AbrirSessaoVotacao abrirSessaoVotacao) {
        this.abrirSessaoVotacao = abrirSessaoVotacao;
    }

    @PostMapping(value = "abrirSessao", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<SessaoDto> abrirSessao(@RequestBody SessaoDto sessaoDto){
        abrirSessaoVotacao.execute(sessaoDto.getIdentificadorPauta(),sessaoDto.getDuracao());
        return ResponseEntity.ok().build();
    }
}
