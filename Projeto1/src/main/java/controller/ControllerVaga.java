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
@WebServlet(urlPatterns = {"/ControllerVaga", "/CadastrarVaga", "/enviarNomeEmpresa"})
public class ControllerVaga extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	VagaDao vagaDao = new VagaDao();
	Vaga vaga = new Vaga();
	EmpresaDao empresaDao = new EmpresaDao();
	Administrador administrador = new  Administrador();
	Empresa empresa = new Empresa();
	AdmDao admDao = new AdmDao();
       
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
		
		if(action.equals("/enviarNomeEmpresa")){
			pegarNomeEmpresa(request, response);
		} else if(action.equals("/CadastrarVaga")) {
			cadastrarVaga(request,response);
		} else if (action.equals("/visualizarVagas")) {
			visualizarVagas(request, response);
		}
	}
	
	//visulizar o nome da empresa
		protected void pegarNomeEmpresa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			HttpSession session = request.getSession();
			String email = (String) session.getAttribute("email");
			
			System.out.println("email: " + email);
			
			int idAdm = admDao.pegarId(email);
			System.out.println("id adm: " + idAdm);
			
			ArrayList<Empresa> listaEmpresas = empresaDao.listarDados(idAdm);
			
			if(listaEmpresas == null || listaEmpresas.isEmpty()) {
				System.out.println("lita do serv nula");
			}else {
				System.out.println("Lista pre: " + listaEmpresas);
			}
			
			for(int i = 0; i < listaEmpresas.size(); i++) {
				System.out.println(listaEmpresas.get(i).getId());
				System.out.println(listaEmpresas.get(i).getNomeEmpresa());
				System.out.println("verPerfilV: " + listaEmpresas);
			}
			request.setAttribute("listaEmpresa", listaEmpresas);
			RequestDispatcher rd = request.getRequestDispatcher("CadastrarVaga.jsp");
			rd.forward(request, response);
		}
	
	protected void cadastrarVaga(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//pegar os valores do formulario
		String nomeEmpresa = request.getParameter("idEmpresa");
		String titulo = request.getParameter("titulo");
		String descricao = request.getParameter("descricao");
		String local = request.getParameter("local");
		String requisito = request.getParameter("requisito");
		String salario = request.getParameter("salario");
		String acessibilidade = request.getParameter("acessibilidade");
		String dataExpiracao = request.getParameter("dataExpiracao");
		
		int idEmpresa = 0;
		try {
			idEmpresa = Integer.parseInt(nomeEmpresa);
		} catch (Exception e) {
			System.out.println(e);
		}
		
		//recuperar o nome da empresa no banco
		Empresa empresa = empresaDao.pegarEmpresa(idEmpresa);
		
		//defini o nome da empresa na sessão
		HttpSession session = request.getSession();
		session.setAttribute("empresaNome", empresa.getNomeEmpresa());
		
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
	}
	
		

}