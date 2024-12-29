package com.example.SAMU_API.domain.escala;

import java.time.LocalDateTime;

public record DadosListagemEscala(
        Long id,
        String nome,
        Integer numero_intercessores,
        LocalDateTime dia,
        Long id_configuracao
) {
    public DadosListagemEscala(Escala escala) {
        this(escala.getId(), escala.getNome(), escala.getNumero_intercessores(), escala.getDia(), escala.getEscalaConfiguracao().getId());
    }
}
