// src/main/java/com/example/criaturasmagicas/controller/CriaturaController.java
package com.example.criaturasmagicas.controller;

import com.example.criaturasmagicas.model.Criatura;
import com.example.criaturasmagicas.repository.CriaturaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ModelAttribute; // Importe esta anotação

@Controller
public class CriaturaController {

    @Autowired
    private CriaturaRepository criaturaRepository;

    @GetMapping("/")
    public String home() {
        return "redirect:/criaturas";
    }

    @GetMapping("/criaturas")
    public String listarCriaturas(Model model) {
        Iterable<Criatura> criaturas = criaturaRepository.findAll();
        model.addAttribute("criaturas", criaturas);
        return "lista_criaturas";
    }

    @GetMapping("/criaturas/novo")
    public String exibirFormularioCriatura(Model model) {
        model.addAttribute("criatura", new Criatura()); // Cria uma nova Criatura vazia para o formulário
        return "form_criatura"; // Retorna o template do formulário
    }

    @PostMapping("/criaturas/novo")
    public String salvarCriatura(@ModelAttribute Criatura criatura) {
        // Salva a criatura recebida do formulário no banco de dados
        criaturaRepository.save(criatura);
        return "redirect:/criaturas"; // Redireciona de volta para a lista de criaturas
    }
}