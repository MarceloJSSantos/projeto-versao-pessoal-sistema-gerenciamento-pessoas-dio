package com.marcelosjsantos.dio.pessoa.pessoa_api.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class PessoaNotFoundException extends Exception {
    public PessoaNotFoundException(Long id) {
        super(String.format("A pessoa com o Id "+ id +" não foi encontrada!"));
    }
}
