package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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

	// Método para buscar um usuário por ID
	public PessoaPCD buscarPorId(int id) {
		String read = "SELECT * FROM pessoaPCD WHERE id = ?";
		PessoaPCD pessoa = null;

		try {
			// Abrir a conexão com o banco de dados
			Connection con = conectar();
			// Preparar a query SQL
			PreparedStatement pst = con.prepareStatement(read);
			pst.setInt(1, id);

			// Executar a query e obter os resultados
			ResultSet rs = pst.executeQuery();

			// Verificar se o resultado existe e preencher o objeto
			if (rs.next()) {
				pessoa = new PessoaPCD();
				pessoa.setId(rs.getInt("id"));
				pessoa.setAreaInteresse(rs.getString("areaInteresse"));
				pessoa.setGenero(rs.getString("genero"));
				pessoa.setDataNascimento(rs.getString("dataNascimento"));
				pessoa.setNacionalidade(rs.getString("nacionalidade"));
				pessoa.setEndereco(rs.getString("endereco"));
				pessoa.setFormacaoAcademica(rs.getString("formacaoAcademica"));
				pessoa.setDeficiencia(rs.getString("deficiencia"));
				pessoa.setDescricaoDeficiencia(rs.getString("descricaoDeficiencia"));
			}

			// Fechar a conexão
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}

		// Retornar o objeto preenchido ou null se não encontrado
		return pessoa;
	}
}
