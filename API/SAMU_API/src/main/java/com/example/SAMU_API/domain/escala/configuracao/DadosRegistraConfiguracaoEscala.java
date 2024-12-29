package com.example.SAMU_API.domain.escala.configuracao;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DadosRegistraConfiguracaoEscala(
        @NotBlank(message = "Nome")
        String nome,
        @NotBlank(message = "Participantes máximos")
        Integer max_participacoes,
        @NotNull(message = "Percentual de intercessores principais")
        Integer percentual_principal
) {

}
