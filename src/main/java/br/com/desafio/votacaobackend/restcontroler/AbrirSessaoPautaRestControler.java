package br.com.desafio.votacaobackend.restcontroler;

import br.com.desafio.votacaobackend.aplicacao.dto.PautaDto;
import br.com.desafio.votacaobackend.aplicacao.dto.SessaoDto;
import br.com.desafio.votacaobackend.cadastrar.AbrirSessaoCasoDeUso;
import br.com.desafio.votacaobackend.cadastrar.CadastrarPautaCasoDeUso;
import br.com.desafio.votacaobackend.dominio.PautaRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.util.UriComponentsBuilder;

public class AbrirSessaoPautaRestControler {

    private final PautaRepositorio pautaRepositorio;

    @Autowired
    public AbrirSessaoPautaRestControler(PautaRepositorio pautaRepositorio) {
        this.pautaRepositorio = pautaRepositorio;
    }

    @PostMapping
    public ResponseEntity abrirSessao(@RequestBody SessaoDto sessaoDto){
        AbrirSessaoCasoDeUso abrirSessaoCasoDeUso = new AbrirSessaoCasoDeUso(pautaRepositorio);
        abrirSessaoCasoDeUso.execute(sessaoDto);
        return ResponseEntity.ok().build();
    }
}
