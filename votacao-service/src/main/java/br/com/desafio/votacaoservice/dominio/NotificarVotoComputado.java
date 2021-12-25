package br.com.desafio.votacaoservice.dominio;

import br.com.desafio.votacaoservice.dominio.dto.VotoDto;

public interface NotificarVotoComputado {

    void execute(VotoDto votoDto);
}
