package br.com.desafio.contabilizacaoservice.aplicacao.restcontroler;

import br.com.desafio.contabilizacaoservice.dominio.casodeuso.DisponibilizarResultadoVotacao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@RestController
@RequestMapping("/v1/api/contabilizacao")
public class DisponibilizarVotacaoRestControler {

    DisponibilizarResultadoVotacao disponibilizarResultadoVotacao;

    @Autowired
    public DisponibilizarVotacaoRestControler(DisponibilizarResultadoVotacao disponibilizarResultadoVotacao) {
        this.disponibilizarResultadoVotacao = disponibilizarResultadoVotacao;
    }

    @RequestMapping("/disponibilizarresultado/{identificadorPauta}")
    public void disponibilizar(@PathVariable @Valid @NotNull @NotEmpty String identificadorPauta){
        disponibilizarResultadoVotacao.execute(identificadorPauta);
    }
}
