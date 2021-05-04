package com.marcelosjsantos.dio.pessoa.pessoa_api.service;

import com.marcelosjsantos.dio.pessoa.pessoa_api.dto.request.PessoaDTO;
import com.marcelosjsantos.dio.pessoa.pessoa_api.dto.response.MessageResponseDTO;
import com.marcelosjsantos.dio.pessoa.pessoa_api.entity.Pessoa;
import com.marcelosjsantos.dio.pessoa.pessoa_api.repository.PessoaRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static com.marcelosjsantos.dio.pessoa.pessoa_api.Utils.PessoaUtils.createFakeDTO;
import static com.marcelosjsantos.dio.pessoa.pessoa_api.Utils.PessoaUtils.createFakeEntity;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class PessoaServiceTest {

    @Mock
    private PessoaRepository pessoaRepository;

    @InjectMocks
    private  PessoaService pessoaService;

    @Test
    void testaPersonDTOFornecidoRetornaSavedMessage() {
        PessoaDTO pessoaDTO = createFakeDTO();
        Pessoa pessoaSalvaEsperada = createFakeEntity();

        when(pessoaRepository.save(any(Pessoa.class))).thenReturn(pessoaSalvaEsperada);

        MessageResponseDTO mensagemSucessoEsperada = criaMessageResponseEsperada(pessoaSalvaEsperada.getId());
        MessageResponseDTO mensagemSucessoRetornada = pessoaService.createPessoa(pessoaDTO);

        assertEquals(mensagemSucessoEsperada, mensagemSucessoRetornada);
    }

    private MessageResponseDTO criaMessageResponseEsperada(Long id) {
        return MessageResponseDTO
                .builder()
                .message("Foi criada uma pessoa com ID " + id + "!")
                .build();
    }
}
