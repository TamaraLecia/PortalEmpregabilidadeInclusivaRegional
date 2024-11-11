package com.projeto_lpoo.pei.service;

import java.sql.SQLException;
import java.util.List;

import com.projeto_lpoo.pei.model.Candidatura;
import com.projeto_lpoo.pei.model.Experiencia;
import com.projeto_lpoo.pei.model.Formacao;
import com.projeto_lpoo.pei.model.PessoaComDeficiencia;
import com.projeto_lpoo.pei.repository.PessoaComDeficienciaRepository;

public class PessoaComDeficienciaService {
    private PessoaComDeficienciaRepository  pcdRepository = new PessoaComDeficienciaRepository();

    public void cadastrarPessoa(PessoaComDeficiencia usuario) throws SQLException {
        pcdRepository.save(usuario);
    }

    //Candidatura

    public void cadastrarCandidatura(Candidatura candidatura) throws SQLException {
        pcdRepository.saveCandidatura(candidatura);
    }

    public Candidatura buscarCandidaturaPorId(int id) throws SQLException {
        return pcdRepository.findCandidaturaById(id);
    }

    public List<Candidatura> listarTodasCandidaturas() throws SQLException {
        return pcdRepository.findAllCandidatura();
    }

    public void removerCandidatura(int id) throws SQLException {
        pcdRepository.deleteCandidatura(id);
    }
    
    //Experiencia

    public boolean adicionarExperienciaProfissional(Experiencia experiencia, PessoaComDeficienciaRepository pcdepository) {
        return pcdRepository.adicionarExperiencia(null, experiencia); 
    }

    //Formacao

    public boolean adicionarFormacaoAcademica(Formacao formacao, PessoaComDeficienciaRepository pcdepository) {
        return pcdRepository.adicionarFormacao(null, formacao); 
    }

}
