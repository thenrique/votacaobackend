package br.com.desafio.votacaobackend.restcontroler;

import br.com.desafio.votacaobackend.aplicacao.dto.PautaDto;
import br.com.desafio.votacaobackend.aplicacao.dto.ResultadoVotacaoDto;
import br.com.desafio.votacaobackend.dominio.casosdeuso.ContabilizarResultadoVotacao;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("v1/api/resultado")
@RestController
public class ContabilizarResultadoVotacaoRestController {

    private ContabilizarResultadoVotacao contabilizarResultadoVotacao;

    public ContabilizarResultadoVotacaoRestController(ContabilizarResultadoVotacao contabilizarResultadoVotacao) {
        this.contabilizarResultadoVotacao = contabilizarResultadoVotacao;
    }

    @GetMapping(value = "/resultado/", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ResultadoVotacaoDto> apresentarResultado(@RequestBody PautaDto pautaDto){
        contabilizarResultadoVotacao.execute(pautaDto.getIdentificador());
        return ResponseEntity.ok().build();
    }
}
