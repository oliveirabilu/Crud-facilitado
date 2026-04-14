package com.examplecrud.crud.repositories;

import com.examplecrud.crud.entities.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PessoaRepository extends JpaRepository<Pessoa, Long> {
}
