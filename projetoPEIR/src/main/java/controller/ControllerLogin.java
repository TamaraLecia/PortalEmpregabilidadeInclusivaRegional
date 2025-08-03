package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.AdmDao;
import dao.PessoaPCDDAO;
import model.PessoaPCD;

@WebServlet(urlPatterns = { "/ControllerLogin", "/login", "/logout", "/sair", "/logout2"})
public class ControllerLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	PessoaPCDDAO pessoaPCDdao = new PessoaPCDDAO();
	PessoaPCD pessoas = new PessoaPCD();
	AdmDao admDAO = new AdmDao();

	public ControllerLogin() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getServletPath();
		System.out.println(action);
		if (action.equals("/login")) {
			acessarLogin(request, response);
		} else if (action.equals("/ControllerLogin")) {
			realizarLogin(request, response);
		} else if(action.equals("/logout")) {
			realizarLogout(request, response);
		} else if(action.equals("/sair")) {
			sair(request, response);
		} else if(action.equals("/logout2")) {
			voltarParaVerPerfil(request, response);
		}

	}

	protected void acessarLogin(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getServletPath();
		System.out.println(action);
		response.sendRedirect("Login.jsp");

	}

	// Processando o login, pega pela sessão
		protected void realizarLogin(HttpServletRequest request, HttpServletResponse response)
				throws ServletException, IOException {
			String action = request.getServletPath();
			System.out.println(action);
			String email = request.getParameter("email");
			String senha = request.getParameter("senha");
			//String nivelAcesso = (String) request.getParameter("nivelAcesso");
			int nivelAcesso = pessoaPCDdao.pegarNivelAcesso(email, senha);
			System.out.println("acesso usuario: " + nivelAcesso);
			int idUsuario = pessoaPCDdao.pegarId(email);
			int nivelAcessoAdm = admDAO.pegarNivelAcesso(email, senha);
			System.out.println("Nivel acesso: " + nivelAcessoAdm);
			int idAdministrador = admDAO.pegarId(email);

			//PessoaPCDDAO dao = new PessoaPCDDAO();
			boolean loginSucesso = pessoaPCDdao.autenticar(email, senha);
			boolean loginSucessoAdm = admDAO.autenticar(email, senha);

			if (loginSucesso || loginSucessoAdm) {
				HttpSession session = request.getSession();
				session.setAttribute("email", email);
				if(nivelAcessoAdm == 1) {
					HttpSession sessao = request.getSession();
					sessao.setAttribute("idAdministrador", idAdministrador);
					// redireciona para a tela inicial do usuário
					response.sendRedirect("TelaInicioEmpresa.jsp");
				} else if(nivelAcesso == 2) {
					HttpSession sessao = request.getSession();
					sessao.setAttribute("idUsuario", idUsuario);
					// redireciona para a tela inicial do usuário
					response.sendRedirect("TelaInicioUsuario.jsp");
				}
			} else {
				// retornar uma página de erro
				response.setContentType("text/html");
				response.getWriter().write("<html><body>");
				response.getWriter()
						.write("<script>alert('Email ou senha incorretos.'); window.location.href='Login.jsp';</script>");
				response.getWriter().write("</body></html>");
			}
		}
	
	//Realizando logout
	protected void realizarLogout(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession sessao = request.getSession();//pegar os dados do usuario que está logado na sessão
		String email = (String) sessao.getAttribute("email");
		ArrayList<PessoaPCD> lista2 = pessoaPCDdao.listardados(email);
		
		sessao.invalidate();//metodo que realizar o logout na sessão
		
		RequestDispatcher rd = request.getRequestDispatcher("TelaPrincipal");
		rd.forward(request, response);
	}
	
	protected void sair(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession sessao = request.getSession();//pegar os dados do usuario que está logado na sessão
		String email = (String) sessao.getAttribute("email");
		ArrayList<PessoaPCD> lista2 = pessoaPCDdao.listardados(email);
		
		sessao.invalidate();//metodo que realizar o logout na sessão
		
		RequestDispatcher rd = request.getRequestDispatcher("TelaInicio.jsp");
		rd.forward(request, response);
	}
	
	protected void voltarParaVerPerfil(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession sessao = request.getSession();//pegar os dados do usuario que está logado na sessão
		String email = (String) sessao.getAttribute("email");
		ArrayList<PessoaPCD> lista2 = pessoaPCDdao.listardados(email);
		
		sessao.invalidate();//metodo que realizar o logout na sessão
		
		RequestDispatcher rd = request.getRequestDispatcher("TelaPrincipal");
		rd.forward(request, response);
	}

}