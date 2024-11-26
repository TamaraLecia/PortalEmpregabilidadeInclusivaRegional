package com.pei.pei.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.pei.pei.model.Pessoa;
import com.pei.pei.repository.PessoaRepository;

import jakarta.validation.Valid;


@Controller
public class CadastroControler {
    @Autowired
    private PessoaRepository pessoaRepository;
    
    @GetMapping("/CriarContaUsuario")
    public String criarContaUsuario() {
        return "CriarContaUsuario";
    }
    
    @RequestMapping(value = "/CriarContaUsuario", method=RequestMethod.POST)
    public String cadastroPrimario(@Valid Pessoa pessoa, BindingResult result) {
        if(result.hasErrors()){
            return "redirect:/CriarContaUsuario";
        }

        pessoaRepository.save(pessoa);

        return "redirect:/Login";
    }
}
