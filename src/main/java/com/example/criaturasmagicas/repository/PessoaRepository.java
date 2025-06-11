// src/main/java/com/example/criaturasmagicas/repository/PessoaRepository.java
package com.example.criaturasmagicas.repository;

import com.example.criaturasmagicas.model.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PessoaRepository extends JpaRepository<Pessoa, Long> {
    // Métodos CRUD básicos já são fornecidos pelo JpaRepository
}