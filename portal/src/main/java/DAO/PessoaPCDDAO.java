package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.PessoaPCD;

public class PessoaPCDDAO {
	/** MODULO DE CONEXÃO **/
	// PARAMETRO DE CONEXAO
	private String driver = "com.mysql.cj.jdbc.Driver";
	private String url = "jdbc:mysql://127.0.0.1:3306/pei_db?useTimezone=true&serverTimezone=UTC";
	private String user = "root";
	private String password = "tamara2024";

	// MÉTODO DE CONEXÃO

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

	/** CRUD CREATE **/
	public void inserirpessoa(PessoaPCD pessoa) {
		String create = "insert into pessoaComDeficiencia (nome, telefone, email, senha, dataNascimento, genero, endereco, nacionalidade, cpf, deficiencia, formacaoAcademica,areaInteresse, descricaoDeficiencia) values (?,?,?,?,?,?,?,?,?,?,?,?,?)";
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
			// Executar a query
			pst.executeUpdate();
			// Encerrar a conexao com o bd
			con.close();

		} catch (Exception e) {
			System.out.println(e);
		}
	}

	// *CRUD READ*/
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

	// Buscar pessoa para realizar o login
	public boolean autenticar(String email, String senha) {
		PessoaPCD pessoa = new PessoaPCD();

		String autenticar = "SELECT email, senha FROM pessoaComDeficiencia WHERE email = ? AND senha = ?";

		try {
			Connection con = conectar();
			PreparedStatement pst = con.prepareStatement(autenticar);
			pst.setString(1, email);
			pst.setString(2, senha);

			ResultSet rs = pst.executeQuery();
			return rs.next();
		} catch (Exception e) {
			System.out.println(e);
			return false;
		}
	}

	// Método para atualizar o perfil de um usuário com deficiência
	public void atualizar(PessoaPCD pessoa) {
		String update = "UPDATE pessoaComDeficiencia SET areaInteresse = ?, genero = ?, dataNascimento = ?, "
				+ "nacionalidade = ?, endereco = ?, formacaoAcademica = ?, deficiencia = ?, descricaoDeficiencia = ? "
				+ "WHERE id = ?";
		try {
			// Abrir a conexão com o banco de dados
			Connection con = conectar();
			// Preparar a query SQL
			PreparedStatement pst = con.prepareStatement(update);

			// Substituir os parâmetros pelos valores do objeto
			pst.setString(1, pessoa.getAreaInteresse());
			pst.setString(2, pessoa.getGenero());
			pst.setString(3, pessoa.getDataNascimento());
			pst.setString(4, pessoa.getNacionalidade());
			pst.setString(5, pessoa.getEndereco());
			pst.setString(6, pessoa.getFormacaoAcademica());
			pst.setString(7, pessoa.getDeficiencia());
			pst.setString(8, pessoa.getDescricaoDeficiencia());
			pst.setInt(9, pessoa.getId());

			// Executar a query
			pst.executeUpdate();
			// Fechar a conexão
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}

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
	/*
	public PessoaPCD buscarPorEmail(String email) {
	    String read = "SELECT * FROM pessoaComDeficiencia WHERE email = ?";
	    PessoaPCD pessoa = null;

	    try (Connection con = conectar();
	         PreparedStatement pst = con.prepareStatement(read)) {
	        pst.setString(1, email);

	        try (ResultSet rs = pst.executeQuery()) {
	            if (rs.next()) {
	                pessoa = new PessoaPCD();
	                pessoa.setId(rs.getInt("id"));
	                pessoa.setNome(rs.getString("nome"));
	                pessoa.setEmail(rs.getString("email"));
	                pessoa.setTelefone(rs.getString("telefone"));
	                pessoa.setSenha(rs.getString("senha"));
	                pessoa.setDataNascimento(rs.getString("dataNascimento"));
	                pessoa.setGenero(rs.getString("genero"));
	                pessoa.setEndereco(rs.getString("endereco"));
	                pessoa.setNacionalidade(rs.getString("nacionalidade"));
	                pessoa.setCpf(rs.getString("cpf"));
	                pessoa.setDeficiencia(rs.getString("deficiencia"));
	                pessoa.setFormacaoAcademica(rs.getString("formacaoAcademica"));
	                pessoa.setDescricaoDeficiencia(rs.getString("descricaoDeficiencia"));
	                pessoa.setAreaInteresse(rs.getString("areaInteresse"));

	                // Imprime os dados da pessoa no console
	                System.out.println("ID: " + pessoa.getId());
	                System.out.println("Nome: " + pessoa.getNome());
	                System.out.println("Email: " + pessoa.getEmail());
	                System.out.println("Telefone: " + pessoa.getTelefone());
	                System.out.println("Senha: " + pessoa.getSenha());
	                System.out.println("Data de Nascimento: " + pessoa.getDataNascimento());
	                System.out.println("Gênero: " + pessoa.getGenero());
	                System.out.println("Endereço: " + pessoa.getEndereco());
	                System.out.println("Nacionalidade: " + pessoa.getNacionalidade());
	                System.out.println("CPF: " + pessoa.getCpf());
	                System.out.println("Deficiência: " + pessoa.getDeficiencia());
	                System.out.println("Formação Acadêmica: " + pessoa.getFormacaoAcademica());
	                System.out.println("Descrição da Deficiência: " + pessoa.getDescricaoDeficiencia());
	                System.out.println("Área de Interesse: " + pessoa.getAreaInteresse());
	            }
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }

	    return pessoa;
	}*/

}
