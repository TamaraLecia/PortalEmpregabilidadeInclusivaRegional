package com.pei.controller;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.pei.dao.PessoaComDeficienciaDAO;
import com.pei.models.PessoaComDeficiencia;
import com.pei.models.Vaga;

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

        //Endpoint para realizar o logout
    @WebServlet(name = "Logout", urlPatterns = {"/Logout"})
    public class Logout extends HttpServlet {
        public void  realizarLougout(HttpServletRequest requisicao, HttpServletResponse resposta) {
            try {
                HttpSession sessao = requisicao.getSession(); //pegando referencia da sessão para realizar logout
                sessao.invalidate(); //apagando a sessão do usuario

                //Leva o usuario para a pagina inicial
                RequestDispatcher redireciona = requisicao.getRequestDispatcher("index.html");
                redireciona.forward(requisicao, resposta);
            } catch (Exception e) {
                System.out.println(e);
            }
        }

    }

    //Endpoint para buscar vaga
    @PostMapping("/bucarVaga")
    public void buscarVaga(@RequestParam String titulo, String localizacao){
        try {
            List<Vaga> vagas = pessoaComDeficienciaDAO.bucarVaga(titulo, localizacao);
            if(vagas != null){
                for(Vaga vaga : pessoaComDeficienciaDAO.bucarVaga(titulo, localizacao)){
                    System.out.println("Titulo: " + vaga.getTitulo());
                    System.out.println("Requisitos: " + vaga.getRequisitos());
                    System.out.println("Localização: " + vaga.getLocalizacao());
                    System.out.println("Acessibilidade: " + vaga.getAcessibilidade());
                    System.out.println("Empresa: " + vaga.getEmpresa());
                    System.out.println("Beneficios: " + vaga.getBeneficios());
                    System.out.println("Salário: " + vaga.getSalario());
                    System.out.println();
                    System.out.println();
                    System.out.println();

                }
            }
        } catch (Exception e) {
            System.out.println("Vaga não encontrada");
        }
    }
}
