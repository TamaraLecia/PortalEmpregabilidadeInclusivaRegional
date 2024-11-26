package com.pei.pei.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.pei.pei.model.Pessoa;
import com.pei.pei.model.PessoaComDeficiencia;
import com.pei.pei.repository.PessoaRepository;

import jakarta.validation.Valid;




/*@CrossOrigin("*")//libera todas as entradas que vier da maquina*/
@RestController
public class PessoaComDeficienciaController {
    @Autowired
    private PessoaRepository pessoaRepository;

/* 
    private final PessoaComDeficienciaDAO pessoaComDeficienciaDAO;

    @Autowired
    public PessoaComDeficienciaController(Connection connection) {
        this.pessoaComDeficienciaDAO = new PessoaComDeficienciaDAO(connection);
    }*/
    
    // Endpoint para o cadastro primario
    @GetMapping("/cadastroPrimario")
    public String cadastroPrimario() {
        return "cadastroPrimario";
    }
    
    @RequestMapping(value = "/cadastroPrimario", method=RequestMethod.POST)
    public String cadastroPrimario(@Valid Pessoa pessoa, BindingResult result) {
        if(result.hasErrors()){
            return "redirect:/cadastroPrimario";
        }

        pessoaRepository.save(pessoa);

        return "redirect:/login";
    }
        
    

    // Endpoint para cadastrar uma nova pessoa com deficiência
    @GetMapping("/CadastroUsuario")
    public String cadastroUsuario() {
        return "cadastroUsuario";
    }
    
    @RequestMapping(value = "/cadastroUsuario", method=RequestMethod.POST)
    public String cadastroUsuario(@Valid PessoaComDeficiencia pessoaComDeficiencia, BindingResult result) {
        if(result.hasErrors()){
            return "redirect:/cadastroUsuario";
        }

        pessoaRepository.save(pessoaComDeficiencia);

        return "redirect:/login";
    }
    
    // Endpoint para realizar login
    @GetMapping("/login")
        public String login(){
            return "Login";
        }
    }
/* 
    // Endpoint para visualizar perfil
    @GetMapping("/{id}")
    public ResponseEntity<PessoaComDeficiencia> visualizarPerfil(@PathVariable int id) {
        PessoaComDeficiencia pessoa = pessoaComDeficienciaDAO.visualizarPerfil(id);
        if (pessoa != null) {
            return ResponseEntity.ok(pessoa);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
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

    //Endpoint para buscar vaga
    @PostMapping("/bucarVaga")
    public void buscarVaga(@RequestParam String titulo, String localizacao){
        try {
            List<Vaga> vagas = pessoaComDeficienciaDAO.bucarVaga(titulo, localizacao);
            if(vagas != null){
                for(Vaga vaga : pessoaComDeficienciaDAO.bucarVaga(titulo, localizacao)){
                    System.out.println("Titulo: " + vaga.getTitulo());
                    System.out.println("Requisitos: " + vaga.getRequisitos());
                    System.out.println("Localização: " + vaga.getLocalizacao());
                    System.out.println("Acessibilidade: " + vaga.getAcessibilidade());
                    System.out.println("Empresa: " + vaga.getEmpresa());
                    System.out.println("Beneficios: " + vaga.getBeneficios());
                    System.out.println("Salário: " + vaga.getSalario());
                    System.out.println();
                    System.out.println();
                    break;

                }
            }else{
                System.out.println("Vaga não encontrada");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //Endpoint para remover Formação
    @PostMapping("/removerFormacao")
    public void removerFormacao(@RequestParam Integer id){
        pessoaComDeficienciaDAO.removerFormacao(id);
    }

    //Endpoint para remover Experiência
   @PostMapping("/removerExperiência")
   public void removerExperiencia(@RequestParam Integer id){
       pessoaComDeficienciaDAO.removerExperiencia(id);
       System.out.println("Experiencia removida");
   }

   

   //Endpoint para editar dados do usuário
    @WebServlet(name = "editarUsuario", urlPatterns = {"/editarUsuario"})
    public class alterarCapacitacao extends HttpServlet {
        protected void alterar(HttpServletRequest requisicao, HttpServletResponse resposta) throws ServletException, IOException{
            resposta.setContentType("text/html;charset=UTF8-8");
            try(PrintWriter out = resposta.getWriter()){

                String nome = requisicao.getParameter("txtNome");
                String dataNascimento = requisicao.getParameter("txtDataNascimento");
                String cpf = requisicao.getParameter("txtCpf");
                String genero = requisicao.getParameter("txtGenero");
                String endereco = requisicao.getParameter("txtEndereco");
                String nacionalidade = requisicao.getParameter("txtNacionalidade");
                String deficiencia = requisicao.getParameter("txtDeficiencia");
                String interesse = requisicao.getParameter("txtInteresse");
                String formacao = requisicao.getParameter("txtFormacao");
                String descricao = requisicao.getParameter("txtFormacao");

                PessoaComDeficiencia pessoaComDeficiencia = new PessoaComDeficiencia(null, dataNascimento, null, cpf, genero, endereco, nacionalidade, deficiencia, interesse, formacao, descricao);

                pessoaComDeficiencia.setNome(nome);
                pessoaComDeficiencia.setDataNascimento(new Date(pessoaComDeficiencia.getDataNascimento().getTime()));
                pessoaComDeficiencia.setCpf(cpf);
                pessoaComDeficiencia.setGenero(genero);
                pessoaComDeficiencia.setEndereco(endereco);
                pessoaComDeficiencia.setNacionalidade(nacionalidade);
                pessoaComDeficiencia.setDeficiencia(deficiencia);
                pessoaComDeficiencia.setInteresse(interesse);
                pessoaComDeficiencia.setFormacao(formacao);
                pessoaComDeficiencia.setDescricao(descricao);

                PessoaComDeficienciaDAO pessoaComDeficienciaDAO = new PessoaComDeficienciaDAO(null);
                pessoaComDeficienciaDAO.alterarPessoaComDeficiencia(pessoaComDeficiencia);


            }
        }
        
    }
*/

