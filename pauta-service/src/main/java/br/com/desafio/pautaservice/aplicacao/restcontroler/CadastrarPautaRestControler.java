package br.com.desafio.pautaservice.aplicacao.restcontroler;

import br.com.desafio.pautaservice.aplicacao.dto.RequestPautaDto;
import br.com.desafio.pautaservice.aplicacao.dto.ResponsePautaDto;
import br.com.desafio.pautaservice.dominio.casosdeuso.CadastrarPauta;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RequestMapping("v1/api/pauta")
@RestController
public class CadastrarPautaRestControler {


    private final CadastrarPauta cadastrarPauta;

    @Autowired
    public CadastrarPautaRestControler(CadastrarPauta cadastrarPauta) {
        this.cadastrarPauta = cadastrarPauta;
    }


    @PostMapping(value = "/cadastrar/", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ResponsePautaDto> cadastrarPauta(@RequestBody @Valid RequestPautaDto pautaDto){
        try {
            cadastrarPauta.execute(pautaDto.getIdentificador(),pautaDto.getNome());
        }catch(Exception e){
            return ResponseEntity.ok(new ResponsePautaDto(false, e.getMessage()));
        }
        return ResponseEntity.ok().build();
    }


}
