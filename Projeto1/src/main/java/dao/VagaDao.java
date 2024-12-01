package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import model.Vaga;

public class VagaDao {
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
		
		public void criarVaga(Vaga vaga) {
			String create = "insert into vaga (empresaNome,titulo,descricao,requisito,salario,localizacao,acessibilidade,dataExpiracao) values(?,?,?,?,?,?,?,?)";
			
			try {
				//abrir a conexao com o banco
				Connection con = conectar();
				PreparedStatement pst = con.prepareStatement(create);
				//colocar os valores nas variaveis do banco
				pst.setString(1, vaga.getEmpresa().getNomeEmpresa());;
				pst.setString(2, vaga.getTitulo());
				pst.setString(3, vaga.getDescricao());
				pst.setString(4, vaga.getRequisito());
				pst.setDouble(5, vaga.getSalario());
				pst.setString(6, vaga.getLocalizacao());
				pst.setString(7, vaga.getAcessibilidade());
				pst.setString(8, vaga.getDataExpiracao());
				
				//Executar a query
				pst.executeUpdate();
				
				con.close();
				
			} catch (Exception e) {
				System.out.println(e);
			}
		}
}
