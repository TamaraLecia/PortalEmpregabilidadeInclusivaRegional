package com.pei.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/administrador")
public class AdministradorController {
    /* 
    private final AdministradorDAO administradorDAO;

    public AdministradorController(Connection connection) {
        this.administradorDAO = new AdministradorDAO(connection);
    }

    // Endpoint para publicar uma vaga
    @PostMapping("/vagas")
    public ResponseEntity<Object> publicarVaga(@RequestBody Vaga vaga) {
        try {
            int idVaga = administradorDAO.publicarVaga(vaga);
            if (idVaga > 0) {
                return ResponseEntity.status(HttpStatus.CREATED).body("Vaga publicada com sucesso! ID: " + idVaga);
            } else {
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erro ao publicar a vaga.");
            }
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Erro: " + e.getMessage());
        }
    }


    // Endpoint para visualizar candidatos por vaga
    @GetMapping("/vagas/{idVaga}/candidatos")
    public ResponseEntity<List<PessoaComDeficiencia>> visualizarCandidatosPorVaga(@PathVariable int idVaga) {
        List<PessoaComDeficiencia> candidatos = administradorDAO.visualizarCandidatosPorVaga(idVaga);
        if (candidatos.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(candidatos);
        }
        return ResponseEntity.ok(candidatos);
    }

    // Endpoint para realizar login
    @PostMapping("/login")
    public ResponseEntity<Administrador> login(@RequestParam String email, @RequestParam String senha) {
        Administrador admin = administradorDAO.login(email, senha);
        if (admin == null) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(null);
        }
        return ResponseEntity.ok(admin);
    }

        //Endpoint para realizar o logout
    @WebServlet(name = "Logout", urlPatterns = {"/Logout"})
    public class Logout extends HttpServlet {
        public void  realizarLougout(HttpServletRequest requisicao, HttpServletResponse resposta) {
            try {
                HttpSession sessao = requisicao.getSession(); //pegando referencia da sessão para realizar logout
                sessao.invalidate(); //apagando a sessão do usuario

                //Leva o usuario para a pagina inicial
                RequestDispatcher redireciona = requisicao.getRequestDispatcher("index.html");
                redireciona.forward(requisicao, resposta);
            } catch (Exception e) {
                System.out.println(e);
            }
        }

    }

    //Endpoint para atualizar dados da capacitação
    @WebServlet(name = "alterar", urlPatterns = {"/alterar"})
    public class alterarCapacitacao extends HttpServlet {
        protected void alterar(HttpServletRequest requisicao, HttpServletResponse resposta) throws ServletException, IOException{
            resposta.setContentType("text/html;charset=UTF8-8");
            try(PrintWriter out = resposta.getWriter()){

                String titulo = requisicao.getParameter("textTitulo");
                String descricao = requisicao.getParameter("txtDescricao");
                String dataInicio = requisicao.getParameter("txtDtaInicio");
                String dataFim = requisicao.getParameter("dataFim");
                String instrutor = requisicao.getParameter("textInstrutor");
                String publicoAlvo = requisicao.getParameter("textPublicoAlvo");

                Capacitacao capacitacao = new Capacitacao();
                capacitacao.setTituloCapacitacao(titulo);
                capacitacao.setDescriçãoCapacitação(descricao);
                capacitacao.setDataInicioCapacitacao(new Date(capacitacao.getDataInicioCapacitacao().getTime()));
                capacitacao.setDataFimCapacitacao(new Date(capacitacao.getDataFimCapacitacao().getTime()));
                capacitacao.setInstrutorCapacitaca(instrutor);
                capacitacao.setPublicoAlvos(publicoAlvo);

                AdministradorDAO administradorDAO = new AdministradorDAO(null);
                administradorDAO.alterarCapacitacao(capacitacao);
            }
        }
        
    }
        */
}

