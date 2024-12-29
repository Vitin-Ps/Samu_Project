package com.example.SAMU_API.domain.escala.personalizada;

public record DadosListagemEscalaPesonalizada(
        Long id,
        String nome
) {
    public DadosListagemEscalaPesonalizada(EscalaPersonalizada escalaPersonalizada) {
        this(escalaPersonalizada.getId(), escalaPersonalizada.getNome());
    }
}
