package br.com.desafio.contabilizacaoservice.aplicacao.restcontroller;


import br.com.desafio.contabilizacaoservice.aplicacao.dto.PautaDto;
import br.com.desafio.contabilizacaoservice.dominio.casodeuso.ContabilizarResultadoVotacao;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("v1/api/contabilizarvotos")
@RestController
public class ContabilizarResultadoVotacaoRestController {

    private ContabilizarResultadoVotacao contabilizarResultadoVotacao;

    public ContabilizarResultadoVotacaoRestController(ContabilizarResultadoVotacao contabilizarResultadoVotacao) {
        this.contabilizarResultadoVotacao = contabilizarResultadoVotacao;
    }

    @PostMapping(value = "/gerar",consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity gerar(@RequestBody PautaDto pautaDto){
        contabilizarResultadoVotacao.execute(pautaDto.getIdentificador());
        return ResponseEntity.ok().build();
    }
}
