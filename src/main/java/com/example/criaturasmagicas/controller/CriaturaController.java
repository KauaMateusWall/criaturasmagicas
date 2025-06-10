package com.example.criaturasmagicas.controller;

import com.example.criaturasmagicas.model.Criatura;
import com.example.criaturasmagicas.repository.CriaturaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable; 


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
        model.addAttribute("criatura", new Criatura());
        return "form_criatura";
    }

    @PostMapping("/criaturas/novo")
    public String salvarCriatura(@ModelAttribute Criatura criatura) {
        criaturaRepository.save(criatura);
        return "redirect:/criaturas";
    }

    // Novo método para exibir o formulário de edição
    @GetMapping("/criaturas/editar/{id}")
    public String exibirFormularioEdicao(@PathVariable Long id, Model model) {
        Criatura criatura = criaturaRepository.findById(id)
                                .orElseThrow(() -> new IllegalArgumentException("ID da criatura inválido:" + id));
        model.addAttribute("criatura", criatura);
        return "form_criatura"; // Reutiliza o mesmo formulário para edição
    }

    // Novo método para salvar as alterações de uma criatura existente
    @PostMapping("/criaturas/editar")
    public String atualizarCriatura(@ModelAttribute Criatura criatura) {
        criaturaRepository.save(criatura);
        return "redirect:/criaturas";
    }

    // Novo método para excluir uma criatura
    @GetMapping("/criaturas/excluir/{id}")
    public String excluirCriatura(@PathVariable Long id) {
        criaturaRepository.deleteById(id);
        return "redirect:/criaturas";
    }
}