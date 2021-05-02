package com.marcelosjsantos.dio.pessoa.pessoa_api.service;

import com.marcelosjsantos.dio.pessoa.pessoa_api.dto.MessageResponseDTO;
import com.marcelosjsantos.dio.pessoa.pessoa_api.entity.Pessoa;
import com.marcelosjsantos.dio.pessoa.pessoa_api.repository.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PessoaService {

    private PessoaRepository pessoaRepository;

    @Autowired
    public PessoaService(PessoaRepository pessoaRepository) {
        this.pessoaRepository = pessoaRepository;
    }

    public MessageResponseDTO criaPessoa(Pessoa pessoa){
        Pessoa savedPessoa = pessoaRepository.save(pessoa);
        return MessageResponseDTO
                .builder()
                .message("Criado uma pessoa com ID " + savedPessoa.getId())
                .build();
    }
}
