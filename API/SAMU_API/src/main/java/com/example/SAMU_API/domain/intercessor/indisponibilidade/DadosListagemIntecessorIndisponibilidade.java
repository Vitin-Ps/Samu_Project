package com.example.SAMU_API.domain.intercessor.indisponibilidade;

import com.example.SAMU_API.domain.intercessor.DadosListagemIntecessor;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public record DadosListagemIntecessorIndisponibilidade(
        Long id,
        DadosListagemIntecessor intecessor,
        @JsonFormat(pattern = "dd/MM/yyyy HH:mm")
        LocalDateTime dia

) {
    public DadosListagemIntecessorIndisponibilidade(IntercessorIndisponibilidade intercessorIndisponibilidade) {
        this(intercessorIndisponibilidade.getId(), new DadosListagemIntecessor(intercessorIndisponibilidade.getIntercessor()), intercessorIndisponibilidade.getDia());
    }
}
