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
import dao.VagaDao;
import model.Administrador;
import model.Empresa;
import model.Vaga;

/**
 * Servlet implementation class ControllerVaga
 */
@WebServlet(urlPatterns = {"/ControllerVaga", "/CadastrarVaga","/mostrarVaga"})
public class ControllerVaga extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	VagaDao vagaDao = new VagaDao();
	Vaga vaga = new Vaga();
	EmpresaDao empresaDao = new EmpresaDao();
	Empresa empresa = new Empresa();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ControllerVaga() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getServletPath();
		System.out.println(action);
		if(action.equals("/CadastrarVaga")) {
			cadastrarVaga(request,response);
		}else if(action.equals("/mostrarVaga")) {
			mostrarVaga(request, response);
		}
	}
	
	protected void cadastrarVaga(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//pegar os valores do formulario
		String nomeEmpresa = request.getParameter("nomeEmpresa");
		String titulo = request.getParameter("titulo");
		String descricao = request.getParameter("descricao");
		String local = request.getParameter("local");
		String requisito = request.getParameter("requisito");
		String salario = request.getParameter("salario");
		String acessibilidade = request.getParameter("acessibilidade");
		String dataExpiracao = request.getParameter("dataExpiracao");
		
		// a variavel nome recebe a resposta do método selecionar nome da empresa e guarda na variavél
		//nome
		String nome = empresaDao.selecionaEmpresaNome(nomeEmpresa);
		
		if(nome != null) {
			//System.out.println("nome da empresa: " + nome);
			
			//Converte a variavél nome para objeto usando a função split
			//ela divide a string em pequenos pedaços e usa esses pedaços para instanciar
			//um novo objeto
			String[] empresaNome = nome.split(nome);
			
			empresa.setNomeEmpresa(nomeEmpresa);
			
			Vaga vaga = new Vaga();
			vaga.setEmpresa(empresa);
			vaga.setTitulo(titulo);
			vaga.setDescricao(descricao);
			vaga.setLocalizacao(local);
			vaga.setRequisito(requisito);
			vaga.setSalario(salario);
			vaga.setAcessibilidade(acessibilidade);
			vaga.setDataExpiracao(dataExpiracao);
			
			//insere a vaga no banco
			vagaDao.cadastrarVaga(vaga);
			
			response.sendRedirect("TelaInicioEmpresa.jsp");
		}else {
			String mensagem = "nome da empresa incorreto ou empresa não cadastrada";
			
			request.setAttribute("mensagemErro", mensagem);
			RequestDispatcher rd1 = request.getRequestDispatcher("CadastrarVaga.jsp");
			rd1.forward(request, response);
		}
	}
	
	protected void mostrarVaga(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ArrayList<Vaga> listaVaga = vagaDao.listaVagas();
		//teste de recebimento
		for(int i = 0; i < listaVaga.size(); i++) {
			System.out.println(listaVaga.get(i).getTitulo());
			System.out.println(listaVaga.get(i).getDescricao());
			System.out.println(listaVaga.get(i).getRequisito());
			System.out.println(listaVaga.get(i).getSalario());
			System.out.println(listaVaga.get(i).getLocalizacao());
			System.out.println(listaVaga.get(i).getAcessibilidade());
			System.out.println(listaVaga.get(i).getDataExpiracao());	
		}
		request.setAttribute("listaVaga", listaVaga);
		RequestDispatcher rd = request.getRequestDispatcher("Vagas.jsp");
		rd.forward(request, response);
	}
	
}