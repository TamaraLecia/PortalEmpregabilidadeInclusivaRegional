package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.PessoaPCD;

public class PessoaPCDDAO {
	//Conexao com o banco
	/* MODULO DE CONEXÃO */
	// PARAMETRO DE CONEXAO
	private String driver = "com.mysql.cj.jdbc.Driver";
	private String url = "jdbc:mysql://127.0.0.1:3306/pei_db?useTimezone=true&serverTimezone=UTC";
	private String user = "root";
	private String password = "tamara2024";
	
	//metodo de conexao
	
	private Connection conectar() {
		Connection con = null;
		
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, user, password);
			return con;
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
	}

	// teste de conexão
	public void testeConexao() {
		try {
			Connection con = conectar();
			System.out.println(con);
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	/* CRUD CREATE */
	public void inserirpessoa(PessoaPCD pessoa) {
		String create = "insert into pessoaComDeficiencia (nome, telefone, email, senha, dataNascimento, genero, endereco, nacionalidade, cpf, deficiencia, formacaoAcademica, descricaoDeficiencia, areaInteresse, nivelAcesso) values (?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		try {
			// abrir a conexao
			Connection con = conectar();
			// Preparar a query para a execução no Bd
			PreparedStatement pst = con.prepareStatement(create);
			// substituir os parametros (?) pelo conteudo das variaveis JavaBeans
			pst.setString(1, pessoa.getNome());
			pst.setString(2, pessoa.getTelefone());
			pst.setString(3, pessoa.getEmail());
			pst.setString(4, pessoa.getSenha());
			pst.setString(5, pessoa.getDataNascimento());
			pst.setString(6, pessoa.getGenero());
			pst.setString(7, pessoa.getEndereco());
			pst.setString(8, pessoa.getNacionalidade());
			pst.setString(9, pessoa.getCpf());
			pst.setString(10, pessoa.getDeficiencia());
			pst.setString(11, pessoa.getFormacaoAcademica());
			pst.setString(12, pessoa.getDescricaoDeficiencia());
			pst.setString(13, pessoa.getAreaInteresse());
			pst.setInt(14, pessoa.getNivelAcesso());
			// Executar a query
			pst.executeUpdate();
			
			// Encerrar a conexao com o bd
			con.close();

		} catch (Exception e) {
			System.out.println(e);
		}
	}
	
	//SELECT
	//pega o nivel de acesso
	public int pegarNivelAcesso(String email, String senha) {
		String nivelAcesso = "select nivelAcesso from pessoaComDeficiencia where email = ? and senha = ?";
		
		try {
			//abrir a conexao com o banco
			Connection con = conectar();
			PreparedStatement pst = con.prepareStatement(nivelAcesso);
			pst.setString(1, email);
			pst.setString(2, senha);
			ResultSet rs = pst.executeQuery();
			
			if(rs.next()) {
				return rs.getInt("nivelAcesso");
			}else {
				return 0;
			}
			
		} catch (Exception e) {
			System.out.println(e);
		}
		return 0;
	}

	// CRUD READ/**
	public ArrayList<PessoaPCD> listarPessoa() {
		// Criando um objeto para listar os dados da pessoa
		ArrayList<PessoaPCD> pessoa = new ArrayList<>();
		String read = "select * from pessoaComDeficiencia";
		try {
			Connection con = conectar();
			PreparedStatement pst = con.prepareStatement(read);
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				String interesse = rs.getString(1);
				String genero = rs.getString(2);
				String dataNascimento = rs.getString(3);
				String nacionalidade = rs.getString(4);
				String endereco = rs.getString(5);
				String formacaoAcademica = rs.getString(6);
				String deficiencia = rs.getString(7);
				String descricao = rs.getString(8);
				pessoa.add(new PessoaPCD(dataNascimento, genero, endereco, nacionalidade, deficiencia,
						formacaoAcademica, interesse, descricao));
			}
			con.close();
			return pessoa;
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
	}
	
	//SELECT
	// Buscar pessoa para realizar o login, o email que é passado pela sessão vem daqui
	public boolean autenticar(String email, String senha) {
		PessoaPCD pessoa = new PessoaPCD();

		String autenticar = "SELECT email, senha FROM pessoaComDeficiencia WHERE email = ? AND senha = ?";

		try {
			Connection con = conectar();
			PreparedStatement pst = con.prepareStatement(autenticar);
			pst.setString(1, email);
			pst.setString(2, senha);

			ResultSet rs = pst.executeQuery();
			//con.close();
			return rs.next();
		} catch (Exception e) {
			System.out.println(e);
			return false;
		}
	}
	
	//SELECT****
	// Buscar pessoa para realizar o login, o email que é passado pela sessão vem daqui
	public void selecionarPessoa(PessoaPCD pessoa) {
		String read2 = "select * from pessoaComDeficiencia where email = ?";
		try {
			Connection con = conectar();
			PreparedStatement pst = con.prepareStatement(read2);
			pst.setString(1, pessoa.getEmail());
			ResultSet rs = pst.executeQuery();
			while(rs.next()) {
				pessoa.setAreaInteresse(rs.getString(1));
				pessoa.setGenero(rs.getString(2));
				pessoa.setDataNascimento(rs.getString(3));
				pessoa.setNacionalidade(rs.getString(4));
				pessoa.setEndereco(rs.getString(5));
				pessoa.setFormacaoAcademica(rs.getString(6));
				pessoa.setDeficiencia(rs.getString(7));
				pessoa.setDescricaoDeficiencia(rs.getString(8));
			}
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	
	//CRUD READ
	// Método para buscar um usuário pPara listar o dados do perfil do usuario
	public ArrayList<PessoaPCD> listardados(String email1) {
		ArrayList<PessoaPCD> lista = new ArrayList<>();
		String read = "select * from pessoaComDeficiencia Where email = ?";

		try {
			Connection con = conectar();
			PreparedStatement pst = con.prepareStatement(read);
			pst.setString(1, email1);
			ResultSet rs = pst.executeQuery();

			while (rs.next()) {
				PessoaPCD pessoa = new PessoaPCD();
				// Variavel que recebe o dado do banco
				pessoa.setId(rs.getInt(1));
				pessoa.setNome(rs.getString(2));
				pessoa.setTelefone(rs.getString(3));
				pessoa.setEmail(rs.getString(4));
				pessoa.setSenha(rs.getString(5));
				pessoa.setDataNascimento(rs.getString(6));
				pessoa.setGenero(rs.getString(7));
				pessoa.setEndereco(rs.getString(8));
				pessoa.setNacionalidade(rs.getString(9));
				pessoa.setCpf(rs.getString(10));
				pessoa.setDeficiencia(rs.getString(11));
				pessoa.setFormacaoAcademica(rs.getString(12));
				pessoa.setDescricaoDeficiencia(rs.getString(13));
				pessoa.setAreaInteresse(rs.getString(14));

				// popular o vetor
				lista.add(pessoa);
			}
			con.close();
		//	return pessoa;

		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
		
		return lista;
	}
	
	
	//CRUD UPDATE/
	//selecionar pessoa
	public void selecionardadosPessoa(PessoaPCD pessoa) {
		String read2 = "select * from pessoaComDeficiencia where email = ?";
		
		try {
			Connection con = conectar();
			PreparedStatement pst = con.prepareStatement(read2);
			pst.setString(1, pessoa.getEmail());
			ResultSet rs = pst.executeQuery();
			while(rs.next()) {
				pessoa.setEmail(rs.getString("email"));
				pessoa.setAreaInteresse(rs.getString("areaInteresse"));
				pessoa.setGenero(rs.getString("genero"));
				pessoa.setDataNascimento(rs.getString("dataNascimento"));
				pessoa.setNacionalidade(rs.getNString("nacionalidade"));
				pessoa.setEndereco(rs.getNString("endereco"));
				pessoa.setFormacaoAcademica(rs.getString("formacaoAcademica"));
				pessoa.setDeficiencia(rs.getString("deficiencia"));
				pessoa.setDescricaoDeficiencia(rs.getNString("descricaoDeficiencia"));
				pessoa.setId(rs.getInt("id"));
			}
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	
	//editar perfil pessoa
	public void alterarPerfil(PessoaPCD pessoa) {
		String create = "update pessoaComDeficiencia set areaInteresse=?, genero=?, dataNascimento=?, nacionalidade=?, endereco=?, formacaoAcademica=?, deficiencia=?, descricaoDeficiencia=? where id=?";
		
		try {
			Connection con = conectar();
			PreparedStatement pst = con.prepareStatement(create);
			pst.setString(1, pessoa.getAreaInteresse());
			pst.setString(2, pessoa.getGenero());
			pst.setString(3, pessoa.getDataNascimento());
			pst.setString(4, pessoa.getNacionalidade());
			pst.setString(5, pessoa.getEndereco());
			pst.setString(6, pessoa.getFormacaoAcademica());
			pst.setString(7, pessoa.getDeficiencia());
			pst.setString(8, pessoa.getDescricaoDeficiencia());
			pst.setInt(9, pessoa.getId());
			
			pst.executeUpdate();
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
		
	}
	
	//CRUD READ ver perfil usuario 04/
	// Método para buscar um usuário pPara listar o dados do perfil do usuario
	public ArrayList<PessoaPCD> mostrarDados(int id) {
	    ArrayList<PessoaPCD> mostrarPerfil = new ArrayList<>();
	    String read = "SELECT id, areaInteresse, genero, dataNascimento, nacionalidade, endereco, formacaoAcademica, deficiencia, descricaoDeficiencia FROM pessoaComDeficiencia WHERE id = ?";

	    try {
	        Connection con = conectar();
	        PreparedStatement pst = con.prepareStatement(read);
	        pst.setInt(1, id);
	        ResultSet rs = pst.executeQuery();

	        while (rs.next()) {
	            PessoaPCD pessoa = new PessoaPCD();
	            pessoa.setId(rs.getInt("id")); // ← ESSENCIAL!
	            pessoa.setAreaInteresse(rs.getString("areaInteresse"));
	            pessoa.setGenero(rs.getString("genero"));
	            pessoa.setDataNascimento(rs.getString("dataNascimento"));
	            pessoa.setNacionalidade(rs.getString("nacionalidade"));
	            pessoa.setEndereco(rs.getString("endereco"));
	            pessoa.setFormacaoAcademica(rs.getString("formacaoAcademica"));
	            pessoa.setDeficiencia(rs.getString("deficiencia"));
	            pessoa.setDescricaoDeficiencia(rs.getString("descricaoDeficiencia"));

	            mostrarPerfil.add(pessoa);
	        }

	        con.close();
	        return mostrarPerfil;

	    } catch (Exception e) {
	        System.out.println("erro: " + e);
	        return null;
	    }
	}

	//SELECT
	//pegar o id do usuario
		public int pegarId(String email) {
			String id = "select id from pessoaComDeficiencia where email = ?";
			
			try {
				//abrir a conexao com o banco
				Connection con = conectar();
				PreparedStatement pst = con.prepareStatement(id);
				pst.setString(1, email);
				
				ResultSet rs = pst.executeQuery();
				
				if(rs.next()) {
					return rs.getInt("id");
				}
			} catch (Exception e) {
				System.out.println(e);
			}
			return 0;
		}

}