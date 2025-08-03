package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import model.Administrador;

public class AdmDao {
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
	//CRUD CREATE
	//Criar administrador
	public void criarAdm(Administrador adm) {
		String create = "insert into administrador (nivelAcesso,nome,telefone,email,senha) values(?,?,?,?,?)";
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
	
	//SELECT
	//autenticação
	public boolean autenticar(String email, String senha) {
		String administrador = "select * from Administrador where email = ? and senha = ?";
		
		try {
			//abrir a conexao com o banco
			Connection con = conectar();
			PreparedStatement pst = con.prepareStatement(administrador);
			pst.setString(1, email);
			pst.setString(2, senha);
			ResultSet rs = pst.executeQuery();
			
			return rs.next();
			
		} catch (Exception e) {
			System.out.println(e);
			return false;
		}
	}
	
	//SELECT
	public int pegarNivelAcesso(String email, String senha) {
		String nivelAcesso = "select nivelAcesso from Administrador where email = ? and senha = ?";
		
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
	
	//SELECT
	//pega o id do administrador
	public int pegarId(String email) {
		String id = "select id from Administrador where email = ?";
		
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