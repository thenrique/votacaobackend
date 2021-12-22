package br.com.desafio.abrirsessaoservice.aplicacao.restcontroler;

import br.com.desafio.abrirsessaoservice.aplicacao.dto.SessaoDetalhadaDto;
import br.com.desafio.abrirsessaoservice.dominio.Sessao;
import br.com.desafio.abrirsessaoservice.dominio.casodeuso.AbrirSessaoVotacao;
import br.com.desafio.abrirsessaoservice.dominio.casodeuso.ConsultarSessaoVotacao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/api/sessaoPauta/")
public class ConsultarSessaoPautaRestControler {

    private final ConsultarSessaoVotacao consultarSessaoVotacao;

    @Autowired
    public ConsultarSessaoPautaRestControler(ConsultarSessaoVotacao consultarSessaoVotacao) {
        this.consultarSessaoVotacao = consultarSessaoVotacao;
    }


    @GetMapping("/get/{identificadorPauta}")
    public ResponseEntity<SessaoDetalhadaDto> buscar(@PathVariable String identificadorPauta){
        Sessao sessaoDto = consultarSessaoVotacao.buscarSessao(identificadorPauta);
        return ResponseEntity.ok(new SessaoDetalhadaDto(sessaoDto.getIdentificadorPauta(),sessaoDto.getDataAbertura(),sessaoDto.getDataEncerramento()));
    }

}
