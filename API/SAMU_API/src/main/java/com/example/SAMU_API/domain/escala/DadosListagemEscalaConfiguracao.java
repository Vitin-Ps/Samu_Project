package com.example.SAMU_API.domain.escala;

import com.example.SAMU_API.domain.escala.configuracao.EscalaConfiguracao;

import java.util.List;

public record DadosListagemEscalaConfiguracao(
        Long id,
        String nome,
        Integer max_participantes,
        Integer percentual_principal,
        List<DadosListagemEscala> escalas
) {

    public DadosListagemEscalaConfiguracao(EscalaConfiguracao escalaConfiguracao) {
        this(escalaConfiguracao.getId(), escalaConfiguracao.getNome(), escalaConfiguracao.getMax_participacoes(), escalaConfiguracao.getPercentual_principal(), null);
    }

    public DadosListagemEscalaConfiguracao(EscalaConfiguracao escalaConfiguracao, List<DadosListagemEscala> listEscalas) {
        this(escalaConfiguracao.getId(), escalaConfiguracao.getNome(), escalaConfiguracao.getMax_participacoes(), escalaConfiguracao.getPercentual_principal(), listEscalas);
    }
}
