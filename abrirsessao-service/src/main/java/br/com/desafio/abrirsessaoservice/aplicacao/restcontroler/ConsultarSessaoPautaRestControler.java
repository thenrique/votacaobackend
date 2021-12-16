package br.com.desafio.abrirsessaoservice.aplicacao.restcontroler;

import br.com.desafio.abrirsessaoservice.dominio.casodeuso.AbrirSessaoVotacao;
import br.com.desafio.abrirsessaoservice.dominio.casodeuso.ConsultarSessaoVotacao;
import org.springframework.beans.factory.annotation.Autowired;
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

}
