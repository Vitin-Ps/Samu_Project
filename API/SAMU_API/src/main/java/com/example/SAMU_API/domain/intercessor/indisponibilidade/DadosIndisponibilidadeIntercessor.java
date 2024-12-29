package com.example.SAMU_API.domain.intercessor.indisponibilidade;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public record DadosIndisponibilidadeIntercessor(
        @NotNull(message = "Intercessor")
        Long id_intercessor,
        @JsonFormat(pattern = "dd/MM/yyyy HH:mm")
        LocalDateTime dia

) {
}
