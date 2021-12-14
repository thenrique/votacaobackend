package br.com.desafio.contabilizacaoservice.aplicacao.restcontroller;


import br.com.desafio.contabilizacaoservice.aplicacao.dto.PautaDto;
import br.com.desafio.contabilizacaoservice.aplicacao.dto.ResultadoVotacaoDto;
import br.com.desafio.contabilizacaoservice.dominio.casodeuso.ContabilizarResultadoVotacao;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("v1/api/contabilizarvotos")
@RestController
public class ContabilizarResultadoVotacaoRestController {

    private ContabilizarResultadoVotacao contabilizarResultadoVotacao;

    public ContabilizarResultadoVotacaoRestController(ContabilizarResultadoVotacao contabilizarResultadoVotacao) {
        this.contabilizarResultadoVotacao = contabilizarResultadoVotacao;
    }

    @GetMapping( consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ResultadoVotacaoDto> gerar(@RequestBody PautaDto pautaDto){
        contabilizarResultadoVotacao.execute(pautaDto.getIdentificador());
        return ResponseEntity.ok().build();
    }
}
