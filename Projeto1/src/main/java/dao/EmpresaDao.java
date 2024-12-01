package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import model.Empresa;

public class EmpresaDao {
	
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
	
	
	//Criar empresa;
	public void criarEmpresa(Empresa empresa) {
		String create = "insert into empresa (administrador_id,nomeEmpresa,cnpj,setor,site,endereco,regiaoAtuacao,programaInclusao,tipoVaga,descricaoVaga) values(?,?,?,?,?,?,?,?,?,?)";
		try {
			//abrir a conexao com o banco
			Connection con = conectar();
			//executar a query
			PreparedStatement pst = con.prepareStatement(create);
			//Colocar os valores nas variavesi do banco de dados
			pst.setInt(1, empresa.getAdm().getId());
			pst.setString(2, empresa.getNomeEmpresa());
			pst.setString(3, empresa.getCnpj());
			pst.setString(4, empresa.getSetor());
			pst.setString(5, empresa.getSite());
			pst.setString(6, empresa.getEndereco());
			pst.setString(7, empresa.getRegiaoAtuacao());
			pst.setString(8, empresa.getProgramaInclusao());
			pst.setString(9, empresa.getTipoVaga());
			pst.setString(10, empresa.getDescricaoVaga());
			
			//Executar a query
			
			pst.executeUpdate();
			
			con.close();
			
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	
	public boolean verificarEmpresa(String nome) {
		String verificar = "select nomeEmpresa from empresa where nomeEmpresa = ?";
		
		try {
			Connection con = conectar();
			PreparedStatement pst = con.prepareStatement(verificar);
			pst.setString(1, nome);
			
			ResultSet rs = pst.executeQuery();
			
			return rs.next();
			
		} catch (Exception e) {
			System.out.println(e);
			return false;
		}
	}
}
