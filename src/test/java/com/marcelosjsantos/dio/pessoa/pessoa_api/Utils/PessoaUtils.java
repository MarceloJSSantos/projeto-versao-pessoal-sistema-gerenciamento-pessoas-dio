package com.marcelosjsantos.dio.pessoa.pessoa_api.Utils;

import com.marcelosjsantos.dio.pessoa.pessoa_api.dto.request.PessoaDTO;
import com.marcelosjsantos.dio.pessoa.pessoa_api.entity.Pessoa;

import java.time.LocalDate;
import java.util.Collections;

public class PessoaUtils {

    private static final Long PESSOA_ID = 1L;
    private static final String NOME_PRIMEIRO="Rodrigo";
    private static final String NOME_ULTIMO="Silva";
    private static final String CPF="369.333.878-79";
    //private static final String DATA_NASCIMENTO="04-04-2004";
    private static final LocalDate DATA_NASCIMENTO=LocalDate.of(2010,10,1);

    public static PessoaDTO createFakeDTO() {
        return PessoaDTO.builder()
                .nomePrimeiro(NOME_PRIMEIRO)
                .nomeUltimo(NOME_ULTIMO)
                .cpf(CPF)
                .dataNascimento("04-04-2004")
                .telefones(Collections.singletonList(TelefoneUtils.createFakeDTO()))
                .build();
    }

    public static Pessoa createFakeEntity() {
        return Pessoa.builder()
                .id(PESSOA_ID)
                .nomePrimeiro(NOME_PRIMEIRO)
                .nomeUltimo(NOME_ULTIMO)
                .cpf(CPF)
                .dataNascimento(DATA_NASCIMENTO)
                .telefones(Collections.singletonList(TelefoneUtils.createFakeEntity()))
                .build();
    }
}
