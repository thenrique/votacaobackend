package br.com.desafio.abrirsessaoservice.dominio.casodeuso.impl;


import br.com.desafio.abrirsessaoservice.dominio.PautaService;
import br.com.desafio.abrirsessaoservice.dominio.Sessao;
import br.com.desafio.abrirsessaoservice.dominio.SessaoRepositorio;
import br.com.desafio.abrirsessaoservice.dominio.casodeuso.AbrirSessaoVotacao;


import br.com.desafio.abrirsessaoservice.dominio.dto.PautaDto;
import br.com.desafio.abrirsessaoservice.dominio.validacoes.SessaoJaFoiAberta;
import org.springframework.stereotype.Component;



import java.util.Optional;

@Component
public class AbrirSessaoCasoDeUso implements AbrirSessaoVotacao {

    private final SessaoRepositorio sessaoRepositorio;
    private final PautaService pautaService;


    public AbrirSessaoCasoDeUso(SessaoRepositorio sessaoRepositorio, PautaService pautaService) {
        this.sessaoRepositorio = sessaoRepositorio;
        this.pautaService = pautaService;

    }

    //TODO:REFACTORING
    @Override
    public void execute(String identificadorPauta, Long duracao){
        PautaDto pauta = pautaService.buscarPauta(identificadorPauta);
        if(pauta!=null){
            Sessao sessao = new Sessao(duracao,identificadorPauta);
            Optional<Sessao> sessaoOp = sessaoRepositorio.buscarSessaoPauta(identificadorPauta);
            if(sessaoOp.isPresent()){
                if(!sessaoOp.get().isAberta()){
                    throw  new SessaoJaFoiAberta(identificadorPauta);
                }
            }else{
                sessao.abrir(sessaoRepositorio);
            }

       }
    }
}
