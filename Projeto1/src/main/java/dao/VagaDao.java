package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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

	public List<Vaga> listarVagas() {
    List<Vaga> vagas = new ArrayList<>();
    String query = "SELECT * FROM Vaga";
    
    try (Connection con = conectar();
         PreparedStatement pst = con.prepareStatement(query);
         ResultSet rs = pst.executeQuery()) {
        
        while (rs.next()) {
            Vaga vaga = new Vaga();
            vaga.setTitulo(rs.getString("titulo"));
            vaga.setDescricao(rs.getString("descricao"));
            vaga.setRequisitos(rs.getString("requisitos"));
            vaga.setLocalizacao(rs.getString("localizacao"));
            vaga.setAcessibilidade(rs.getString("acessibilidade"));
            vaga.setEmpresaNome(rs.getString("empresaNome"));
            vagas.add(vaga);
        }
    } catch (Exception e) {
        e.printStackTrace();
    }
    return vagas;
}

 public List<Vaga> visualizarVagas() {
        List<Vaga> vagas = new ArrayList<>();
        String query = "SELECT idVaga, titulo, requisitos, salario, localizacao, acessibilidade, empresa, beneficios FROM Vaga";

        try (Connection conexao = conectar();
             PreparedStatement stmt = conexao.prepareStatement(query);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Vaga vaga = new Vaga();
                vaga.setIdVaga(rs.getInt("idVaga"));
                vaga.setTitulo(rs.getString("titulo"));
                vaga.setRequisitos(rs.getString("requisitos"));
                vaga.setSalario(rs.getDouble("salario"));
                vaga.setLocalizacao(rs.getString("localizacao"));
                vaga.setAcessibilidade(rs.getString("acessibilidade"));
                vaga.setEmpresa(rs.getString("empresa"));
                vaga.setBeneficios(rs.getString("beneficios"));
                vagas.add(vaga);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return vagas;
    }


    public List<Vaga> visualizarVagasPorEmpresa(int idEmpresa) {
        List<Vaga> vagas = new ArrayList<>();
        String query = "SELECT idVaga, titulo, requisitos, salario, localizacao, acessibilidade, empresa, beneficios " +
                       "FROM Vaga " +
                       "WHERE idEmpresa = ?";

        try (Connection conexao = conectar();
             PreparedStatement stmt = conexao.prepareStatement(query)) {

            stmt.setInt(1, idEmpresa); // Substitui o placeholder pelo ID da empresa
            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    Vaga vaga = new Vaga();
                    vaga.setIdVaga(rs.getInt("idVaga"));
                    vaga.setTitulo(rs.getString("titulo"));
                    vaga.setRequisitos(rs.getString("requisitos"));
                    vaga.setSalario(rs.getDouble("salario"));
                    vaga.setLocalizacao(rs.getString("localizacao"));
                    vaga.setAcessibilidade(rs.getString("acessibilidade"));
                    vaga.setEmpresa(rs.getString("empresa"));
                    vaga.setBeneficios(rs.getString("beneficios"));
                    vagas.add(vaga);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return vagas;
    }
}
}