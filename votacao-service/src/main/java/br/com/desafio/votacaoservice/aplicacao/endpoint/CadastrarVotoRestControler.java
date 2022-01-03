package br.com.desafio.votacaoservice.aplicacao.endpoint;


import br.com.desafio.votacaoservice.aplicacao.dto.RespostaVotoDto;
import br.com.desafio.votacaoservice.aplicacao.dto.VotoDto;
import br.com.desafio.votacaoservice.dominio.CadastrarVoto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RequestMapping("v1/api/voto")
@RestController
public class CadastrarVotoRestControler {

    private static final Logger logger = LoggerFactory.getLogger(CadastrarVotoRestControler.class);

    private CadastrarVoto cadastrarVoto;

    public CadastrarVotoRestControler(CadastrarVoto cadastrarVoto) {
        this.cadastrarVoto = cadastrarVoto;
    }

    @PostMapping(value = "/cadastrar", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<RespostaVotoDto> cadastrarVoto(@RequestBody @Valid VotoDto votoDto){
        try {
            cadastrarVoto.execute(votoDto.getIdentificadorPauta(),votoDto.getIdentificadorAssociado(), votoDto.getVoto());
        }catch (Exception e){
            logger.error(e.getMessage());
            return ResponseEntity.ok(new RespostaVotoDto(false, e.getMessage()));
        }
        return ResponseEntity.ok(new RespostaVotoDto(true,"Voto Computado"));
    }

}
