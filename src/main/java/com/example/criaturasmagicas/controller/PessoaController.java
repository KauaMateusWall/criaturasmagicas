// src/main/java/com/example/criaturasmagicas/controller/PessoaController.java
package com.example.criaturasmagicas.controller;

import com.example.criaturasmagicas.model.Pessoa;
import com.example.criaturasmagicas.repository.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RequestMapping("/pessoas")
public class PessoaController {

    @Autowired
    private PessoaRepository pessoaRepository;

    @GetMapping
    public String listarPessoas(Model model) {
        model.addAttribute("pessoas", pessoaRepository.findAll());
        return "lista_pessoas";
    }

    @GetMapping("/novo")
    public String exibirFormularioPessoa(Model model) {
        model.addAttribute("pessoa", new Pessoa());
        return "form_pessoa";
    }

    @PostMapping("/salvar")
    public String salvarPessoa(@ModelAttribute Pessoa pessoa) {
        pessoaRepository.save(pessoa);
        return "redirect:/pessoas";
    }

    @GetMapping("/editar/{id}")
    public String editarPessoa(@PathVariable Long id, Model model) {
        Optional<Pessoa> pessoa = pessoaRepository.findById(id);
        if (pessoa.isPresent()) {
            model.addAttribute("pessoa", pessoa.get());
            return "form_pessoa";
        }
        return "redirect:/pessoas";
    }

    @GetMapping("/deletar/{id}")
    public String deletarPessoa(@PathVariable Long id) {
        pessoaRepository.deleteById(id);
        return "redirect:/pessoas";
    }
}