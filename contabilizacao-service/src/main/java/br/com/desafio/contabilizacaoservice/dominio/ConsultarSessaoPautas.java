package br.com.desafio.contabilizacaoservice.dominio;

import br.com.desafio.contabilizacaoservice.dominio.casodeuso.dto.PautaDto;

public interface ConsultarSessaoPautas {
    PautaDto consultar(String identificadorPauta);
}
