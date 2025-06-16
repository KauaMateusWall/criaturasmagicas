package com.example.criaturasmagicas.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.criaturasmagicas.model.Criatura;
import com.example.criaturasmagicas.repository.CriaturaRepository;


@Controller
public class CriaturaController {

    @Autowired
    private CriaturaRepository criaturaRepository;

    @GetMapping("/")
    public String home(Model model) { // Adicione Model como parâmetro
        model.addAttribute("mensagem", "Bem-vindo ao Mundo das Criaturas Mágicas!"); // Opcional: passa uma mensagem
        return "hello.html"; // Retorna o nome do template HTML
    }
    
    @GetMapping("/novo")
    public String exibirFormularioCriatura(Model model) {
        model.addAttribute("criatura", new Criatura());
        return "form_criatura";
    }

    @PostMapping("/salvar")
    public String salvarCriatura(@ModelAttribute Criatura criatura) {
        criaturaRepository.save(criatura);
        return "redirect:/criaturas";
    }

    @GetMapping("/editar/{id}")
    public String exibirFormularioEdicao(@PathVariable Long id, Model model) {
        Criatura criatura = criaturaRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("ID da criatura inválido:" + id));
        model.addAttribute("criatura", criatura);
        return "form_criatura";
    }

    @GetMapping("/deletar/{id}")
    public String deletarCriatura(@PathVariable Long id) {
        criaturaRepository.deleteById(id);
        return "redirect:/criaturas";
    }
}