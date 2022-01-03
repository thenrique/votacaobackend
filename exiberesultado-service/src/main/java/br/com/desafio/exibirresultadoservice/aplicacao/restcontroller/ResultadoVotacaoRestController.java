package br.com.desafio.exibirresultadoservice.aplicacao.restcontroller;


import br.com.desafio.exibirresultadoservice.aplicacao.dto.PautaDto;
import br.com.desafio.exibirresultadoservice.aplicacao.dto.ResultadoDto;
import br.com.desafio.exibirresultadoservice.casodeuso.ExibirResultadoVotacao;
import br.com.desafio.exibirresultadoservice.casodeuso.ResultadoVotacao;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RequestMapping("v1/api/resultado")
@RestController
public class ResultadoVotacaoRestController {

    private ExibirResultadoVotacao exibirResultadoVotacao;

    public ResultadoVotacaoRestController(ExibirResultadoVotacao exibirResultadoVotacao) {
        this.exibirResultadoVotacao = exibirResultadoVotacao;
    }

    @PostMapping(value ="/exibir" ,consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResultadoDto apresentarResultado(@RequestBody @Valid PautaDto pautaDto){
        ResultadoVotacao resultadoVotacao= exibirResultadoVotacao.executar(pautaDto.getIdentificador());
        return new ResultadoDto(resultadoVotacao);
    }
}
