package br.com.desafio.votacaoservice.dominio;

import br.com.desafio.votacaoservice.infraestrutura.adapter.endpoint.heroku.erro.ServicoIndisponivel;

public interface ValidacaoCpf {

    public boolean isPermitidoVotar(String cpf) throws RuntimeException;

}
