package com.example.criaturasmagicas.controller;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HelloController {

    @GetMapping("/hello")
    public String hello(Model model) {
        model.addAttribute("mensagem", "Bem-vindo ao mundo mágico!");
        return "hello"; // View hello.html será buscada em templates/
    }
}
