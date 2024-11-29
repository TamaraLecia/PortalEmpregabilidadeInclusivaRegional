package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.PessoaPCDDAO;
import model.PessoaPCD;

@WebServlet(urlPatterns = { "/LoginPCD", "/login",})
public class LoginPCD extends HttpServlet {
	private static final long serialVersionUID = 1L;
	PessoaPCDDAO dao = new PessoaPCDDAO();
	PessoaPCD pessoa = new PessoaPCD();

	public LoginPCD() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getServletPath();
		System.out.println(action);
		if (action.equals("/login")) {
			acessarLogin(request, response);
		} else if (action.equals("/LoginPCD")) {
			realizarLogin(request, response);
		}

	}

	protected void acessarLogin(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getServletPath();
		System.out.println(action);
		response.sendRedirect("login.jsp");

	}

	// Processando o login
	protected void realizarLogin(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getServletPath();
		System.out.println(action);
		String email = request.getParameter("email");
		String senha = request.getParameter("senha");

		PessoaPCDDAO pessoaDAO = new PessoaPCDDAO();
		boolean loginSucesso = pessoaDAO.autenticar(email, senha);

		if (loginSucesso) {
			// redireciona para a tela inicial do usuário
			response.sendRedirect("telaInicioUsuario.html");
		} else {
			// retornar uma página de erro
			response.setContentType("text/html");
			response.getWriter().write("<html><body>");
			response.getWriter()
					.write("<script>alert('Email ou senha incorretos.'); window.location.href='login.jsp';</script>");
			response.getWriter().write("</body></html>");
		}
	}

	// Editar perfil do usuário
	protected void editarPerfilUsuario(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id")); // Recupera o ID do usuário
		PessoaPCD pessoaComDeficiencia = new PessoaPCD();

		pessoaComDeficiencia.setId(id);
		pessoaComDeficiencia.setAreaInteresse(request.getParameter("area-interesse"));
		pessoaComDeficiencia.setGenero(request.getParameter("genero"));
		pessoaComDeficiencia.setDataNascimento(request.getParameter("data-nascimento")); // Converte a data para o
																							// formato correto
		pessoaComDeficiencia.setNacionalidade(request.getParameter("nacionalidade"));
		pessoaComDeficiencia.setEndereco(request.getParameter("endereco"));
		pessoaComDeficiencia.setFormacaoAcademica(request.getParameter("formacao-academica"));
		pessoaComDeficiencia.setDeficiencia(request.getParameter("deficiencia"));
		pessoaComDeficiencia.setDescricaoDeficiencia(request.getParameter("descricao-deficiencia"));

		PessoaPCDDAO dao = new PessoaPCDDAO();
		dao.atualizar(pessoaComDeficiencia);

		response.sendRedirect("PerfilUsuario?id=" + id);
	}

}
