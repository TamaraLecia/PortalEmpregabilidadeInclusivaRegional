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
import dao.EmpresaDao;
import model.Administrador;
import model.Empresa;

/**
 * Servlet implementation class ControllerEmpresa
 */
@WebServlet(urlPatterns = {"/ControllerEmpresa" , "/TelaInicioEmpresa","/CadastrarEmpresa", "/verNomeEmpresa", "/verEmpresa", "/selecionarEmpresa", "/atualizarEmpresa"})
public class ControllerEmpresa extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	EmpresaDao empresaDao = new EmpresaDao();
	Empresa empresa = new Empresa();
	AdmDao admDao = new AdmDao();
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ControllerEmpresa() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getServletPath();
		
		System.out.println(action);
		
		if(action.equals("/CadastrarEmpresa")) {
			novaEmpresa(request, response);
		}else if(action.equals("/verNomeEmpresa")) {
			visualizaNomeEmpresa(request, response);
		}else if(action.equals("/verEmpresa")){
			 visualizarEmpresa(request, response);
		}else if(action.equals("/selecionarEmpresa")) {
			selecionarEmpresa(request, response);
		}else if(action.equals("/atualizarEmpresa")){
			atualizarDados(request, response);
		}else if(action.equals("/TelaInicioEmpresa")) {
			listarEmpresa(request, response);
		}else if(action.equals("/mandarNomeEmpresaVaga")) {
			nomeEmpresa(request, response);
		}
	}
	
	protected void novaEmpresa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//teste de recebimento dos dados do form
		//request.getParameter: recupera os dados do formulario
		HttpSession session = request.getSession();
		String email = (String) session.getAttribute("email");
		
		System.out.println("email: " + email);
		
		int idAdm = admDao.pegarId(email);
		System.out.println("id adm: " + idAdm);
		
		System.out.println(request.getParameter("idAdm"));
		System.out.println(request.getParameter("nomeEmpresa"));
		System.out.println(request.getParameter("cnpj"));
		System.out.println(request.getParameter("setor"));
		System.out.println(request.getParameter("site"));
		System.out.println(request.getParameter("endereco"));
		System.out.println(request.getParameter("regiao"));
		System.out.println(request.getParameter("programaInclusao"));
		System.out.println(request.getParameter("tipoVaga"));
		System.out.println(request.getParameter("descricaoVagas"));
		
		Administrador adm = new Administrador();
		
		adm.setId(idAdm);
		
		//redirecionar para o documento tela de inicio da empresa
		//response.sendRedirect("TelaInicioEmpresa.html");
		
		empresa.setAdm(adm);
		//System.out.println("id do administrador: " + empresa.getAdm());
		empresa.setNomeEmpresa(request.getParameter("nomeEmpresa"));
		empresa.setCnpj(request.getParameter("cnpj"));
		empresa.setSetor(request.getParameter("setor"));
		empresa.setSite(request.getParameter("site"));
		empresa.setEndereco(request.getParameter("endereco"));
		empresa.setRegiaoAtuacao(request.getParameter("regiao"));
		empresa.setProgramaInclusao(request.getParameter("programaInclusao"));
		empresa.setTipoVaga(request.getParameter("tipoVaga"));
		empresa.setDescricaoVaga(request.getParameter("descricaoVagas"));
		
		empresaDao.criarEmpresa(empresa);
		
		//Guarda o valor do id na sessão que foi criada
		request.getSession().setAttribute("empresaNome", empresa.getNomeEmpresa());
		
		response.sendRedirect("TelaInicioEmpresa.jsp");	
	}
	
	//visulizar o nome da empresa
	protected void visualizaNomeEmpresa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String email = (String) session.getAttribute("email");
		
		System.out.println("email: " + email);
		
		int idAdm = admDao.pegarId(email);
		System.out.println("id adm: " + idAdm);
		
		ArrayList<Empresa> lista = empresaDao.listarDados(idAdm);
		
		for(int i = 0; i < lista.size(); i++) {
			System.out.println(lista.get(i).getNomeEmpresa());
		}
		request.setAttribute("listaEmpresa", lista);
		RequestDispatcher rd = request.getRequestDispatcher("ListarEmpresa.jsp");
		rd.forward(request, response);
	}
	
	//visulizar o nome da empresa para enviar para a vaga
		protected void nomeEmpresa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			HttpSession session = request.getSession();
			String email = (String) session.getAttribute("email");
			
			System.out.println("email: " + email);
			
			int idAdm = admDao.pegarId(email);
			System.out.println("id adm: " + idAdm);
			
			ArrayList<Empresa> lista = empresaDao.listarDados(idAdm);
			
			for(int i = 0; i < lista.size(); i++) {
				System.out.println(lista.get(i).getNomeEmpresa());
			}
			request.setAttribute("listaEmpresa", lista);
			RequestDispatcher rd = request.getRequestDispatcher("CadastrarVaga.jsp");
			rd.forward(request, response);
		}
	
	//Visualizar os dados da empresa
	protected void visualizarEmpresa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String idEmp = request.getParameter("id");
		request.setAttribute(idEmp, response);
		int idEmpresa = Integer.parseInt(idEmp);
		System.out.println("id empresa: " + idEmpresa);
		
		HttpSession session = request.getSession();
		String id = (String) session.getAttribute("idEmp");
		System.out.println("id da empresa recuperado para a sessao: " + id);
		
		ArrayList<Empresa> lista = empresaDao.mostrarDados(idEmpresa);
		for(int i = 0; i < lista.size(); i++) {
			System.out.println(lista.get(i).getNomeEmpresa());
			System.out.println(lista.get(i).getCnpj());
			System.out.println(lista.get(i).getSetor());
			System.out.println(lista.get(i).getSite());
			System.out.println(lista.get(i).getEndereco());
			System.out.println(lista.get(i).getRegiaoAtuacao());
			System.out.println(lista.get(i).getProgramaInclusao());
			System.out.println(lista.get(i).getTipoVaga());
			System.out.println(lista.get(i).getDescricaoVaga());
			
		}
		request.setAttribute("mostrarEmpresa", lista);
		RequestDispatcher rd = request.getRequestDispatcher("PerfilEmpresa.jsp");
		rd.forward(request, response);
	}
	
	//método para selecionar a empresa
	protected void selecionarEmpresa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String idEmp = request.getParameter("id");
		request.setAttribute(idEmp, response);
		int idEmpresa = Integer.parseInt(idEmp);
		System.out.println("id empresa: " + idEmpresa);
		
		HttpSession session = request.getSession();
		String id = (String) session.getAttribute("idEmp");
		System.out.println("id da empresa recuperado para a sessao: " + id);
		
		ArrayList<Empresa> lista = empresaDao.mostrarDados(idEmpresa);
		for(int i = 0; i < lista.size(); i++) {
			System.out.println(lista.get(i).getNomeEmpresa());
			System.out.println(lista.get(i).getCnpj());
			System.out.println(lista.get(i).getSetor());
			System.out.println(lista.get(i).getSite());
			System.out.println(lista.get(i).getEndereco());
			System.out.println(lista.get(i).getRegiaoAtuacao());
			System.out.println(lista.get(i).getProgramaInclusao());
			System.out.println(lista.get(i).getTipoVaga());
			System.out.println(lista.get(i).getDescricaoVaga());
			
		}
		request.setAttribute("mostrarEmpresa", lista);
		RequestDispatcher rd = request.getRequestDispatcher("EditarPerfilEmpresa.jsp");
		rd.forward(request, response);
	}
	
	
	//Atualizar dados da empresa
	protected void atualizarDados(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//Teste de recebimento dos dados que serão atualizados
		
		System.out.println();
		System.out.println("teste de recebimento no formulario");
		System.out.println(request.getParameter("chavePrimaria"));
		System.out.println(request.getParameter("nomeEmpresa"));
		System.out.println(request.getParameter("cnpj"));
		System.out.println(request.getParameter("setor"));
		System.out.println(request.getParameter("site"));
		System.out.println(request.getParameter("endereco"));
		System.out.println(request.getParameter("regioes"));
		System.out.println(request.getParameter("inclusao"));
		System.out.println(request.getParameter("descricao"));
		
		//Requisita e seta a variaveis de empresas com os valores fornecidos pelo o request que pega do formulário
		//Covertendo uma String para inteiros
		int idEmp = Integer.parseInt(request.getParameter("chavePrimaria"));
		System.out.println("Id da empresa: " + idEmp);
		
		//setar as variaveis Empresas
		
		empresa.setId(idEmp);
		empresa.setNomeEmpresa(request.getParameter("nomeEmpresa"));
		empresa.setCnpj(request.getParameter("cnpj"));
		empresa.setSetor(request.getParameter("setor"));
		empresa.setSite(request.getParameter("site"));
		empresa.setEndereco(request.getParameter("endereco"));
		empresa.setRegiaoAtuacao(request.getParameter("regioes"));
		empresa.setProgramaInclusao(request.getParameter("inclusao"));
		empresa.setDescricaoVaga(request.getParameter("descricao"));
		
		//executar o método alterar contato
		empresaDao.alterarPerfil(empresa);
		
		ArrayList<Empresa> listaEmpresa = empresaDao.mostrarDados(idEmp);
		request.setAttribute("mostrarEmpresa", listaEmpresa);
		RequestDispatcher rd = request.getRequestDispatcher("PerfilEmpresa.jsp");
		rd.forward(request, response);
		
		//redirecionar para o documento perfilUsuario.jsp (atualizando as alterações)
		response.sendRedirect("PerfilEmpresa.jsp");
	}
	
	protected void listarEmpresa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//Listar todas as empresas cadastradas
		
		ArrayList<Empresa> lista1 = empresaDao.listarTodasEmpresa();
		
		for(int i = 0; i < lista1.size(); i++) {
			System.out.println(lista1.get(i).getNomeEmpresa());
			System.out.println(lista1.get(i).getCnpj());
			System.out.println(lista1.get(i).getSetor());
			System.out.println(lista1.get(i).getSite());
			System.out.println(lista1.get(i).getEndereco());
			System.out.println(lista1.get(i).getRegiaoAtuacao());
			System.out.println(lista1.get(i).getProgramaInclusao());
			System.out.println(lista1.get(i).getTipoVaga());
			System.out.println(lista1.get(i).getDescricaoVaga());
			
		}
		request.setAttribute("lista", lista1);
		RequestDispatcher rd = request.getRequestDispatcher("TelaInicioEmpresa.jsp");
		rd.forward(request, response);
	}

}
