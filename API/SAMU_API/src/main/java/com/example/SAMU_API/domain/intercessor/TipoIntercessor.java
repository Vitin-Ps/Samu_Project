package com.example.SAMU_API.domain.intercessor;

import lombok.Getter;

@Getter
public enum TipoIntercessor {
    STANDBY("STANDBY"),
    PRINCIPAL("PRINCIPAL");

    private final String tipoIntercessor;

    TipoIntercessor(String tipoIntercessor) {
        this.tipoIntercessor = tipoIntercessor;
    }

}
