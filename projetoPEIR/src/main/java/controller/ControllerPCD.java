package controller;

import java.io.IOException;
import java.sql.Date;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.PessoaPCDDAO;
import model.Empresa;
import model.Pessoa;
import model.PessoaPCD;

/**
 * Servlet implementation class Controller
 */
@WebServlet(urlPatterns = { "/ControllerPCD", "/main", "/concluido", "/insert", "/pessoaF", "/principal", "/PerfilUsuario", "/selecionarPerfil", "/update"})
public class ControllerPCD extends HttpServlet {
	private static final long serialVersionUID = 1L;
	PessoaPCDDAO pessoaPCDDao = new PessoaPCDDAO();
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
		} else if(action.equals("/PerfilUsuario")) {
			listarUsuario(request,response);
		} else if(action.equals("/selecionarPerfil")) {
			selecionarPessoa(request, response);
		} else if(action.equals("/update")) {
			atualizarDados(request, response);
		}
	}

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
		
		// Invocar o método inserir PessoaPCD passando o objeto pessoa
		 pessoaPCDDao.inserirpessoa(pessoa);
		 request.getSession().setAttribute("nivelAcesso", pessoa.getNivelAcesso());
	}
	
	//ver perfil 04
		protected void listarUsuario(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			HttpSession session = request.getSession();
			Integer idUsuario = (Integer) session.getAttribute("idUsuario");
			System.out.println("idUsuario: " + idUsuario);
			ArrayList<PessoaPCD> lista = pessoaPCDDao.mostrarDados(idUsuario);
			for(int i=0; i < lista.size(); i++) {
				System.out.println(lista.get(i).getAreaInteresse());
				System.out.println(lista.get(i).getGenero());
				System.out.println(lista.get(i).getDataNascimento());
				System.out.println(lista.get(i).getNacionalidade());
				System.out.println(lista.get(i).getEndereco());
				System.out.println(lista.get(i).getFormacaoAcademica());
				System.out.println(lista.get(i).getDeficiencia());
				System.out.println(lista.get(i).getDescricaoDeficiencia());
			}
			request.setAttribute("mostrarPerfil", lista);
			RequestDispatcher rd = request.getRequestDispatcher("PerfilUsuario.jsp");
			rd.forward(request, response);
		}
		
		//método para selecionar uma pessoaPCD
				protected void selecionarPessoa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//					String idUser = request.getParameter("id");
//					
//					if(idUser == null || idUser.isEmpty()) {
//						response.sendRedirect("TelaInicio.jsp");
//						return;
//					}
					
					HttpSession session = request.getSession();
					Integer idUsuario = (Integer) session.getAttribute("idUsuario");

					if (idUsuario == null) {
					    response.sendRedirect("Erro.jsp");
					    return;
					}


					    ArrayList<PessoaPCD> lista = pessoaPCDDao.mostrarDados(idUsuario);
					    for (PessoaPCD pessoa : lista) {
					    	System.out.println("ID da pessoa carregada: " + pessoa.getId());
					        System.out.println(pessoa.getAreaInteresse());
					        System.out.println(pessoa.getGenero());
					        System.out.println(pessoa.getDataNascimento());
					        System.out.println(pessoa.getNacionalidade());
					        System.out.println(pessoa.getEndereco());
					        System.out.println(pessoa.getFormacaoAcademica());
					        System.out.println(pessoa.getDeficiencia());
					        System.out.println(pessoa.getDescricaoDeficiencia());
					    }

					    request.setAttribute("mostrarPerfil", lista);
					    RequestDispatcher rd = request.getRequestDispatcher("EditarPerfilUsuario.jsp");
					    rd.forward(request, response);
					
				}

		
		//Atualizar dados da pessoa
		protected void atualizarDados(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			    int idUser = Integer.parseInt(request.getParameter("id"));

			    pessoa.setId(idUser);
			    pessoa.setAreaInteresse(request.getParameter("areaInteresse"));
			    pessoa.setGenero(request.getParameter("genero"));
			    pessoa.setDataNascimento(request.getParameter("dataNascimento"));
			    pessoa.setNacionalidade(request.getParameter("nacionalidade"));
			    pessoa.setFormacaoAcademica(request.getParameter("formacaoAcademica"));
			    pessoa.setDeficiencia(request.getParameter("deficiencia"));
			    pessoa.setDescricaoDeficiencia(request.getParameter("descricaoDeficiencia"));

			    pessoaPCDDao.alterarPerfil(pessoa);

			    ArrayList<PessoaPCD> listaPerfil = pessoaPCDDao.mostrarDados(idUser);
			    request.setAttribute("mostrarPerfil", listaPerfil);
			    
			    RequestDispatcher rd = request.getRequestDispatcher("PerfilUsuario.jsp");
			    rd.forward(request, response);


			    RequestDispatcher rds = request.getRequestDispatcher("PerfilEmpresa.jsp");
			    rds.forward(request, response);
			}


}