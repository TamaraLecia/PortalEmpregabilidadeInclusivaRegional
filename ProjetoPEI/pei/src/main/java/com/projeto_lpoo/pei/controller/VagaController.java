package com.projeto_lpoo.pei.controller;

import java.sql.SQLException;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.projeto_lpoo.pei.model.Vaga;
import com.projeto_lpoo.pei.service.VagaService;

@RestController
@RequestMapping("/vagas")
public class VagaController {
    private VagaService vagaService = new VagaService();

    @PostMapping
    public void cadastrarVaga(@RequestBody Vaga vaga) throws SQLException {
        vagaService.cadastrarVaga(vaga);
    }

    @GetMapping("/{id}")
    public Vaga buscarVaga(@PathVariable int id) throws SQLException {
        return vagaService.buscarVagaPorId(id);
    }

    @GetMapping
    public List<Vaga> listarVagas() throws SQLException {
        return vagaService.listarTodasVagas();
    }
}
