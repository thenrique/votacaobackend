package br.com.desafio.exibirresultadoservice.aplicacao.restcontroller;


import br.com.desafio.exibirresultadoservice.aplicacao.dto.PautaDto;
import br.com.desafio.exibirresultadoservice.aplicacao.dto.ResultadoDto;
import br.com.desafio.exibirresultadoservice.casodeuso.ExibirResultadoVotacao;
import br.com.desafio.exibirresultadoservice.casodeuso.ResultadoVotacao;
import org.springframework.http.MediaType;
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
    public ResultadoDto apresentarResultado(@RequestBody PautaDto pautaDto){
        ResultadoVotacao resultadoVotacao= exibirResultadoVotacao.executar(pautaDto.getIdentificador());
        return new ResultadoDto(resultadoVotacao);
    }
}
