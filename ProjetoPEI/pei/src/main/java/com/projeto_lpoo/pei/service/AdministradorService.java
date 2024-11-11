package com.projeto_lpoo.pei.service;

import java.util.List;

import com.projeto_lpoo.pei.model.Capacitacao;
import com.projeto_lpoo.pei.model.PessoaComDeficiencia;
import com.projeto_lpoo.pei.model.Vaga;
import com.projeto_lpoo.pei.repository.AdministradorRepository;

public class AdministradorService {
    private AdministradorRepository administradorRepository;

    public AdministradorService(AdministradorRepository administradorRepository) {
        this.administradorRepository = administradorRepository;
    }

    // Métodos para gerenciar vagas

    public void publicarVaga(Vaga vaga) {
        administradorRepository.adicionarVaga(vaga);
    }

    public void removerVaga(int idVaga) {
        administradorRepository.removerVaga(idVaga);
    }

    public List<Vaga> visualizarVagas() {
        return administradorRepository.listarVagas();
    }

    public void atualizarVaga(Vaga vaga) {
        administradorRepository.atualizarVaga(vaga);
    }

    // Métodos para gerenciar candidatos

    public List<PessoaComDeficiencia> visualizarCandidatos() {
        return administradorRepository.listarCandidatos();
    }

    public void contratarCandidato(PessoaComDeficiencia pessoaComDeficiencia) {
        administradorRepository.contratarCandidato(pessoaComDeficiencia);
    }

    // Métodos para gerenciar capacitações

    public void adicionarCapacitacao(PessoaComDeficiencia pessoaComDeficiencia, Capacitacao capacitacao) {
        administradorRepository.adicionarCapacitacao(pessoaComDeficiencia, capacitacao);
    }

    public void atualizarCapacitacao(PessoaComDeficiencia pessoaComDeficiencia, Capacitacao capacitacao) {
        administradorRepository.atualizarCapacitacao(pessoaComDeficiencia, capacitacao);
    }

    public List<Capacitacao> visualizarCapacitacoes(PessoaComDeficiencia pessoaComDeficiencia) {
        return administradorRepository.visualizarCapacitacoes(pessoaComDeficiencia);
    }
}
