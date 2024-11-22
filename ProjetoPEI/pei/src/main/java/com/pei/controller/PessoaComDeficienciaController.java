package com.pei.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.pei.dao.AdministradorDAO;
import com.pei.dao.PessoaComDeficienciaDAO;
import com.pei.models.Capacitacao;
import com.pei.models.Pessoa;
import com.pei.models.PessoaComDeficiencia;
import com.pei.models.Vaga;
import com.pei.service.CandidaturaService;

@RestController
@CrossOrigin("*")//libera todas as entradas que vier da maquina
@RequestMapping("/pessoas-com-deficiencia")
public class PessoaComDeficienciaController {

    private final PessoaComDeficienciaDAO pessoaComDeficienciaDAO;

    @Autowired
    public PessoaComDeficienciaController(Connection connection) {
        this.pessoaComDeficienciaDAO = new PessoaComDeficienciaDAO(connection);
    }
    // Endpoint para o cadastro primario
    @PostMapping("/CadastroPrimario")
    public String cadastroPrimario(@RequestBody Pessoa pessoa) {
        try {
            boolean cadastrado = pessoaComDeficienciaDAO.cadastroPrimario(pessoa);
            return cadastrado ? "Cadastro realizado com sucesso!" : "Erro ao realizar cadastro.";
        } catch (SQLException e) {
            return "Erro: " + e.getMessage();
        }
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
                session.setAttribute("usuarioLogado", pessoa);
                return pessoa;
            } else {
                return "Credenciais inválidas!";
            }
        } catch (SQLException e) {
            return "Erro: " + e.getMessage();
        }
    }

    // Endpoint para visualizar perfil
    @GetMapping("/{id}")
    public ResponseEntity<PessoaComDeficiencia> visualizarPerfil(@PathVariable int id) {
        PessoaComDeficiencia pessoa = pessoaComDeficienciaDAO.visualizarPerfil(id);
        if (pessoa != null) {
            return ResponseEntity.ok(pessoa);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
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
                    break;

                }
            }else{
                System.out.println("Vaga não encontrada");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //Endpoint para remover Formação
    @PostMapping("/removerFormacao")
    public void removerFormacao(@RequestParam Integer id){
        pessoaComDeficienciaDAO.removerFormacao(id);
    }

    //Endpoint para remover Experiência
   @PostMapping("/removerExperiência")
   public void removerExperiencia(@RequestParam Integer id){
       pessoaComDeficienciaDAO.removerExperiencia(id);
       System.out.println("Experiencia removida");
   }

   //Endpoint para cancelar candidatura
   @PostMapping("/cancelarCandidatura")
   public void cancelarCandidatura(@RequestParam boolean status){
        CandidaturaService candidaturaService = new CandidaturaService();

        candidaturaService.cancelarCandidatura(status);
   }

   //Endpoint para editar dados do usuário
    @WebServlet(name = "editarUsuario", urlPatterns = {"/editarUsuario"})
    public class alterarCapacitacao extends HttpServlet {
        protected void alterar(HttpServletRequest requisicao, HttpServletResponse resposta) throws ServletException, IOException{
            resposta.setContentType("text/html;charset=UTF8-8");
            try(PrintWriter out = resposta.getWriter()){

                String nome = requisicao.getParameter("txtNome");
                String dataNascimento = requisicao.getParameter("txtDataNascimento");
                String cpf = requisicao.getParameter("txtCpf");
                String genero = requisicao.getParameter("txtGenero");
                String endereco = requisicao.getParameter("txtEndereco");
                String nacionalidade = requisicao.getParameter("txtNacionalidade");
                String deficiencia = requisicao.getParameter("txtDeficiencia");
                String interesse = requisicao.getParameter("txtInteresse");
                String formacao = requisicao.getParameter("txtFormacao");
                String descricao = requisicao.getParameter("txtFormacao");

                PessoaComDeficiencia pessoaComDeficiencia = new PessoaComDeficiencia(0, dataNascimento, null, cpf, genero, endereco, nacionalidade, deficiencia, interesse, formacao, descricao);

                pessoaComDeficiencia.setNome(nome);
                pessoaComDeficiencia.setDataNascimento(new Date(pessoaComDeficiencia.getDataNascimento().getTime()));
                pessoaComDeficiencia.setCpf(cpf);
                pessoaComDeficiencia.setGenero(genero);
                pessoaComDeficiencia.setEndereco(endereco);
                pessoaComDeficiencia.setNacionalidade(nacionalidade);
                pessoaComDeficiencia.setDeficiencia(deficiencia);
                pessoaComDeficiencia.setInteresse(interesse);
                pessoaComDeficiencia.setFormacao(formacao);
                pessoaComDeficiencia.setDescricao(descricao);

                PessoaComDeficienciaDAO pessoaComDeficienciaDAO = new PessoaComDeficienciaDAO(null);
                pessoaComDeficienciaDAO.alterarPessoaComDeficiencia(pessoaComDeficiencia);


            }
        }
        
    }

}
