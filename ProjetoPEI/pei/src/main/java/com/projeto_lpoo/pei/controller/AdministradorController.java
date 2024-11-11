package com.projeto_lpoo.pei.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.projeto_lpoo.pei.model.Capacitacao;
import com.projeto_lpoo.pei.model.PessoaComDeficiencia;
import com.projeto_lpoo.pei.model.Vaga;
import com.projeto_lpoo.pei.repository.AdministradorRepository;

@RestController
@RequestMapping("/vagas")
public class AdministradorController {

    private final AdministradorRepository administradorRepository;

    @Autowired
    public  AdministradorController(AdministradorRepository administradorRepository) {
        this.administradorRepository = administradorRepository;
    }

    @PostMapping
    public ResponseEntity<String> adicionarVaga(@RequestBody Vaga vaga) {
        administradorRepository.adicionarVaga(vaga);
        return new ResponseEntity<>("Vaga adicionada com sucesso!", HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Vaga>> listarVagas() {
        List<Vaga> vagas = administradorRepository.listarVagas();
        return new ResponseEntity<>(vagas, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Vaga> buscarVaga(@PathVariable int id) {
        List<Vaga> vagas = administradorRepository.listarVagas();
        Vaga vaga = vagas.stream().filter(v -> v.getIdVaga() == id).findFirst().orElse(null);
        
        if (vaga != null) {
            return new ResponseEntity<>(vaga, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> atualizarVaga(@PathVariable int id, @RequestBody Vaga vagaAtualizada) {
        vagaAtualizada.setIdVaga(id);
        boolean isUpdated = administradorRepository.atualizarVaga(vagaAtualizada);

        if (isUpdated) {
            return new ResponseEntity<>("Vaga atualizada com sucesso!", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Erro ao atualizar a vaga.", HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> removerVaga(@PathVariable int id) {
        administradorRepository.removerVaga(id);
        return new ResponseEntity<>("Vaga removida com sucesso!", HttpStatus.OK);
    }

    //Candidatos

    // Listar todos os candidatos com deficiência
    @GetMapping
    public ResponseEntity<List<PessoaComDeficiencia>> listarCandidatos() {
        List<PessoaComDeficiencia> candidatos = administradorRepository.listarCandidatos();
        return new ResponseEntity<>(candidatos, HttpStatus.OK);
    }

    // Buscar candidato pelo nome
    @GetMapping("/buscar")
    public ResponseEntity<PessoaComDeficiencia> buscarCandidatoPeloNome(@RequestParam String nome) {
        PessoaComDeficiencia candidato = administradorRepository.buscarCandidatoPeloNome(nome);
        
        if (candidato != null) {
            return new ResponseEntity<>(candidato, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Contratar um candidato
    @PostMapping("/contratar")
    public ResponseEntity<String> contratarCandidato(@RequestBody PessoaComDeficiencia pessoaComDeficiencia) {
        boolean contratado = administradorRepository.contratarCandidato(pessoaComDeficiencia);

        if (contratado) {
            return new ResponseEntity<>("Candidato contratado com sucesso!", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Erro ao contratar candidato.", HttpStatus.BAD_REQUEST);
        }
    }

    //Capacitação

    @PostMapping("/adicionarCapacitacao")
    public ResponseEntity<String> adicionarCapacitacao(
            @RequestParam String nome, 
            @RequestBody Capacitacao capacitacao) {
        
        PessoaComDeficiencia candidato = administradorRepository.buscarCandidatoPeloNome(nome);
        if (candidato != null) {
            boolean adicionada = administradorRepository.adicionarCapacitacao(candidato, capacitacao);
            if (adicionada) {
                return new ResponseEntity<>("Capacitação adicionada com sucesso!", HttpStatus.CREATED);
            } else {
                return new ResponseEntity<>("Erro ao adicionar capacitação.", HttpStatus.BAD_REQUEST);
            }
        } else {
            return new ResponseEntity<>("Candidato não encontrado.", HttpStatus.NOT_FOUND);
        }
    }


    @PutMapping("/atualizarCapacitacao")
    public ResponseEntity<String> atualizarCapacitacao(
            @RequestParam String nome, 
            @RequestBody Capacitacao capacitacaoAtualizada) {
        
        PessoaComDeficiencia candidato = administradorRepository.buscarCandidatoPeloNome(nome);
        if (candidato != null) {
            boolean atualizada = administradorRepository.atualizarCapacitacao(candidato, capacitacaoAtualizada);
            if (atualizada) {
                return new ResponseEntity<>("Capacitação atualizada com sucesso!", HttpStatus.OK);
            } else {
                return new ResponseEntity<>("Erro ao atualizar capacitação.", HttpStatus.BAD_REQUEST);
            }
        } else {
            return new ResponseEntity<>("Candidato não encontrado.", HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/listarCapacitacoes")
    public ResponseEntity<List<Capacitacao>> listarCapacitacoes(@RequestParam String nome) {
        PessoaComDeficiencia candidato = administradorRepository.buscarCandidatoPeloNome(nome);
        if (candidato != null) {
            List<Capacitacao> capacitacoes = administradorRepository.visualizarCapacitacoes(candidato);
            return new ResponseEntity<>(capacitacoes, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}