package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.example.teste.model.pessoaComDeficiencia;

import model.PessoaComDeficienciaDAO;
import model.EmpresaDAO;
import model.PessoaComDeficiencia;
import model.Empresa;

@WebServlet(urlPatterns = {"/ControllerPerfil", "/PerfilpessoaComDeficiencia", "/EditarPerfilpessoaComDeficiencia", "/PerfilEmpresa", "/EditarPerfilEmpresa"})
public class ControllerPerfil extends HttpServlet {
    private static final long serialVersionUID = 1L;

    PessoaComDeficienciaDAO pessoaDAO = new PessoaComDeficienciaDAO();
    EmpresaDAO empresaDAO = new EmpresaDAO();

    public ControllerPerfil() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getServletPath();
        System.out.println(action);

        switch (action) {
            case "/PerfilpessoaComDeficiencia":
                visualizarPerfilpessoaComDeficiencia(request, response);
                break;
            case "/EditarPerfilpessoaComDeficiencia":
                editarPerfilpessoaComDeficiencia(request, response);
                break;
            case "/PerfilEmpresa":
                visualizarPerfilEmpresa(request, response);
                break;
            case "/EditarPerfilEmpresa":
                editarPerfilEmpresa(request, response);
                break;
            default:
                response.sendRedirect("TelaInicio.html");
        }
    }

    // Visualizar perfil de usuário
    protected void visualizarPerfilpessoaComDeficiencia(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        PessoaComDeficiencia pessoa = pessoaDAO.buscarPorId(id);

        if (pessoa != null) {
            request.setAttribute("pessoa", pessoa);
            request.getRequestDispatcher("PerfilpessoaComDeficiencia.jsp").forward(request, response);
        } else {
            response.sendError(HttpServletResponse.SC_NOT_FOUND, "Usuário não encontrado.");
        }
    }

    // Editar perfil do usuário
	protected void editarPerfilUsario(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));  // Recupera o ID do usuário
		PessoaComDeficiencia pessoaComDeficiencia = new PessoaComDeficiencia();

		pessoaComDeficiencia.setId(id);
		pessoaComDeficiencia.setAreaInteresse(request.getParameter("area-interesse"));
		pessoaComDeficiencia.setGenero(request.getParameter("genero"));
		pessoaComDeficiencia.setDataNascimento(Date.valueOf(request.getParameter("data-nascimento"))); // Converte a data para o formato correto
		pessoaComDeficiencia.setNacionalidade(request.getParameter("nacionalidade"));
		pessoaComDeficiencia.setEndereco(request.getParameter("endereco"));
		pessoaComDeficiencia.setFormacaoAcademica(request.getParameter("formacao-academica"));
		pessoaComDeficiencia.setDeficiencia(request.getParameter("deficiencia"));
		pessoaComDeficiencia.setDescricaoDeficiencia(request.getParameter("descricao-deficiencia"));

		pessoaComDeficienciaDAO.atualizar(pessoaComDeficiencia);

		response.sendRedirect("PerfilUsuario?id=" + id);
	}


    // Visualizar perfil da empresa
    protected void visualizarPerfilEmpresa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Empresa empresa = empresaDAO.buscarPorId(id);

        if (empresa != null) {
            request.setAttribute("empresa", empresa);
            request.getRequestDispatcher("PerfilEmpresa.jsp").forward(request, response);
        } else {
            response.sendError(HttpServletResponse.SC_NOT_FOUND, "Empresa não encontrada.");
        }
    }

    // Editar perfil da empresa
    protected void editarPerfilEmpresa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));  // Recupera o ID da empresa
		Empresa empresa = new Empresa();
	
		// Setando os dados da empresa com os parâmetros recebidos
		empresa.setId(id);
		empresa.setNome(request.getParameter("nome"));
		empresa.setCnpj(request.getParameter("cnpj"));
		empresa.setSetorAtuacao(request.getParameter("setorAtuacao"));
		empresa.setSite(request.getParameter("site"));
		empresa.setEndereco(request.getParameter("endereco"));
		empresa.setRegiao(request.getParameter("regiao"));
		empresa.setInclusao(request.getParameter("inclusao"));
		empresa.setDescricao(request.getParameter("descricao"));
	
		empresaDAO.atualizar(empresa);
	
		response.sendRedirect("PerfilEmpresa?id=" + id);
	}
}
