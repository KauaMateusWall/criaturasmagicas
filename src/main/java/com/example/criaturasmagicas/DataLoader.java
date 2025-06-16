package com.example.criaturasmagicas;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.example.criaturasmagicas.model.Criatura;
import com.example.criaturasmagicas.model.Pessoa;
import com.example.criaturasmagicas.repository.CriaturaRepository;
import com.example.criaturasmagicas.repository.PessoaRepository;

@Component
public class DataLoader implements CommandLineRunner {

    private final PessoaRepository pessoaRepository;
    private final CriaturaRepository criaturaRepository;

    @Autowired
    public DataLoader(PessoaRepository pessoaRepository, CriaturaRepository criaturaRepository) {
        this.pessoaRepository = pessoaRepository;
        this.criaturaRepository = criaturaRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        // Verifica se já existem dados para não duplicar
        if (pessoaRepository.count() == 0) {
            Pessoa p1 = new Pessoa();
            p1.setNome("Alice");
            p1.setIdade(25);
            p1.setOcupacao("Aventureira");
            pessoaRepository.save(p1);

            Pessoa p2 = new Pessoa();
            p2.setNome("Bob");
            p2.setIdade(30);
            p2.setOcupacao("Mago");
            pessoaRepository.save(p2);
        }

        if (criaturaRepository.count() == 0) {
            Criatura c1 = new Criatura();
            c1.setNome("Dragão Infernal");
            c1.setNivel(80);
            c1.setTipo("Dragão");
            criaturaRepository.save(c1);

            Criatura c2 = new Criatura();
            c2.setNome("Duende Travesso");
            c2.setNivel(15);
            c2.setTipo("Duende");
            criaturaRepository.save(c2);
        }
    }
}