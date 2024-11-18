package com.pei.controller;

import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.pei.dao.PessoaComDeficienciaDAO;
import com.pei.models.PessoaComDeficiencia;

@RestController
@RequestMapping("/pessoas-com-deficiencia")
public class PessoaComDeficienciaController {

    private final PessoaComDeficienciaDAO pessoaComDeficienciaDAO;

    @Autowired
    public PessoaComDeficienciaController(Connection connection) {
        this.pessoaComDeficienciaDAO = new PessoaComDeficienciaDAO(connection);
    }

    // Endpoint para cadastrar uma nova pessoa com deficiência
    @PostMapping("/cadastrar")
    public String cadastrar(@RequestBody PessoaComDeficiencia pessoa) {
        try {
            boolean cadastrado = pessoaComDeficienciaDAO.cadastrar(pessoa);
            return cadastrado ? "Cadastro realizado com sucesso!" : "Erro ao realizar cadastro.";
        } catch (SQLException e) {
            return "Erro: " + e.getMessage();
        }
    }

    // Endpoint para realizar login
    @PostMapping("/login")
    public Object login(@RequestParam String email, @RequestParam String senha, HttpSession session) {
        try {
            PessoaComDeficiencia pessoa = pessoaComDeficienciaDAO.login(email, senha);
            if (pessoa != null) {
                // Salva o usuário na sessão
                session.setAttribute("usuarioLogado", pessoa);
                return pessoa; // Retorna os dados da pessoa logada
            } else {
                return "Credenciais inválidas!";
            }
        } catch (SQLException e) {
            return "Erro: " + e.getMessage();
        }
    }
}
