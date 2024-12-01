package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.AdmDao;
import model.Administrador;

/**
 * Servlet implementation class ControllerAdm
 */
@WebServlet(urlPatterns = {"/ControllerAdm", "/main", "/insert"})
public class ControllerAdm extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	AdmDao admDao = new AdmDao();
	Administrador adm = new Administrador();
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ControllerAdm() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getServletPath();
		
		System.out.println(action);
		
		if(action.equals("/insert")) {
			novoAdm(request, response);
		} else {
			response.sendRedirect("TelaInicio.html");
		}
	}
	
	//inserir Administrador
	protected void novoAdm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//teste de recebimento dos dados do form
		//request.getParameter: recupera os dados do formulario
		
		/*
		System.out.println(request.getParameter("nome"));
		System.out.println(request.getParameter("telefone"));
		System.out.println(request.getParameter("email"));
		System.out.println(request.getParameter("senha"));
		*/
		
		//setar as variaveis de Administrador
		adm.setNivelAcesso(1);
		adm.setNome(request.getParameter("nome"));
		adm.setTelefone(request.getParameter("telefone"));
		adm.setEmail(request.getParameter("email"));
		adm.setSenha(request.getParameter("senha"));
		
		//Chamar O metodo criarAdm
		admDao.criarAdm(adm);
		
		//Guarda o valor do id na sessão que foi criada
		request.getSession().setAttribute("idAdm", adm.getId());
		request.getSession().setAttribute("email", adm.getEmail());
		request.getSession().setAttribute("senha", adm.getSenha());
		request.getSession().setAttribute("nivelAcesso", adm.getNivelAcesso());
		
		//redirecionar para o documento tela de inicio da empresa
		response.sendRedirect("TelaInicioEmpresa.html");
		
	}

}
