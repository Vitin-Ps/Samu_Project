package com.example.SAMU_API.domain.escala.personalizada.dias;

import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DadosRegistroEscalaPesonalizadaDia(
        @NotBlank(message = "Nome") String nome,
        @NotNull(message = "Escala Personalizada")
        Long id_escala_personalizada,
        @NotNull(message = "Número de intercessores")
        Integer numero_intercessores,
        @Enumerated
        DiasDaSemana dia_semana

) {
}
