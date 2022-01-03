package br.com.desafio.pautaservice.aplicacao.restcontroler;

import br.com.desafio.pautaservice.aplicacao.dto.ResponsePautaDto;
import br.com.desafio.pautaservice.dominio.casosdeuso.ConsultarPauta;
import br.com.desafio.pautaservice.dominio.casosdeuso.Pauta;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@RequestMapping("/v1/api/pauta")
@RestController
public class ConsultarPautaRestControler {

    private static final Logger logger = LoggerFactory.getLogger(ConsultarPautaRestControler.class);
    private ConsultarPauta consultarPauta;

    public ConsultarPautaRestControler(ConsultarPauta consultarPauta) {
        this.consultarPauta = consultarPauta;
    }


    @GetMapping("/get/{identificadorPauta}")
    public ResponseEntity<ResponsePautaDto> buscarPauta(@PathVariable @Valid @NotEmpty @NotNull String identificadorPauta){
        try {
            Pauta pauta = consultarPauta.execute(identificadorPauta);
            ResponsePautaDto responsePautaDto = new ResponsePautaDto(pauta.getIdentificador(), pauta.getNome(), true);
            return ResponseEntity.ok(responsePautaDto);
        }catch (Exception e){
            logger.error(e.getMessage());
            ResponsePautaDto responsePautaDto = new ResponsePautaDto(false, e.getMessage());
            return ResponseEntity.ok(responsePautaDto);
        }

    }
}
