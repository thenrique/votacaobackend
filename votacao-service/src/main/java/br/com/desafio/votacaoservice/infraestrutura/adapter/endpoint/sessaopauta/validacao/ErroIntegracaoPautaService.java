package br.com.desafio.votacaoservice.infraestrutura.adapter.endpoint.sessaopauta.validacao;

public class ErroIntegracaoPautaService extends RuntimeException{

    public ErroIntegracaoPautaService(String mensagem) {
        super(mensagem);
    }

}
