package com.marcelosjsantos.dio.pessoa.pessoa_api.repository;

import com.marcelosjsantos.dio.pessoa.pessoa_api.entity.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PessoaRepository extends JpaRepository<Pessoa, Long> {
}
