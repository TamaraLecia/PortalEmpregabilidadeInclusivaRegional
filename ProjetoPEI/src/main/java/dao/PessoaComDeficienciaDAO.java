package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class PessoaComDeficienciaDAO {
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
     // Método para buscar um usuário por ID
    public PessoaComDeficiencia buscarPorId(int id) {
        String read = "SELECT * FROM pessoa_com_deficiencia WHERE id = ?";
        PessoaComDeficiencia pessoa = null;

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
                pessoa = new PessoaComDeficiencia();
                pessoa.setId(rs.getInt("id"));
                pessoa.setAreaInteresse(rs.getString("area_interesse"));
                pessoa.setGenero(rs.getString("genero"));
                pessoa.setDataNascimento(rs.getDate("data_nascimento"));
                pessoa.setNacionalidade(rs.getString("nacionalidade"));
                pessoa.setEndereco(rs.getString("endereco"));
                pessoa.setFormacaoAcademica(rs.getString("formacao_academica"));
                pessoa.setDeficiencia(rs.getString("deficiencia"));
                pessoa.setDescricaoDeficiencia(rs.getString("descricao_deficiencia"));
            }

            // Fechar a conexão
            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }

        // Retornar o objeto preenchido ou null se não encontrado
        return pessoa;
    }

    // Método para atualizar o perfil de um usuário com deficiência
    public void atualizar(PessoaComDeficiencia pessoa) {
        String update = "UPDATE pessoa_com_deficiencia SET area_interesse = ?, genero = ?, data_nascimento = ?, "
                      + "nacionalidade = ?, endereco = ?, formacao_academica = ?, deficiencia = ?, descricao_deficiencia = ? "
                      + "WHERE id = ?";
        try {
            // Abrir a conexão com o banco de dados
            Connection con = conectar();
            // Preparar a query SQL
            PreparedStatement pst = con.prepareStatement(update);

            // Substituir os parâmetros pelos valores do objeto
            pst.setString(1, pessoa.getAreaInteresse());
            pst.setString(2, pessoa.getGenero());
            pst.setDate(3, pessoa.getDataNascimento());
            pst.setString(4, pessoa.getNacionalidade());
            pst.setString(5, pessoa.getEndereco());
            pst.setString(6, pessoa.getFormacaoAcademica());
            pst.setString(7, pessoa.getDeficiencia());
            pst.setString(8, pessoa.getDescricaoDeficiencia());
            pst.setInt(9, pessoa.getId());

            // Executar a query
            pst.executeUpdate();
            // Fechar a conexão
            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
