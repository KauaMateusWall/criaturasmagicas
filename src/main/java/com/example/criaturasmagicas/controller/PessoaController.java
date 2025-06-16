package com.example.criaturasmagicas.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.criaturasmagicas.model.Pessoa;
import com.example.criaturasmagicas.repository.PessoaRepository;

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
    public String exibirFormularioEdicao(@PathVariable Long id, Model model) {
        Pessoa pessoa = pessoaRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("ID da pessoa inválido:" + id));
        model.addAttribute("pessoa", pessoa);
        return "form_pessoa";
    }

    @GetMapping("/deletar/{id}")
    public String deletarPessoa(@PathVariable Long id) {
        pessoaRepository.deleteById(id);
        return "redirect:/pessoas";
    }
}