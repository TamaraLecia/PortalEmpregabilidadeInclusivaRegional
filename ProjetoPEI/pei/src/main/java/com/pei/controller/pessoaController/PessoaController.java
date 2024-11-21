package com.pei.controller.pessoaController;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PessoaController {

    
    
    @GetMapping("/login")
    public String login(){
        return "login/login";
    }
}
