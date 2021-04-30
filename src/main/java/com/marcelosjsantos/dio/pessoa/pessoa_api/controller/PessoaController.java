package com.marcelosjsantos.dio.pessoa.pessoa_api.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/vi/pessoas")
public class PessoaController {

    @GetMapping
    public String getBook(){
        return "API Test!";
    }
}
