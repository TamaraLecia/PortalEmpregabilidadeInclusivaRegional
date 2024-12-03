package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import model.Vaga;

public class VagaDao {
	//Conexao com o banco
	private String driver = "com.mysql.cj.jdbc.Driver";
	private String url = "jdbc:mysql://127.0.0.1:3306/pei_db?useTimezone=true&serverTimezone=UTC";
	private String user = "root";
	private String password = "lecia2024";
		
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

	public void cadastrarVaga(Vaga vaga) {
	    String create = "INSERT INTO Vaga (titulo, descricao, requisitos, salario, localizacao, acessibilidade, dataExpiracao, empresaNome) " +
	                    "VALUES (?, ?, ?, ?, ?, ?, ?, (SELECT nomeEmpresa FROM empresa WHERE nomeEmpresa = ?))";
	    
	    try {
	    	Connection con = conectar();
	         PreparedStatement pst = con.prepareStatement(create);
	
	        pst.setString(1, vaga.getTitulo());
	        pst.setString(2, vaga.getDescricao());
	        pst.setString(3, vaga.getRequisito());
	        pst.setString(4, vaga.getSalario());
	        pst.setString(5, vaga.getLocalizacao());
	        pst.setString(6, vaga.getAcessibilidade());
	        pst.setString(7, vaga.getDataExpiracao());
	        pst.setString(8, vaga.getEmpresa().getNomeEmpresa()); // Supondo que a empresa tenha um método getNomeEmpresa()
	        
	        // Execute a instrução de inserção
	        pst.executeUpdate();
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	}
}