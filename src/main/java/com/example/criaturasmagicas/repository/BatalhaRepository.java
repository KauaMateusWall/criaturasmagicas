package com.example.criaturasmagicas.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.criaturasmagicas.model.Batalha;

public interface BatalhaRepository extends JpaRepository<Batalha, Long> {
}