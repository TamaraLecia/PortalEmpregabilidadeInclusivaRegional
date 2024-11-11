package com.projeto_lpoo.pei.controller;


import java.sql.SQLException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.projeto_lpoo.pei.model.Experiencia;
import com.projeto_lpoo.pei.model.Formacao;
import com.projeto_lpoo.pei.model.PessoaComDeficiencia;
import com.projeto_lpoo.pei.repository.PessoaComDeficienciaRepository;
import com.projeto_lpoo.pei.service.PessoaComDeficienciaService;

@RestController
@RequestMapping("/pessoaComDeficiencia")
public class PessoaComDeficienciaController {

    private PessoaComDeficienciaRepository pcdRepository = new PessoaComDeficienciaRepository();
    private PessoaComDeficienciaService pcdService = new PessoaComDeficienciaService();

    //Cadastro
    
    @PostMapping
    public void cadastrarPessoa(@RequestBody PessoaComDeficiencia usuario) throws SQLException {
        pcdService.cadastrarPessoa(usuario);
    }

    //Experiencia

    @PostMapping("/{idCandidato}/adicionar")
    public ResponseEntity<String> adicionarExperiencia(@PathVariable int idCandidato, 
                                                       @RequestBody Experiencia experiencia) throws SQLException {
        PessoaComDeficiencia candidato =  (PessoaComDeficiencia) pcdRepository.findById(idCandidato);

        if (candidato != null) {
            candidato.adicionarExperiencia(idCandidato, experiencia);
            return new ResponseEntity<>("Experiência profissional adicionada com sucesso!", HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>("Candidato não encontrado.", HttpStatus.NOT_FOUND);
        }
    }

    //formacao

    @PostMapping("/{idCandidato}/adicionar")
    public ResponseEntity<String> adicionarFormacao(@PathVariable int idCandidato, 
                                                       @RequestBody Formacao formacao) throws SQLException {
        PessoaComDeficiencia candidato =  (PessoaComDeficiencia) pcdRepository.findById(idCandidato);

        if (candidato != null) {
            candidato.adicionarFormacao(idCandidato, formacao);
            return new ResponseEntity<>("Experiência profissional adicionada com sucesso!", HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>("Candidato não encontrado.", HttpStatus.NOT_FOUND);
        }
    }



}
