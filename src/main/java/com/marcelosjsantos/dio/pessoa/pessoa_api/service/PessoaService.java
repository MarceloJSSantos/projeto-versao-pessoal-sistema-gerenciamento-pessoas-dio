package com.marcelosjsantos.dio.pessoa.pessoa_api.service;

import com.marcelosjsantos.dio.pessoa.pessoa_api.dto.request.PessoaDTO;
import com.marcelosjsantos.dio.pessoa.pessoa_api.dto.response.MessageResponseDTO;
import com.marcelosjsantos.dio.pessoa.pessoa_api.entity.Pessoa;
import com.marcelosjsantos.dio.pessoa.pessoa_api.exception.PessoaNotFoundException;
import com.marcelosjsantos.dio.pessoa.pessoa_api.mapper.PessoaMapper;
import com.marcelosjsantos.dio.pessoa.pessoa_api.repository.PessoaRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class PessoaService {

    private final PessoaRepository pessoaRepository;

    private final PessoaMapper pessoaMapper = PessoaMapper.INSTANCE;

    public MessageResponseDTO createPessoa(PessoaDTO pessoaDTO){
        Pessoa pessoaToSave = pessoaMapper.toModel(pessoaDTO);

        Pessoa savedPessoa = pessoaRepository.save(pessoaToSave);
        return createMessageResponse(savedPessoa.getId(), "Foi criada uma pessoa com ID ");
    }

    public List<PessoaDTO> listAll() {
        List<Pessoa> todasPessoas = pessoaRepository.findAll();
        return  todasPessoas
                .stream()
                .map(pessoaMapper::toDTO)
                .collect(Collectors.toList());
    }

    public PessoaDTO findById(Long id) throws PessoaNotFoundException {

        Pessoa pessoa = verificaSeExiste(id);

        return pessoaMapper.toDTO(pessoa);
    }

    public void delete(Long id) throws PessoaNotFoundException {
        verificaSeExiste(id);
        pessoaRepository.deleteById(id);
    }

    public MessageResponseDTO updateById(Long id, PessoaDTO pessoaDTO) throws PessoaNotFoundException {
        verificaSeExiste(id);

        Pessoa pessoaToUpdate = pessoaMapper.toModel(pessoaDTO);
        Pessoa updatedPessoa = pessoaRepository.save(pessoaToUpdate);
        return createMessageResponse(updatedPessoa.getId(), "Foi atualizada a pessoa com ID ");
    }

    private MessageResponseDTO createMessageResponse(Long id, String message) {
        return MessageResponseDTO
                .builder()
                .message(message + id +"!")
                .build();
    }

    private Pessoa verificaSeExiste(Long id) throws PessoaNotFoundException {
        return pessoaRepository.findById(id).orElseThrow(() -> new PessoaNotFoundException(id));
    }
}
