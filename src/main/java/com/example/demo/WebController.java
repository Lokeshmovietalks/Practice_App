package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WebController {

    @GetMapping({"/", "/index"})
    public String index(Model model) {
        // Colors are editable in the template or static CSS file
        model.addAttribute("greeting", "Hi Lokesh Welcome to Kubernetes");
        return "index";
    }
}
