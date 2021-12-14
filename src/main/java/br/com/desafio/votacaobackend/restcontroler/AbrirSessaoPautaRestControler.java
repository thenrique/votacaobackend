package br.com.desafio.votacaobackend.restcontroler;

import br.com.desafio.votacaobackend.aplicacao.dto.SessaoDto;
import br.com.desafio.votacaobackend.dominio.casosdeuso.AbrirSessaoVotacao;
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
        abrirSessaoVotacao.execute(sessaoDto);
        return ResponseEntity.ok().build();
    }
}
