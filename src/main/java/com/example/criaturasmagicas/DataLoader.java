// src/main/java/com/example/criaturasmagicas/DataLoader.java
package com.example.criaturasmagicas;

import com.example.criaturasmagicas.model.Criatura;
import com.example.criaturasmagicas.repository.CriaturaRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {

    private final CriaturaRepository criaturaRepository;

    public DataLoader(CriaturaRepository criaturaRepository) {
        this.criaturaRepository = criaturaRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        // Verifica se já existem criaturas para evitar duplicação na reinicialização
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
    }
}