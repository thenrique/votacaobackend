package br.com.desafio.votacaobackend.restcontroler;

import br.com.desafio.votacaobackend.aplicacao.dto.PautaDto;
import br.com.desafio.votacaobackend.cadastrar.CadastrarPautaCasoDeUso;
import br.com.desafio.votacaobackend.dominio.PautaRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

@RequestMapping("/api/pauta/")
@RestController
public class CadastrarPautaRestControler {


    private final PautaRepositorio pautaRepositorio;

    @Autowired
    public CadastrarPautaRestControler(PautaRepositorio pautaRepositorio) {
        this.pautaRepositorio = pautaRepositorio;
    }

    @PostMapping
    public ResponseEntity cadastrarPauta(@RequestBody PautaDto pautaDto, UriComponentsBuilder uriComponentsBuilder){
        CadastrarPautaCasoDeUso cadastrarPautaEvento = new CadastrarPautaCasoDeUso(pautaRepositorio);
        cadastrarPautaEvento.execute(pautaDto);
        return ResponseEntity.ok().build();
    }


}
