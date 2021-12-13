package br.com.desafio.votacaobackend.restcontroler;

import br.com.desafio.votacaobackend.aplicacao.dto.PautaDto;
import br.com.desafio.votacaobackend.dominio.casosdeuso.CadastrarPauta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

@RequestMapping("/v1/api/pauta/")
@RestController
public class CadastrarPautaRestControler {


    private final CadastrarPauta cadastrarPauta;

    @Autowired
    public CadastrarPautaRestControler(CadastrarPauta cadastrarPauta) {
        this.cadastrarPauta = cadastrarPauta;
    }

    @PostMapping
    public ResponseEntity cadastrarPauta(@RequestBody PautaDto pautaDto, UriComponentsBuilder uriComponentsBuilder){
        cadastrarPauta.execute(pautaDto);
        return ResponseEntity.ok().build();
    }


}
