package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class AdmDAO {
	/* MODULO DE CONEXÃO */
	//PARAMETRO DE CONEXAO
	private String driver = "com.mysql.cj.jdbc.Driver";
	private String url = "jdbc:mysql://127.0.0.1:3306/pei_db?useTimezone=true&serverTimezone=UTC";
	private String user = "root";
	private String password = "lecia2024";
	
		
	//MÉTODO DE CONEXÃO
	
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
	
	//Crud Create
	public void criarADM(Administrador adm) {
		String create = "insert into administrador (nome, telefone, email, senha) values(?,?,?,?)";
		try {
			//abrir a conexao
			Connection con = conectar();
			//Preparar a query para a execução no banco de dados
			PreparedStatement pst = con.prepareStatement(create);
			//substituir os paramentros das variaveis
			pst.setString(1, adm.getNome());
			pst.setString(2, adm.getTelefone());
			pst.setString(3, adm.getEmail());
			pst.setString(4, adm.getSenha());
			//executar a query
			pst.executeUpdate();
			//fechar a conexao
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	
	/*
	//teste de conexão
	public void testeConexao() {
		try {
			Connection con = conectar();
			System.out.println(con);
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}*/
	
}
