package com.example.SAMU_API.domain.escala;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public record DadosAddEscala(
        @NotBlank(message = "Nome")
        String nome,
        @NotNull(message = "Números de intercessores")
        Integer numero_intercessores,
        @JsonFormat(pattern = "dd/MM/yyyy HH:mm")
        LocalDateTime dia,
        @NotNull(message = "Configuração da escala")
        Long id_configuracao
) {
}
