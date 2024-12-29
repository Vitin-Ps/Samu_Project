package com.example.SAMU_API.domain.intercessor;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DadosRegistroIntercessor(
        @NotBlank(message = "Nome")
        String nome,
        @NotNull(message = "Idade")
        Integer idade,
        @NotBlank(message = "Telefone")
        String telefone

        ) {
}
