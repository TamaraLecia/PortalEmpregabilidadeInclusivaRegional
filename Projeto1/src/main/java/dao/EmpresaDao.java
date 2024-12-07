package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

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
	
	//CRUD CREATE
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
	
	//SELECT
	//verificar se empresa existe atrvés do nome que é informado
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
	
	
	//SELECT
	//Listar todas as empresas dependendo do id do admistrador  informado
	public ArrayList<Empresa> listarDados(int id){
		ArrayList<Empresa> listaEmpresa = new ArrayList<>();
		
		String ler = "select nomeEmpresa, id from empresa where administrador_id  = ?";
		
		try {
			Connection con = conectar();
			PreparedStatement pst = con.prepareStatement(ler);
			pst.setInt(1, id);
			
			ResultSet rs = pst.executeQuery();
			
			while(rs.next()) {
				Empresa empresa = new Empresa();
				//Variável que recebe do banco de dados
				empresa.setNomeEmpresa(rs.getString(1));
				empresa.setId(rs.getInt(2));
				
				//popular o vetor
				listaEmpresa.add(empresa);
			}
			con.close();
			return listaEmpresa;
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}	
	}
	
	//CRUD READ
	//Listar todas as empresas dependendo do id da empresa
	public ArrayList<Empresa> mostrarDados(int id){
			ArrayList<Empresa> mostrarEmpresa = new ArrayList<>();
			
			String ler = "select * from empresa where id = ?";
			
			try {
				Connection con = conectar();
				PreparedStatement pst = con.prepareStatement(ler);
				pst.setInt(1, id);
				
				ResultSet rs = pst.executeQuery();
				
				while(rs.next()) {
					Empresa empresa = new Empresa();
					//Variável que recebe do banco de dados
					empresa.setId(rs.getInt(1));
					empresa.setNomeEmpresa(rs.getString(3));
					empresa.setCnpj(rs.getString(4));
					empresa.setSetor(rs.getString(5));
					empresa.setSite(rs.getString(6));
					empresa.setEndereco(rs.getString(7));
					empresa.setRegiaoAtuacao(rs.getString(8));
					empresa.setProgramaInclusao(rs.getString(9));
					empresa.setTipoVaga(rs.getString(10));
					empresa.setDescricaoVaga(rs.getString(11));
					
					//popular o vetor
					mostrarEmpresa.add(empresa);
				}
				con.close();
				return mostrarEmpresa;
			} catch (Exception e) {
				System.out.println(e);
				return null;
			}
			
		}
	
	//CRUD UPDATE
	//editar perfil empresa
	public void alterarPerfil(Empresa empresa) {
		String create = "UPDATE empresa SET nomeEmpresa=?, cnpj=?, setor=?, site=?, endereco=?, regiaoAtuacao=?, programaInclusao=?, descricaoVaga=? WHERE id=?";
		try { 
			Connection con = conectar(); 
			PreparedStatement pst = con.prepareStatement(create); 
			pst.setString(1, empresa.getNomeEmpresa()); 
			pst.setString(2, empresa.getCnpj());
			pst.setString(3, empresa.getSetor());
			pst.setString(4, empresa.getSite()); 
			pst.setString(5, empresa.getEndereco()); 
			pst.setString(6, empresa.getRegiaoAtuacao());
			pst.setString(7, empresa.getProgramaInclusao()); 
			pst.setString(8, empresa.getDescricaoVaga()); 
			pst.setInt(9, empresa.getId());
			
			pst.executeUpdate();
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
		
	}
	
	//CRUD SELECT
	//listar tudo de empresa independente do id
	public ArrayList<Empresa> listarTodasEmpresa() {
		ArrayList<Empresa> lista = new ArrayList<>();
		String ler2 = "select * from empresa";
		try {
			Connection con = conectar();
			PreparedStatement pst = con.prepareStatement(ler2);
			
			ResultSet rs = pst.executeQuery();
			
			while(rs.next()) {
				Empresa empresa = new Empresa();
				//Variável que recebe do banco de dados
				empresa.setId(rs.getInt(1));
				empresa.setNomeEmpresa(rs.getString(3));
				empresa.setCnpj(rs.getString(4));
				empresa.setSetor(rs.getString(5));
				empresa.setSite(rs.getString(6));
				empresa.setEndereco(rs.getString(7));
				empresa.setRegiaoAtuacao(rs.getString(8));
				empresa.setProgramaInclusao(rs.getString(9));
				empresa.setTipoVaga(rs.getString(10));
				empresa.setDescricaoVaga(rs.getString(11));
				
				//popular o vetor
				lista.add(empresa);
			}
			con.close();
			return lista;
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
		
	}
	
	//SELECT********
	//Seleciona o nome da empresa que será digitado pelo o administrador 
	//Se esse nome for igual ao do banco retorna o nome da empesa e cadastra a vaga;
	public String selecionaEmpresaNome(String empresaNome) {
		String nome = null;
		
		String select = "select nomeEmpresa from empresa where nomeEmpresa = ?";
		
		try {
			Connection con = conectar();
			PreparedStatement pst = con.prepareStatement(select);
			
			pst.setString(1, empresaNome);
			ResultSet rs = pst.executeQuery();
			
			if(rs.next()) {
				nome = rs.getString("nomeEmpresa");
				return nome;
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		return nome;
	}
	
	//****
	public String selecionarEmpresa(int id_empresa) {
		String nomeEmpresa = null;
		
		String select = "select nomeEmpresa from empresa where id =?";
		
		try {
			Connection con = conectar();
			PreparedStatement pst = con.prepareStatement(select);
			
			pst.setInt(1, id_empresa);
			ResultSet rs = pst.executeQuery();
			
			if(rs.next()) {
				nomeEmpresa = rs.getString("nomeEmpresa");
			}
		}  catch (Exception e) {
			System.out.println(e);
		}
		
		return nomeEmpresa;
	}
	
	//****
	public Empresa pegarEmpresa(int id) {
		String idEmpresa = "select nomeEmpresa from empresa where id=?";
		
		Empresa empresa = new Empresa();
		
		try {
			Connection con = conectar();
			PreparedStatement pst = con.prepareStatement(idEmpresa);
			pst.setInt(1, id);
			
			ResultSet rs = pst.executeQuery();
			
			if(rs.next()) {
				empresa.setId(rs.getInt("id"));
				empresa.setNomeEmpresa(rs.getNString("nomeEmpresa"));
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		return empresa;
	}
	
}
