package br.com.desafio.votacaoservice.dominio;

import br.com.desafio.votacaoservice.dominio.dto.PautaSessaoDto;

public interface ConsultarSessaoPautas {

    PautaSessaoDto consultar(String identificadorPauta);
}
