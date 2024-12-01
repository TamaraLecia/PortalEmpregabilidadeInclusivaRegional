package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import model.Administrador;

public class AdmDao {
	//Conexao com o banco
	private String driver = "com.mysql.cj.jdbc.Driver";
	private String url = "jdbc:mysql://127.0.0.1:3306/pei_db?useTimezone=true&serverTimezone=UTC";
	private String usuario = "root";
	private String senha = "lecia2024";
	
	//metodo de conexao
	
	private Connection conectar() {
		Connection con = null;
		
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, usuario, senha);
			return con;
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
	}
	
	//Criar administrador
	public void criarAdm(Administrador adm) {
		String create = "insert into administrador (acessoAdm,nome,telefone,email,senha) values(?,?,?,?,?)";
		try {
			//abrir a conexao com o banco
			Connection con = conectar();
			//executar a query
			PreparedStatement pst = con.prepareStatement(create, Statement.RETURN_GENERATED_KEYS);
			//colocar os valores nas variaveis do banco de dados
			pst.setInt(1, adm.getNivelAcesso());
			pst.setString(2, adm.getNome());
			pst.setString(3, adm.getTelefone());
			pst.setString(4, adm.getEmail());
			pst.setString(5, adm.getSenha());
			
			//Executar a query
			
			pst.executeUpdate();
			
			//pegando o id para armazenar em uma sessao
			ResultSet rs = pst.getGeneratedKeys();
			if(rs.next()) {
				adm.setId(rs.getInt(1));
			}
			
			con.close();
			
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	
	//pegar o id
	
	public boolean autenticar(String email, String senha, int nivelAcesso) {
		String administrador = "select email,senha,acessoAdm from Administrador where email = ? and senha = ? and acessoAdm = ?";
		
		try {
			//abrir a conexao com o banco
			Connection con = conectar();
			PreparedStatement pst = con.prepareStatement(administrador);
			pst.setString(1, email);
			pst.setString(2, senha);
			pst.setInt(3, nivelAcesso);
			ResultSet rs = pst.executeQuery();
			
			con.close();
			return rs.next();
			
		} catch (Exception e) {
			System.out.println(e);
			return false;
		}
	}
	
	//teste de conexao
	
	public void testeConexao() {
		try {
			Connection con = conectar();
			System.out.println(con);
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}
