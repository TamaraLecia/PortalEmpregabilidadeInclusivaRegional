package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import model.Empresa;

public class EmpresaDAO {
    // Parâmetros de conexão com o banco de dados
    private String driver = "com.mysql.cj.jdbc.Driver";
    private String url = "jdbc:mysql://127.0.0.1:3306/pei_db?useTimezone=true&serverTimezone=UTC";
    private String user = "root";
    private String password = "lecia2024";

    // Método para conectar ao banco de dados
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

    // Método para buscar uma empresa por ID
    public Empresa buscarPorId(int id) {
        String read = "SELECT * FROM empresa WHERE id = ?";
        Empresa empresa = null;

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
                empresa = new Empresa();
                empresa.setId(rs.getInt("id"));
                empresa.setNome(rs.getString("nome"));
                empresa.setCnpj(rs.getString("cnpj"));
                empresa.setSetorAtuacao(rs.getString("setor_atuacao"));
                empresa.setSite(rs.getString("site"));
                empresa.setEndereco(rs.getString("endereco"));
                empresa.setRegiao(rs.getString("regiao"));
                empresa.setInclusao(rs.getString("inclusao"));
                empresa.setDescricao(rs.getString("descricao"));
            }

            // Fechar a conexão
            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }

        // Retornar o objeto preenchido ou null se não encontrado
        return empresa;
    }

    public void atualizar(Empresa empresa) {
    String update = "UPDATE empresa SET nome = ?, cnpj = ?, setor_atuacao = ?, site = ?, endereco = ?, regiao = ?, inclusao = ?, descricao = ? WHERE id = ?";

    try {
        // Abrir a conexão com o banco de dados
        Connection con = conectar();
        // Preparar a query SQL
        PreparedStatement pst = con.prepareStatement(update);

        // Substituir os parâmetros da query
        pst.setString(1, empresa.getNome());
        pst.setString(2, empresa.getCnpj());
        pst.setString(3, empresa.getSetorAtuacao());
        pst.setString(4, empresa.getSite());
        pst.setString(5, empresa.getEndereco());
        pst.setString(6, empresa.getRegiao());
        pst.setString(7, empresa.getInclusao());
        pst.setString(8, empresa.getDescricao());
        pst.setInt(9, empresa.getId());

        // Executar a atualização no banco
        pst.executeUpdate();

        // Fechar a conexão
        con.close();
    } catch (Exception e) {
        System.out.println(e);
    }
}
}
