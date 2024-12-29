package com.example.SAMU_API.domain.escala.personalizada.dias;

import com.example.SAMU_API.domain.escala.personalizada.DadosListagemEscalaPesonalizada;

public record DadosListagemEscalaPesonalizadaDia(
        Long id,
        DadosListagemEscalaPesonalizada escalaPesonalizada,
        DiasDaSemana dia_semana,
        Integer numer_intercessores

) {
    public DadosListagemEscalaPesonalizadaDia(EscalaPersonalizadaDia escalaPersonalizadaDia) {
        this(escalaPersonalizadaDia.getId(),
                new DadosListagemEscalaPesonalizada(escalaPersonalizadaDia.getEscalaPersonalizada()),
                escalaPersonalizadaDia.getDia_semana(),
                escalaPersonalizadaDia.getNumero_intercessores());
    }
}
