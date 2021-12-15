package br.com.desafio.abrirsessaoservice.dominio.casodeuso.impl;


import br.com.desafio.abrirsessaoservice.dominio.Pauta;
import br.com.desafio.abrirsessaoservice.dominio.PautaRepositorio;
import br.com.desafio.abrirsessaoservice.dominio.casodeuso.AbrirSessaoVotacao;


import org.springframework.stereotype.Component;


import java.util.Optional;

@Component
public class AbrirSessaoCasoDeUso implements AbrirSessaoVotacao {

    private final PautaRepositorio pautaRepositorio;



    public AbrirSessaoCasoDeUso(PautaRepositorio pautaRepositorio) {
        this.pautaRepositorio = pautaRepositorio;

    }

    @Override
    public void execute(String identificadorPauta, Long duracao){
        Optional<Pauta> pautaOptional = pautaRepositorio.buscarPauta(identificadorPauta);
        if(pautaOptional.isPresent()){
            pautaOptional.get().getValidacoes().forEach(validacoesDePautas -> validacoesDePautas.validar(pautaOptional));
            Pauta pauta = pautaOptional.get();
            pauta.abreSessao(duracao,pautaRepositorio);
        }


    }
}
