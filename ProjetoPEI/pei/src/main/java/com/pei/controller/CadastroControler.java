package com.pei.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.pei.model.Pessoa;
import com.pei.repository.PessoaRepository;

import jakarta.validation.Valid;

@CrossOrigin("*")
@RestController
public class CadastroControler {
    @Autowired
    private PessoaRepository pessoaRepository;
    
    @GetMapping("/criarContaUsuario")
    public String criarContaUsuario() {
        return "criarContaUsuario";
    }
    
    @RequestMapping(value = "/criarContaUsuario", method=RequestMethod.POST)
    public String cadastroPrimario(@Valid Pessoa pessoa, BindingResult result) {
        if(result.hasErrors()){
            return "redirect:/criarContaUsuario";
        }

        pessoaRepository.save(pessoa);

        return "redirect:/Login";
    }
}
