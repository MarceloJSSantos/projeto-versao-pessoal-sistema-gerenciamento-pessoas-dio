package com.marcelosjsantos.dio.pessoa.pessoa_api.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum TipoTelefone {

    CASA("Casa"),
    CELULAR("Celular"),
    COMMERCIAL("Comercial");

    private final String description;
}
