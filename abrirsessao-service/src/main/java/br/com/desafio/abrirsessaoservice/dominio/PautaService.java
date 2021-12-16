package br.com.desafio.abrirsessaoservice.dominio;

import br.com.desafio.abrirsessaoservice.dominio.dto.PautaDto;

public interface PautaService {

    PautaDto buscarPauta(String identificador);
}
