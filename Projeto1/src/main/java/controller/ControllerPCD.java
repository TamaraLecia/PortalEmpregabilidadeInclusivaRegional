package controller;

import java.io.IOException;
import java.sql.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.PessoaPCDDAO;
import model.Pessoa;
import model.PessoaPCD;

/**
 * Servlet implementation class Controller
 */
@WebServlet(urlPatterns = { "/ControllerPCD", "/main", "/concluido", "/insert", "/pessoaF", "/principal" })
public class ControllerPCD extends HttpServlet {
	private static final long serialVersionUID = 1L;
	PessoaPCDDAO dao = new PessoaPCDDAO();
	PessoaPCD pessoa = new PessoaPCD();

	public ControllerPCD() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// response.getWriter().append("Served at: ").append(request.getContextPath());
		String action = request.getServletPath();
		System.out.println(action);
		if (action.equals("/principal")) {
			pessoas(request, response);
		} else if (action.equals("/pessoaF")) {
			pessoasf(request, response);
		} else if (action.equals("/insert")) {
			novoUsuario(request, response);
			cadastroFeito(request, response);
		}
	}

	// teste de conexao
	// dao.testeConexao();

	// Escolher perfil
	protected void pessoas(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.sendRedirect("TipoUsuario.html");
	}

	// entrando no formulario da pessoa fisica
	protected void pessoasf(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("Redirecionando para cadastroUsuario.html");
		response.sendRedirect("CadastroUsuario.html");
	}

	// apos o cadastro da pessoa com fisica
	protected void cadastroFeito(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.sendRedirect("TelaInicioUsuario.jsp");
	}

	// novoUsuario Cadastro de usuário
	protected void novoUsuario(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// (cadastro primario)
		// teste de recebimento do formulario
		System.out.println(request.getParameter("nome"));
		System.out.println(request.getParameter("telefone"));
		System.out.println(request.getParameter("email"));
		System.out.println(request.getParameter("senha"));
		System.out.println(request.getParameter("interesse"));
		System.out.println(request.getParameter("genero"));
		System.out.println(request.getParameter("dataNascimento"));
		System.out.println(request.getParameter("nacionalidade"));
		System.out.println(request.getParameter("endereco"));
		System.out.println(request.getParameter("formacao"));
		System.out.println(request.getParameter("cpf"));
		System.out.println(request.getParameter("deficiencia"));
		System.out.println(request.getParameter("descricao"));
		//System.out.println(request.getParameter("nivelAcesso"));
		// Recebendo os dados para o banco
		/*
		String nome = request.getParameter("nome");
		String telefone = request.getParameter("telefone");
		String email = request.getParameter("email");
		String senha = request.getParameter("senha");
		String interesse = request.getParameter("interesse");
		String genero = request.getParameter("genero");
		String dataNascimento = request.getParameter("dataNascimento");
		String nacionalidade = request.getParameter("nacionalidade");
		String endereco = request.getParameter("endereco");
		String formacao = request.getParameter("formacao");
		String cpf = request.getParameter("cpf");
		String deficiencia = request.getParameter("deficiencia");
		String descricao = request.getParameter("descricao");
		

		// Criar um novo objeto Administrador com os valores recebidos
		PessoaPCD pessoa = new PessoaPCD(0, nome, telefone, email, senha, dataNascimento, genero, endereco,
				nacionalidade, cpf, deficiencia, formacao, descricao, interesse, 2);
		*/
		pessoa.setNome(request.getParameter("nome"));
		pessoa.setTelefone(request.getParameter("telefone"));
		pessoa.setEmail(request.getParameter("email"));
		pessoa.setSenha(request.getParameter("senha"));
		pessoa.setAreaInteresse(request.getParameter("interesse"));
		pessoa.setGenero(request.getParameter("genero"));
		pessoa.setDataNascimento(request.getParameter("dataNascimento"));
		pessoa.setNacionalidade(request.getParameter("nacionalidade"));
		pessoa.setEndereco(request.getParameter("endereco"));
		pessoa.setFormacaoAcademica(request.getParameter("formacao"));
		pessoa.setCpf(request.getParameter("cpf"));
		pessoa.setDeficiencia(request.getParameter("deficiencia"));
		pessoa.setDescricaoDeficiencia(request.getParameter("descricao"));
		pessoa.setNivelAcesso(2);
		
		// Redirecionar
		//response.sendRedirect("cadastroUsuario.html");
		
		// Invocar o método inserir administrador passando o objeto adm
		dao.inserirpessoa(pessoa);
		request.getSession().setAttribute("nivelAcesso", pessoa.getNivelAcesso());
	}


}