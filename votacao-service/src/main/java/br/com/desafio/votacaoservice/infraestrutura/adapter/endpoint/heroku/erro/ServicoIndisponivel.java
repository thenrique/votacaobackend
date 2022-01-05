package br.com.desafio.votacaoservice.infraestrutura.adapter.endpoint.heroku.erro;

public class ServicoIndisponivel extends RuntimeException {
    public ServicoIndisponivel(String servico) {
        super("O Serviço está indisponível " + servico);
    }
}
