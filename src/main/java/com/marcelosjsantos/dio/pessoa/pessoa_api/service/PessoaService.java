package com.marcelosjsantos.dio.pessoa.pessoa_api.service;

import com.marcelosjsantos.dio.pessoa.pessoa_api.dto.request.PessoaDTO;
import com.marcelosjsantos.dio.pessoa.pessoa_api.dto.response.MessageResponseDTO;
import com.marcelosjsantos.dio.pessoa.pessoa_api.entity.Pessoa;
import com.marcelosjsantos.dio.pessoa.pessoa_api.mapper.PessoaMapper;
import com.marcelosjsantos.dio.pessoa.pessoa_api.repository.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PessoaService {

    private PessoaRepository pessoaRepository;

    private final PessoaMapper pessoaMapper = PessoaMapper.INSTANCE;

    @Autowired
    public PessoaService(PessoaRepository pessoaRepository) {
        this.pessoaRepository = pessoaRepository;
    }

    public MessageResponseDTO criaPessoa(PessoaDTO pessoaDTO){
        Pessoa pessoaToSave = pessoaMapper.toModel(pessoaDTO);

        Pessoa savedPessoa = pessoaRepository.save(pessoaToSave);
        return MessageResponseDTO
                .builder()
                .message("Criado uma pessoa com ID " + savedPessoa.getId())
                .build();
    }
}
