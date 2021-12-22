package br.com.desafio.abrirsessaoservice.dominio.casodeuso.impl;

import br.com.desafio.abrirsessaoservice.dominio.PautaService;
import br.com.desafio.abrirsessaoservice.dominio.Sessao;
import br.com.desafio.abrirsessaoservice.dominio.SessaoRepositorio;
import br.com.desafio.abrirsessaoservice.dominio.casodeuso.ConsultarSessaoVotacao;
import br.com.desafio.abrirsessaoservice.dominio.dto.PautaDto;
import br.com.desafio.abrirsessaoservice.dominio.validacoes.SessaoNaoEstaAberta;
import br.com.desafio.abrirsessaoservice.dominio.validacoes.SessaoNaoExiste;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class ConsultarSessaoCasoDeUso implements ConsultarSessaoVotacao {

    private SessaoRepositorio sessaoRepositorio;
    private final PautaService pautaService;

    public ConsultarSessaoCasoDeUso(SessaoRepositorio sessaoRepositorio, PautaService pautaService) {
        this.sessaoRepositorio = sessaoRepositorio;
        this.pautaService = pautaService;
    }

    @Override
    public Sessao buscarSessao(String identificadorPauta) {

        PautaDto pauta = pautaService.buscarPauta(identificadorPauta);

        if(pauta!=null){
            Optional<Sessao> sessaoOp = sessaoRepositorio.buscarSessaoPauta(identificadorPauta);
             if(sessaoOp.isPresent()){
                if(sessaoOp.get().isAberta()){
                    return sessaoOp.get();
                }else{
                    throw  new SessaoNaoEstaAberta(sessaoOp.get());
                }
            }else{
                 throw new SessaoNaoExiste(identificadorPauta);
             }
        }

        return null;
    }
}
