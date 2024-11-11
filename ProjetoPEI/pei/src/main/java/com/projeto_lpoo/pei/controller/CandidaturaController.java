package com.projeto_lpoo.pei.controller;

import java.sql.SQLException;
import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.projeto_lpoo.pei.model.Candidatura;
import com.projeto_lpoo.pei.service.PessoaComDeficienciaService;

@RestController
@RequestMapping("/candidaturas")
public class CandidaturaController {
    private PessoaComDeficienciaService candidaturaService = new PessoaComDeficienciaService();

    @PostMapping
    public void cadastrarCandidatura(@RequestBody Candidatura candidatura) throws SQLException {
        candidaturaService.cadastrarCandidatura(candidatura);
    }

    @GetMapping("/{id}")
    public Candidatura buscarCandidatura(@PathVariable int id) throws SQLException {
        return candidaturaService.buscarCandidaturaPorId(id);
    }

    @GetMapping
    public List<Candidatura> listarCandidaturas() throws SQLException {
        return candidaturaService.listarTodasCandidaturas();
    }

    @DeleteMapping("/{id}")
    public void removerCandidatura(@PathVariable int id) throws SQLException {
        candidaturaService.removerCandidatura(id);
    }
}
