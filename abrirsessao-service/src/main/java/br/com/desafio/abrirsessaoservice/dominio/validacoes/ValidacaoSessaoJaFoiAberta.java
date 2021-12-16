package br.com.desafio.abrirsessaoservice.dominio.validacoes;


import br.com.desafio.abrirsessaoservice.dominio.Sessao;

public class ValidacaoSessaoJaFoiAberta implements ValidacoesDeSessao {



    @Override
    public void validar(Sessao sessao) {
        if(sessao!=null){
            throw new SessaoJaFoiAberta(sessao.getIdentificadorPauta());
        }
    }
}
