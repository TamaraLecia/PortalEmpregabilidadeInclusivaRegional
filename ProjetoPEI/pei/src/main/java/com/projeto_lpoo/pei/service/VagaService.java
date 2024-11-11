package com.projeto_lpoo.pei.service;

import java.sql.SQLException;
import java.util.List;

import com.projeto_lpoo.pei.model.Vaga;
import com.projeto_lpoo.pei.repository.VagaRepository;

public class VagaService {
    private VagaRepository vagaRepository = new VagaRepository();

    public void cadastrarVaga(Vaga vaga) throws SQLException {
        vagaRepository.save(vaga);
    }

    public Vaga buscarVagaPorId(int id) throws SQLException {
        return vagaRepository.findById(id);
    }

    public List<Vaga> listarTodasVagas() throws SQLException {
        return vagaRepository.findAll();
    }

    public void removerVaga(int id) throws SQLException {
        vagaRepository.delete(id);
    }
}
