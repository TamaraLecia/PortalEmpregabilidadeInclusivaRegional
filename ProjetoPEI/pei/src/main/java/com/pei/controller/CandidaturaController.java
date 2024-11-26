package com.pei.controller;

import java.sql.SQLException;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.server.ResponseStatusException;

import com.pei.pei.dao.CandidaturaDAO;

@Controller
public class CandidaturaController {
    private final CandidaturaDAO candidaturaDAO;
    
    public CandidaturaController(CandidaturaDAO candidaturaDAO){
        this.candidaturaDAO = candidaturaDAO;
    }

    //Endpoint para o usuário candidatar a vagas
    @PostMapping("/candidatar")
    public String candidatar(@RequestParam int idPessoa, @RequestParam int idVaga) {
        try {
            boolean sucesso = candidaturaDAO.cadastrarCandidatura(idPessoa, idVaga);
            return sucesso ? "Candidatura realizada com sucesso!" : "Erro ao realizar candidatura.";
        } catch (SQLException e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Erro ao se candidatar", e);
        }
    }

    
}
