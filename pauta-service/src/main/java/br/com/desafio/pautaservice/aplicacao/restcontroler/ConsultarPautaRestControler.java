package br.com.desafio.pautaservice.aplicacao.restcontroler;

import br.com.desafio.pautaservice.aplicacao.dto.ResponsePautaDto;
import br.com.desafio.pautaservice.dominio.casosdeuso.ConsultarPauta;
import br.com.desafio.pautaservice.dominio.casosdeuso.Pauta;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("v1/api/pauta")
@RestController
public class ConsultarPautaRestControler {

    private ConsultarPauta consultarPauta;

    public ConsultarPautaRestControler(ConsultarPauta consultarPauta) {
        this.consultarPauta = consultarPauta;
    }


    @GetMapping("/get/{identificadorPauta}")
    public ResponseEntity<ResponsePautaDto> buscarPauta(@PathVariable String identificadorPauta){
        Pauta pauta = consultarPauta.execute(identificadorPauta);
        ResponsePautaDto responsePautaDto = new ResponsePautaDto(pauta.getIdentificador(), pauta.getNome());
        return ResponseEntity.ok(responsePautaDto);
    }
}
