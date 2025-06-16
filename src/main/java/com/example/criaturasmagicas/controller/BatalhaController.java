package com.example.criaturasmagicas.controller;

import java.util.Optional;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.criaturasmagicas.model.Batalha;
import com.example.criaturasmagicas.model.Criatura;
import com.example.criaturasmagicas.model.Pessoa;
import com.example.criaturasmagicas.repository.BatalhaRepository;
import com.example.criaturasmagicas.repository.CriaturaRepository;
import com.example.criaturasmagicas.repository.PessoaRepository;

@Controller
@RequestMapping("/batalhas")
public class BatalhaController {

    @Autowired
    private BatalhaRepository batalhaRepository;
    @Autowired
    private PessoaRepository pessoaRepository;
    @Autowired
    private CriaturaRepository criaturaRepository;

    @GetMapping
    public String listarBatalhas(Model model) {
        model.addAttribute("batalhas", batalhaRepository.findAll());
        return "lista_batalhas";
    }

    @GetMapping("/nova")
    public String exibirFormularioNovaBatalha(Model model) {
        model.addAttribute("pessoas", pessoaRepository.findAll());
        model.addAttribute("criaturas", criaturaRepository.findAll());
        return "form_batalha";
    }

    @PostMapping("/iniciar")
    public String iniciarBatalha(@RequestParam Long pessoaId, @RequestParam Long criaturaId, Model model) {
        Optional<Pessoa> pessoaOpt = pessoaRepository.findById(pessoaId);
        Optional<Criatura> criaturaOpt = criaturaRepository.findById(criaturaId);

        if (pessoaOpt.isEmpty() || criaturaOpt.isEmpty()) {
            model.addAttribute("erro", "Pessoa ou Criatura não encontrada.");
            return "form_batalha";
        }

        Pessoa pessoa = pessoaOpt.get();
        Criatura criatura = criaturaOpt.get();

        // Lógica de batalha simples:
        // A pessoa vence se (idade + um número aleatório) for maior que (nível da criatura + um número aleatório)
        Random random = new Random();
        int poderPessoa = pessoa.getIdade() + random.nextInt(50); // Adiciona um bônus aleatório
        int poderCriatura = criatura.getNivel() + random.nextInt(50); // Adiciona um bônus aleatório

        String resultado;
        if (poderPessoa > poderCriatura) {
            resultado = "Vitória da Pessoa!";
        } else if (poderPessoa < poderCriatura) {
            resultado = "Vitória da Criatura!";
        } else {
            resultado = "Empate!";
        }

        Batalha batalha = new Batalha();
        batalha.setPessoa(pessoa);
        batalha.setCriatura(criatura);
        batalha.setResultado(resultado);
        batalhaRepository.save(batalha);

        model.addAttribute("resultadoBatalha", resultado);
        model.addAttribute("pessoa", pessoa);
        model.addAttribute("criatura", criatura);
        return "resultado_batalha";
    }
}