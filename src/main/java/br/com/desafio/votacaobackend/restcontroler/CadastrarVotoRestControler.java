package br.com.desafio.votacaobackend.restcontroler;

import br.com.desafio.votacaobackend.aplicacao.dto.VotoDto;
import br.com.desafio.votacaobackend.dominio.casosdeuso.CadastrarVoto;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("v1/api/voto")
@RestController
public class CadastrarVotoRestControler {

    private CadastrarVoto cadastrarVoto;

    public CadastrarVotoRestControler(CadastrarVoto cadastrarVoto) {
        this.cadastrarVoto = cadastrarVoto;
    }

    @PostMapping(value = "/cadastrar", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<VotoDto> cadastrarVoto(@RequestBody VotoDto votoDto){
        cadastrarVoto.execute(votoDto.getIdentificadorPauta(),votoDto.getIdentificadorAssociado(), votoDto.isVoto());
        return ResponseEntity.ok().build();
    }

}
