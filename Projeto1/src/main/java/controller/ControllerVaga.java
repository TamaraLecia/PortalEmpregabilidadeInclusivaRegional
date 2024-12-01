package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.EmpresaDao;
import dao.VagaDao;
import model.Empresa;
import model.Vaga;

/**
 * Servlet implementation class ControllerVaga
 */
@WebServlet(urlPatterns = {"/ControllerVaga", "/CadastrarVaga"})
public class ControllerVaga extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	VagaDao vagaDao = new VagaDao();
	Vaga vaga = new Vaga();
       
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
		
		if(action.equals("/CadastrarVaga")) {
			cadastrarVaga(request, response);
		}
	}
	
	protected void cadastrarVaga(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//teste de recebimento dos dados do form
		//request.getParameter: recupera os dados do formulario
		String nome = request.getParameter("empresa");
		
		EmpresaDao empresaDao = new EmpresaDao();
		
		
		boolean verificar = empresaDao.verificarEmpresa(nome);
		
		if(verificar == true) {
			
			System.out.println(request.getParameter("titulo"));
			System.out.println(request.getParameter("empresa"));
			System.out.println(request.getParameter("descricao"));
			System.out.println(request.getParameter("local"));
			System.out.println(request.getParameter("requisito"));
			System.out.println(request.getParameter("salario"));
			System.out.println(request.getParameter("acessibilidade"));
			System.out.println(request.getParameter("dataExpiracao"));
			
			double salario1 = Double.parseDouble(request.getParameter("salario"));
			
			Empresa empresa = new Empresa();
			
			String nomeEmpresa = (String) request.getSession().getAttribute("empresaNome");
			
			empresa.setNomeEmpresa(nomeEmpresa);
			
			vaga.setEmpresa(empresa);
			System.out.println("id da empresa: " + vaga.getEmpresa());
			vaga.setTitulo(request.getParameter("titulo"));
			vaga.setDescricao("descricao");
			vaga.setLocalizacao("local");
			vaga.setRequisito("requisito");
			vaga.setSalario(salario1);
			vaga.setAcessibilidade("acessibilidade");
			vaga.setDataExpiracao("dataExpiracao");
			
			vagaDao.criarVaga(vaga);
			response.sendRedirect("TelaInicioEmpresa.html");
			
		}else {
			System.out.println("Essa empresa ainda não foi cadastrada");
			System.err.println("Ou o nome está incorreto");
			response.sendRedirect("CadastrarVaga.html");
		}
		
	}

}
