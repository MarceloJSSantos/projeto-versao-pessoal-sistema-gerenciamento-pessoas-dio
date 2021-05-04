package com.marcelosjsantos.dio.pessoa.pessoa_api.Utils;

import com.marcelosjsantos.dio.pessoa.pessoa_api.dto.request.TelefoneDTO;
import com.marcelosjsantos.dio.pessoa.pessoa_api.entity.Telefone;
import com.marcelosjsantos.dio.pessoa.pessoa_api.enums.TipoTelefone;

public class TelefoneUtils {

    private static final Long TELEFONE_ID = 1L;
    private static final TipoTelefone TELEFONE_TIPO = TipoTelefone.CELULAR;
    private static final String TELEFONE_NUMERO="(21)99999-9999";

    public static TelefoneDTO createFakeDTO() {
        return TelefoneDTO.builder()
                .id(TELEFONE_ID)
                .numero(TELEFONE_NUMERO)
                .tipo(TELEFONE_TIPO)
                .build();
    }

    public static Telefone createFakeEntity() {
        return Telefone.builder()
                .id(TELEFONE_ID)
                .numero(TELEFONE_NUMERO)
                .tipo(TELEFONE_TIPO)
                .build();
    }
}
