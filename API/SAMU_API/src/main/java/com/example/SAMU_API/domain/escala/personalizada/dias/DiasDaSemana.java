package com.example.SAMU_API.domain.escala.personalizada.dias;

import lombok.Getter;

@Getter
public enum DiasDaSemana {
    SEGUNDA("SEGUNDA"),
    TERCA("TERCA"),
    QUARTA("QUARTA"),
    QUINTA("QUINTA"),
    SEXTA("SEXTA"),
    SABADO("SABADO"),
    DOMINGO("DOMINGO");

    private final String diaDaSemana;

    DiasDaSemana(String diaDaSemana) {
        this.diaDaSemana = diaDaSemana;
    }
}