package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.AdmDAO;
import model.Administrador;

@WebServlet(urlPatterns = {"/ControllerAdm", "/TelaInicio", "/insert"})
public class ControllerAdm extends HttpServlet {
	private static final long serialVersionUID =1L;
	AdmDAO admDAO = new AdmDAO();
	Administrador adm = new Administrador();
       
    public ControllerAdm() {
        super();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String action = request.getServletPath();
		System.out.println(action);
		if(action.equals("/TelaInicio")) {
			adm(request, response);
		}else if(action.equals("/insert")) {
			inserirAdm(request, response);
		} else {
			response.sendRedirect("TelaInicio.html");
		}
		//teste de conexao
		//admDAO.testeConexao();
	}
	
	//listar administrador
	protected void adm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		response.sendRedirect("CriarContaEmpresa.html");
	}
	
	//criar administrador
	protected void inserirAdm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
	    // Teste de recebimento dos dados no formulário
	    String nome = request.getParameter("nome");
	    String telefone = request.getParameter("telefone");
	    String email = request.getParameter("email");
	    String senha = request.getParameter("senha");
	    
	    if(nome == null || nome.isEmpty()) {
	        response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Nome não pode ser nulo ou vazio");
	        return;
	    }
	    if(telefone == null || telefone.isEmpty()) {
	        response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Telefone não pode ser nulo ou vazio");
	        return;
	    }
	    if(email == null || email.isEmpty()) {
	        response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Email não pode ser nulo ou vazio");
	        return;
	    }
	    if(senha == null || senha.isEmpty()) {
	        response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Senha não pode ser nula ou vazia");
	        return;
	    }

	    // Criar um novo objeto Administrador com os valores recebidos
	    Administrador adm = new Administrador(0, nome, telefone, email, senha, null);

	    // Invocar o método inserir administrador passando o objeto adm
	    admDAO.criarADM(adm);

	    // Redirecionar
	    response.sendRedirect("CadastroEmpresa.html");
	}
	
	
	
	
	


}
