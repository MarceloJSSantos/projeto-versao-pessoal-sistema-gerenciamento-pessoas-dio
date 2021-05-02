package com.marcelosjsantos.dio.pessoa.pessoa_api.service;

import com.marcelosjsantos.dio.pessoa.pessoa_api.dto.request.PessoaDTO;
import com.marcelosjsantos.dio.pessoa.pessoa_api.dto.response.MessageResponseDTO;
import com.marcelosjsantos.dio.pessoa.pessoa_api.entity.Pessoa;
import com.marcelosjsantos.dio.pessoa.pessoa_api.exception.PessoaNotFoundException;
import com.marcelosjsantos.dio.pessoa.pessoa_api.mapper.PessoaMapper;
import com.marcelosjsantos.dio.pessoa.pessoa_api.repository.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PessoaService {

    private final PessoaRepository pessoaRepository;

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

    public List<PessoaDTO> listaTodasPessoas() {
        List<Pessoa> todasPessoas = pessoaRepository.findAll();
        return  todasPessoas
                .stream()
                .map(pessoaMapper::toDTO)
                .collect(Collectors.toList());
    }

    public PessoaDTO encontrarPorId(Long id) throws PessoaNotFoundException {

        Pessoa pessoa = verificaSeExiste(id);

        return pessoaMapper.toDTO(pessoa);
    }

    public void delete(Long id) throws PessoaNotFoundException {
        verificaSeExiste(id);
        pessoaRepository.deleteById(id);
    }

    private Pessoa verificaSeExiste(Long id) throws PessoaNotFoundException {
        return pessoaRepository.findById(id).orElseThrow(() -> new PessoaNotFoundException(id));
    }
}
