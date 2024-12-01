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

import DAO.PessoaPCDDAO;
import model.PessoaPCD;

@WebServlet(urlPatterns = { "/LoginPCD", "/login","/verPerfil", "/select", "/update", "/logout", "/sair", "/logout2"})
public class LoginPCD extends HttpServlet {
	private static final long serialVersionUID = 1L;
	PessoaPCDDAO dao = new PessoaPCDDAO();
	PessoaPCD pessoas = new PessoaPCD();

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
		} else if(action.equals("/verPerfil")) {
			visualizarPerfilPessoaComDeficiencia(request, response);
		} else if(action.equals("/select")) {
			listarPerfil(request, response);
		} else if(action.equals("/update")) {
			editarPerfil(request, response);
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
		response.sendRedirect("login.jsp");

	}

	// Processando o login, pega pela sessão
	protected void realizarLogin(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getServletPath();
		System.out.println(action);
		String email = request.getParameter("email");
		String senha = request.getParameter("senha");

		PessoaPCDDAO pessoaDAO = new PessoaPCDDAO();
		boolean loginSucesso = pessoaDAO.autenticar(email, senha);

		if (loginSucesso) {
			HttpSession session = request.getSession();
			session.setAttribute("email", email);
			// redireciona para a tela inicial do usuário
			response.sendRedirect("telaInicioUsuario.jsp");
		} else {
			// retornar uma página de erro
			response.setContentType("text/html");
			response.getWriter().write("<html><body>");
			response.getWriter()
					.write("<script>alert('Email ou senha incorretos.'); window.location.href='login.jsp';</script>");
			response.getWriter().write("</body></html>");
		}
	}
	
	//EDITAR DADOS
	protected void listarPerfil(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//Recebimento do email do usuario que será   editado 
		String email = request.getParameter("email");
		//System.out.println("email con: "+ email);
		
		//setar a variavel PessoaPCD
		pessoas.setEmail(email);
		
		//executar o metodo selecionarDadosPessoa
		dao.selecionardadosPessoa(pessoas);
		
		//teste de recebimento
		/*
		System.out.println();
		System.out.println("Teste de recebimento PessoaPCD");
		System.out.println(pessoas.getEmail());
		System.out.println(pessoas.getAreaInteresse());
		System.out.println(pessoas.getGenero());
		System.out.println(pessoas.getDataNascimento());
		System.out.println(pessoas.getNacionalidade());
		System.out.println(pessoas.getEndereco());
		System.out.println(pessoas.getFormacaoAcademica());
		System.out.println(pessoas.getDeficiencia());
		System.out.println(pessoas.getDescricaoDeficiencia());
		System.out.println(pessoas.getId());
		*/
		
		//Setar os atributos do formulario com o conteudo PessoaPCD
		request.setAttribute("email", pessoas.getEmail());
		request.setAttribute("areaInteresse", pessoas.getAreaInteresse());
		request.setAttribute("genero", pessoas.getGenero());
		request.setAttribute("dataNascimento", pessoas.getDataNascimento());
		request.setAttribute("nacionalidade", pessoas.getNacionalidade());
		request.setAttribute("endereco", pessoas.getEndereco());
		request.setAttribute("formacaoAcademica", pessoas.getFormacaoAcademica());
		request.setAttribute("deficiencia", pessoas.getDeficiencia());
		request.setAttribute("descricaoDeficiencia", pessoas.getDescricaoDeficiencia());
		request.setAttribute("id", pessoas.getId());
		
		//Encaminhar para o documento editarPerfilUsuario.jsp
		RequestDispatcher rd = request.getRequestDispatcher("editarPerfilUsuario.jsp");
		rd.forward(request, response);
	}
	
	protected void editarPerfil(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//teste resececimento
		/*
		System.out.println();
		System.out.println("teste de recebimento no formulario");
		System.out.println(request.getParameter("email"));
		System.out.println(request.getParameter("areaInteresse"));
		System.out.println(request.getParameter("genero"));
		System.out.println(request.getParameter("dataNascimento"));
		System.out.println(request.getParameter("nacionalidade"));
		System.out.println(request.getParameter("endereco"));
		System.out.println(request.getParameter("formacaoAcademica"));
		System.out.println(request.getParameter("deficiencia"));
		System.out.println(request.getParameter("descricaoDeficiencia"));
		System.out.println(request.getParameter("id"));
		*/
		
		//setar as variaveis PessoaPCD
		pessoas.setEmail(request.getParameter("email"));
		pessoas.setAreaInteresse(request.getParameter("areaInteresse"));
		pessoas.setGenero(request.getParameter("genero"));
		pessoas.setDataNascimento(request.getParameter("dataNascimento"));
		pessoas.setNacionalidade(request.getParameter("nacionalidade"));
		pessoas.setEndereco(request.getParameter("endereco"));
		pessoas.setFormacaoAcademica(request.getParameter("formacaoAcademica"));
		pessoas.setDeficiencia(request.getParameter("deficiencia"));
		pessoas.setDescricaoDeficiencia(request.getParameter("descricaoDeficiencia"));
		pessoas.setId(Integer.parseInt(request.getParameter("id")));
		
		//executar o método alterar contato
		dao.alterarPerfil(pessoas);
		
		//redirecionar para o documento perfilUsuario.jsp (atualizando as alterações)
		response.sendRedirect("verPerfil");
	}
	
	
	
	
    // Visualizar perfil de usuário/ recebe o que foi pego na sessão de login
	protected void visualizarPerfilPessoaComDeficiencia(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//String email = request.getParameter("email");
		HttpSession session = request.getSession();
		String email = (String) session.getAttribute("email");
		System.out.println("valor de email: " + email);
		//Objeto que vai receber os dados da PessoaPCD
		ArrayList<PessoaPCD> lista = dao.listardados(email);
		//teste de recebimento da lista
		for(int i = 0; i < lista.size(); i++) {
			System.out.println(lista.get(i).getId());
			System.out.println(lista.get(i).getNome());
			//System.out.println(lista.get(i).getEmail());
			System.out.println(lista.get(i).getTelefone());
			System.out.println(lista.get(i).getEmail());
			System.out.println(lista.get(i).getSenha());
			System.out.println(lista.get(i).getDataNascimento());
			System.out.println(lista.get(i).getGenero());
			System.out.println(lista.get(i).getEndereco());
			System.out.println(lista.get(i).getNacionalidade());
			System.out.println(lista.get(i).getCpf());
			System.out.println(lista.get(i).getDeficiencia());
			System.out.println(lista.get(i).getFormacaoAcademica());
			System.out.println(lista.get(i).getDescricaoDeficiencia());
			System.out.println(lista.get(i).getAreaInteresse());
			System.out.println();
			
		}
		request.setAttribute("pessoaComDeficiencia", lista);
		RequestDispatcher rd = request.getRequestDispatcher("perfilUsuario.jsp");
		rd.forward(request, response);
	}
	
	//Realizando logout
	protected void realizarLogout(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession sessao = request.getSession();//pegar os dados do usuario que está logado na sessão
		String email = (String) sessao.getAttribute("email");
		ArrayList<PessoaPCD> lista2 = dao.listardados(email);
		
		sessao.invalidate();//metodo que realizar o logout na sessão
		
		RequestDispatcher rd = request.getRequestDispatcher("index.html");
		rd.forward(request, response);
	}
	
	protected void sair(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession sessao = request.getSession();//pegar os dados do usuario que está logado na sessão
		String email = (String) sessao.getAttribute("email");
		ArrayList<PessoaPCD> lista2 = dao.listardados(email);
		
		sessao.invalidate();//metodo que realizar o logout na sessão
		
		RequestDispatcher rd = request.getRequestDispatcher("index.html");
		rd.forward(request, response);
	}
	
	protected void voltarParaVerPerfil(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession sessao = request.getSession();//pegar os dados do usuario que está logado na sessão
		String email = (String) sessao.getAttribute("email");
		ArrayList<PessoaPCD> lista2 = dao.listardados(email);
		
		sessao.invalidate();//metodo que realizar o logout na sessão
		
		RequestDispatcher rd = request.getRequestDispatcher("index.html");
		rd.forward(request, response);
	}

}
