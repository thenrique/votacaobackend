package br.com.desafio.abrirsessaoservice.infraestrutura.adapter.endpoint.validacao;

public class ErroIntegracaoPautaService extends RuntimeException {

    public ErroIntegracaoPautaService( String erro) {
        super("Não foi possivel consultar a pauta: "+ erro);
    }
}
