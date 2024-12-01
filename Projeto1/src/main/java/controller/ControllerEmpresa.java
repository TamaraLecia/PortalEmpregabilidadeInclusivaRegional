package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.EmpresaDao;
import model.Administrador;
import model.Empresa;

/**
 * Servlet implementation class ControllerEmpresa
 */
@WebServlet(urlPatterns = {"/ControllerEmpresa" , "/TelaInicio", "/CadastrarEmpresa"})
public class ControllerEmpresa extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	EmpresaDao empresaDao = new EmpresaDao();
	Empresa empresa = new Empresa();
	
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
		}else {
			response.sendRedirect("TelaInicioEmpresa.html");
		}
	}
	
	protected void novaEmpresa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//teste de recebimento dos dados do form
		//request.getParameter: recupera os dados do formulario
		
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
		
		int idAdm = (int) request.getSession().getAttribute("idAdm");
		
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
		
		response.sendRedirect("TelaInicioEmpresa.html");
		
		
	}


}
