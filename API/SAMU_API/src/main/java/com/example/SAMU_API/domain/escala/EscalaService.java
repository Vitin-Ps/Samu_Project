
package com.example.SAMU_API.domain.escala;

import com.example.SAMU_API.domain.escala.configuracao.DadosRegistraConfiguracaoEscala;
import com.example.SAMU_API.domain.escala.configuracao.EscalaConfiguracao;
import com.example.SAMU_API.domain.escala.intercessor.EscalaIntercessor;
import com.example.SAMU_API.domain.intercessor.Intercessor;
import com.example.SAMU_API.domain.intercessor.TipoIntercessor;
import com.example.SAMU_API.infra.exception.ValidacaoException;
import com.example.SAMU_API.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
public class EscalaService {

    @Autowired
    private EscalaConfiguracaoRepository escalaConfiguracaoRepository;

    @Autowired
    private EscalaRepository escalaRepository;

    @Autowired
    private IntercessorRepository intercessorRepository;

    @Autowired
    private IntercessorIndisponibilidadeRepository intercessorIndisponibilidadeRepository;

    @Autowired
    private EscalaIntercessorRepository escalaIntercessorRepository;


    public DadosListagemEscalaConfiguracao registraConfiguracaoEscala(DadosRegistraConfiguracaoEscala dados) {
        EscalaConfiguracao escalaConfiguracao = new EscalaConfiguracao(null, dados.nome(), dados.max_participacoes(), dados.percentual_principal());

        escalaConfiguracao = escalaConfiguracaoRepository.save(escalaConfiguracao);
        return new DadosListagemEscalaConfiguracao(escalaConfiguracao);
    }

    public DadosListagemEscala addEscala(DadosAddEscala dados) {
        EscalaConfiguracao escalaConfiguracao = escalaConfiguracaoRepository.getReferenceById(dados.id_configuracao());
        Escala escala = new Escala(null, escalaConfiguracao, dados.nome(), dados.numero_intercessores(), dados.dia());

        escalaRepository.save(escala);
        return new DadosListagemEscala(escala);
    }

    public DadosListagemEscalaConfiguracao detalharEscalasPorConfiguracao(Long id) {
        EscalaConfiguracao escalaConfiguracao = escalaConfiguracaoRepository.getReferenceById(id);
        List<DadosListagemEscala> listEscalas = escalaRepository.findAllByEscalaConfiguracaoId(id).stream().map(DadosListagemEscala::new).toList();

        return new DadosListagemEscalaConfiguracao(escalaConfiguracao, listEscalas);
    }

//    public void monstarEscala(Long id) {
//        DadosListagemEscalaConfiguracao escalaConfiguracao = detalharEscalasPorConfiguracao(id);
//
//        escalaIntercessorRepository.deleteAllByEscalaConfiguracaoId(id);
//
//        List<Intercessor> intercessorList = intercessorRepository.findAllByAtivoTrue();
//        Random random = new Random();
//
//        for (DadosListagemEscala escala : escalaConfiguracao.escalas()) {
//            for(int i = 0; i < escala.numero_intercessores(); i++) {
//                Intercessor intecessor = null;
//                List<Intercessor> intercessorRamdomList = intercessorList;
//                boolean intercessorEncontrado = false;
//
//                while(!intercessorEncontrado || intercessorRamdomList.isEmpty()) {
//                    int randomIndex = random.nextInt(intercessorList.size());
//                    intecessor = intercessorRamdomList.get(randomIndex);
//
//                    intercessorEncontrado = checarDisponibilidadeIntercessor(intecessor.getId(), escalaConfiguracao.id(), escala.id(),escalaConfiguracao.max_participantes(), escala.dia());
//                    intercessorRamdomList.remove(randomIndex);
//                }
//
//                    if(intercessorEncontrado && intecessor != null) {
//                        TipoIntercessor tipoIntercessor = retornaTipoIntercessor(escala, escalaConfiguracao.percentual_principal());
//                        EscalaIntercessor escalaIntercessor = new EscalaIntercessor(intecessor, escala, escalaConfiguracao, tipoIntercessor);
//
//                        escalaIntercessorRepository.save(escalaIntercessor);
//                    }
//            }
//        }
//
//    }

    public void monstarEscala(Long id) {
        DadosListagemEscalaConfiguracao escalaConfiguracao = detalharEscalasPorConfiguracao(id);

        escalaIntercessorRepository.deleteAllByEscalaConfiguracaoId(id);

        List<Intercessor> intercessorList = intercessorRepository.findAllByAtivoTrue();
        Random random = new Random();

        for (DadosListagemEscala escala : escalaConfiguracao.escalas()) {
            for (int i = 0; i < escala.numero_intercessores(); i++) {
                Intercessor intecessor = null;
                List<Intercessor> intercessorRamdomList = new ArrayList<>(intercessorList);
                boolean intercessorEncontrado = false;

                while (!intercessorEncontrado && !intercessorRamdomList.isEmpty()) {
                    int randomIndex = random.nextInt(intercessorRamdomList.size());
                    intecessor = intercessorRamdomList.get(randomIndex);

                    intercessorEncontrado = checarDisponibilidadeIntercessor(
                            intecessor.getId(),
                            escalaConfiguracao.id(),
                            escala.id(),
                            escalaConfiguracao.max_participantes(),
                            escala.dia()
                    );

                    intercessorRamdomList.remove(randomIndex);
                }

                if (intercessorEncontrado) {
                    salvarIntercessor(intecessor, escala, escalaConfiguracao);
                }
            }
        }
    }

    private void salvarIntercessor(Intercessor intercessor, DadosListagemEscala escala, DadosListagemEscalaConfiguracao escalaConfiguracao) {
        TipoIntercessor tipoIntercessor = retornaTipoIntercessor(escala, escalaConfiguracao.percentual_principal());
        EscalaIntercessor escalaIntercessor = new EscalaIntercessor(intercessor, escala, escalaConfiguracao, tipoIntercessor);
        escalaIntercessorRepository.save(escalaIntercessor);
    }

    private Boolean checarDisponibilidadeIntercessor(Long idIntercessor, Long idConfiguracao, Long idEscala, Integer maxParticipacoes, LocalDateTime diaEscala) {

        if(escalaIntercessorRepository.existsByEscalaIdAndIntercessorIdAndEscalaConfiguracaoId(idEscala, idIntercessor, idConfiguracao)) {
            return false;
        }

        if (intercessorIndisponibilidadeRepository.existsByIntercessorIdAndDia(idIntercessor, diaEscala)) {
            return false;
        }

        int participacoes = (int) escalaIntercessorRepository.findAllByEscalaConfiguracaoId(idConfiguracao).stream()
                .filter(escalaIntercessor -> escalaIntercessor.getIntercessor().getId().equals(idIntercessor))
                .count();

        return participacoes < maxParticipacoes;
    }

    private TipoIntercessor retornaTipoIntercessor(DadosListagemEscala escala, Integer percentualPrincipal) {
        if (percentualPrincipal < 0 || percentualPrincipal > 100) {
            throw new ValidacaoException("Percentual de Intecessores Principais deve estar entre 0 e 100.");
        }

        var countParticipantesEscala = escalaIntercessorRepository.countEscala(escala.id(), TipoIntercessor.PRINCIPAL.toString());

        int numeroPrincipais = (int) ((escala.numero_intercessores() / 100.0) * percentualPrincipal);

        return countParticipantesEscala < numeroPrincipais ? TipoIntercessor.PRINCIPAL : TipoIntercessor.STANDBY;
    }


}
