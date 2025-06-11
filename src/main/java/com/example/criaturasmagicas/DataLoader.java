// src/main/java/com/example/criaturasmagicas/DataLoader.java
package com.example.criaturasmagicas;

import com.example.criaturasmagicas.model.Criatura;
import com.example.criaturasmagicas.model.Pessoa; // Importe a classe Pessoa
import com.example.criaturasmagicas.repository.CriaturaRepository;
import com.example.criaturasmagicas.repository.PessoaRepository; // Importe o PessoaRepository
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {

    private final CriaturaRepository criaturaRepository;
    private final PessoaRepository pessoaRepository; // Injete o PessoaRepository

    public DataLoader(CriaturaRepository criaturaRepository, PessoaRepository pessoaRepository) { // Adicione PessoaRepository ao construtor
        this.criaturaRepository = criaturaRepository;
        this.pessoaRepository = pessoaRepository; // Atribua o PessoaRepository
    }

    @Override
    public void run(String... args) throws Exception {
        // --- Popula Criaturas ---
        if (criaturaRepository.count() == 0) {
            Criatura dragao = new Criatura();
            dragao.setNome("Dragão Flamejante");
            dragao.setTipo("Dragão");
            dragao.setNivel(100);
            criaturaRepository.save(dragao);

            Criatura elfo = new Criatura();
            elfo.setNome("Elfo da Floresta");
            elfo.setTipo("Elfo");
            elfo.setNivel(50);
            criaturaRepository.save(elfo);

            Criatura sereia = new Criatura();
            sereia.setNome("Sereia Encantada");
            sereia.setTipo("Sereia");
            sereia.setNivel(75);
            criaturaRepository.save(sereia);

            System.out.println("Criaturas iniciais inseridas manualmente!");
        } else {
            System.out.println("Criaturas já existem no banco de dados. Pulando inserção manual.");
        }

        // --- Popula Pessoas ---
        if (pessoaRepository.count() == 0) {
            Pessoa heroi = new Pessoa();
            heroi.setNome("Aragorn");
            heroi.setIdade(35);
            heroi.setOcupacao("Guardião");
            pessoaRepository.save(heroi);

            Pessoa maga = new Pessoa();
            maga.setNome("Gandalf");
            maga.setIdade(150); // Idade fictícia para um mago :)
            maga.setOcupacao("Mago");
            pessoaRepository.save(maga);

            Pessoa aldeao = new Pessoa();
            aldeao.setNome("Aldeão Simples");
            aldeao.setIdade(28);
            aldeao.setOcupacao("Fazendeiro");
            pessoaRepository.save(aldeao);

            System.out.println("Pessoas iniciais inseridas manualmente!");
        } else {
            System.out.println("Pessoas já existem no banco de dados. Pulando inserção manual.");
        }
    }
}