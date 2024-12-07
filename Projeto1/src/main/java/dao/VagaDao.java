package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

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
	
	//CRUD CREATE
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
	
	
	//Lista todas as vagas que o administrador está ofertando na sua empresa
	/*public ArrayList<Vaga> listaVagasAdm(String nome){
		ArrayList<Vaga> listaVaga = new ArrayList<>();
		
		String ler = "Select * from vaga where empresaNome = ?";
		
		try {
			Connection con = conectar();
			PreparedStatement pst = con.prepareStatement(ler);
			pst.setString(1, nome);
			
			ResultSet rs = pst.executeQuery();
			
			while(rs.next()) {
				Vaga vaga = new Vaga();
				vaga.setId(rs.getInt(1));
				vaga.setTitulo(rs.getString(3));
				vaga.setDescricao(rs.getString(4));
				vaga.setRequisito(rs.getString(5));
				vaga.setSalario(rs.getString(6));
				vaga.setLocalizacao(rs.getString(7));
				vaga.setAcessibilidade(rs.getString(8));
				vaga.setDataExpiracao(rs.getString(9));
				
				//popular o vetor
				listaVaga.add(vaga);
			}
			con.close();
			return listaVaga;
		} catch (Exception e) {
			return null;
		}
	}*/
	
	//lista todas as vagas
	public ArrayList<Vaga> listaVagas(){
		ArrayList<Vaga> listaVaga = new ArrayList<>();
		
		String ler = "Select * from vaga";
		
		try {
			Connection con = conectar();
			PreparedStatement pst = con.prepareStatement(ler);
			
			ResultSet rs = pst.executeQuery();
			
			while(rs.next()) {
				Vaga vaga = new Vaga();
				vaga.setId(rs.getInt(1));
				vaga.setTitulo(rs.getString(3));
				vaga.setDescricao(rs.getString(4));
				vaga.setRequisito(rs.getString(5));
				vaga.setSalario(rs.getString(6));
				vaga.setLocalizacao(rs.getString(7));
				vaga.setAcessibilidade(rs.getString(8));
				vaga.setDataExpiracao(rs.getString(9));
				
				//popular o vetor
				listaVaga.add(vaga);
			}
			con.close();
			return listaVaga;
		} catch (Exception e) {
			return null;
		}
	}
	
	
}