package br.com.desafio.contabilizacaoservice.aplicacao.restcontroller;

import br.com.desafio.contabilizacaoservice.aplicacao.dto.PautaDto;
import br.com.desafio.contabilizacaoservice.aplicacao.dto.ResultadoVotacaoDto;
import br.com.desafio.contabilizacaoservice.dominio.casodeuso.ExibirResultadoVotacao;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("v1/api/resultado")
@RestController
public class ResultadoVotacaoRestController {

    private ExibirResultadoVotacao exibirResultadoVotacao;

    public ResultadoVotacaoRestController(ExibirResultadoVotacao exibirResultadoVotacao) {
        this.exibirResultadoVotacao = exibirResultadoVotacao;
    }

    @GetMapping( consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResultadoVotacaoDto apresentarResultado(@RequestBody PautaDto pautaDto){
        ResultadoVotacaoDto resultadoVotacaoDto= exibirResultadoVotacao.executar(pautaDto.getIdentificador());
        return resultadoVotacaoDto;
    }
}
