package br.com.desafio.votacaoservice.dominio.casosdeuso.impl;

import br.com.desafio.votacaoservice.dominio.ConsultarSessaoPautas;
import br.com.desafio.votacaoservice.dominio.ValidacaoCpf;
import br.com.desafio.votacaoservice.dominio.Votacao;
import br.com.desafio.votacaoservice.dominio.VotacaoRepositorio;
import br.com.desafio.votacaoservice.dominio.casosdeuso.CadastrarVoto;
import br.com.desafio.votacaoservice.dominio.dto.PautaSessaoDto;
import br.com.desafio.votacaoservice.dominio.validacao.AssociadoJaComputouVoto;
import br.com.desafio.votacaoservice.dominio.validacao.CPFInvalido;
import br.com.desafio.votacaoservice.infraestrutura.memoria.RepositoriodeVotacaoMemoria;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class VotarCasoDeUsoTest {


    private String identificadorPauta="1234";
    private VotacaoRepositorio votacaoRepositorio = new RepositoriodeVotacaoMemoria();
    private String cpfAssociado="23399623070";
    private ConsultarSessaoPautas consultarSessaoPautas = Mockito.mock(ConsultarSessaoPautas.class);
    private ValidacaoCpf validacaoCPF = Mockito.mock(ValidacaoCpf.class);


    @Test
    void deveCadastrarVotoAssociado() {


        CadastrarVoto cadastrarVoto = new VotarCasoDeUso(votacaoRepositorio,consultarSessaoPautas, validacaoCPF);
        Mockito.when(validacaoCPF.isPermitidoVotar(cpfAssociado)).thenReturn(true);
        Mockito.when(consultarSessaoPautas.consultar(identificadorPauta)).thenReturn(new PautaSessaoDto(identificadorPauta));

        cadastrarVoto.execute(identificadorPauta,cpfAssociado,true);

        Optional<Votacao> votacaoOptional = votacaoRepositorio.buscarVoto(identificadorPauta, cpfAssociado);
        assertEquals(true, votacaoOptional.get().isVoto());

    }

    @Test
    void naoDeveCadastrarVotoDuplicado() {
        CadastrarVoto cadastrarVoto = new VotarCasoDeUso(votacaoRepositorio,consultarSessaoPautas, validacaoCPF);
        Mockito.when(validacaoCPF.isPermitidoVotar(cpfAssociado)).thenReturn(true);
        cadastrarVoto.execute("1234",cpfAssociado,true);
        try {
            Mockito.when(validacaoCPF.isPermitidoVotar(cpfAssociado)).thenReturn(true);
            cadastrarVoto.execute("1234",cpfAssociado,true);
        }catch(AssociadoJaComputouVoto e){
            assertEquals(" O associado de identificador " + cpfAssociado + " já votou na pauta de número " + identificadorPauta, e.getMessage());
        }

    }

    @Test
    void deveLancarErroCPFInvalido() {
        CadastrarVoto cadastrarVoto = new VotarCasoDeUso(votacaoRepositorio,consultarSessaoPautas, validacaoCPF);

        try {
            Mockito.when(validacaoCPF.isPermitidoVotar(cpfAssociado)).thenReturn(false);
            cadastrarVoto.execute("1234",cpfAssociado,true);
        }catch(CPFInvalido e){
            assertEquals("O CPF informado " + cpfAssociado + " é invalido", e.getMessage());
        }

    }


}