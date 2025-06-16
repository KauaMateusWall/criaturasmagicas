package com.example.criaturasmagicas.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.criaturasmagicas.model.Criatura;

public interface CriaturaRepository extends JpaRepository<Criatura, Long> {
}