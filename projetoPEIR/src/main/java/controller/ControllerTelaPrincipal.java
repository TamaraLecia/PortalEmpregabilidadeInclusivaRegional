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

import dao.EmpresaDao;
import model.Empresa;

//Controller que pega os dados do banco de dados e redireciona para a 
//tela inicial através da configuração do web.xml que torna esse controller
//a página principal que direciona para a Tela Inicicail Jsp

/**
 * Servlet implementation class ControllerIndex
 */
@WebServlet("/TelaPrincipal")
public class ControllerTelaPrincipal extends HttpServlet {
	private static final long serialVersionUID = 1L;
       EmpresaDao empresaDao = new EmpresaDao();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ControllerTelaPrincipal() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//Listar todas as empresas cadastradas para exibir na página inicial
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
		
		HttpSession session = request.getSession();
		session.setAttribute("listas", lista1);
		
		RequestDispatcher rd = request.getRequestDispatcher("TelaInicio.jsp");
		rd.forward(request, response);
	}

}