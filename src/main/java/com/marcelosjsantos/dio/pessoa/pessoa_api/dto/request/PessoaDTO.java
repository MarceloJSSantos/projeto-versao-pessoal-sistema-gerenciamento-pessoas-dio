package com.marcelosjsantos.dio.pessoa.pessoa_api.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.br.CPF;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PessoaDTO {

    private Long id;

    @NotEmpty
    @Size(min = 2, max = 100)
    private String nomePrimeiro;

    @NotEmpty
    @Size(min = 2, max = 100)
    private String nomeUltimo;

    @NotEmpty
    @CPF
    private String cpf;

    private String dataNascimento;

    @Valid
    @NotEmpty
    private List<TelefoneDTO> telefones;
}
