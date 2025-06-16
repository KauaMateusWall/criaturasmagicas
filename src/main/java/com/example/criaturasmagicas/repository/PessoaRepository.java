package com.example.criaturasmagicas.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.criaturasmagicas.model.Pessoa;

public interface PessoaRepository extends JpaRepository<Pessoa, Long> {
}