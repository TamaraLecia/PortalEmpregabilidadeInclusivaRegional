package com.pei.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.pei.model.Administrador;
import com.pei.model.Capacitacao;
import com.pei.model.PessoaComDeficiencia;
import com.pei.model.Vaga;

public class AdministradorDAO {
    /* 
    private Connection connection;

    public AdministradorDAO(Connection connection) {
        this.connection = connection;
    }

    // Método para publicar uma nova vaga
    public int publicarVaga(Vaga vaga) {
        String sql = "INSERT INTO vaga (titulo, requisitos, salario, localizacao, acessibilidade, empresa, beneficios) " +
                     "VALUES (?, ?, ?, ?, ?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS)) {
            stmt.setString(1, vaga.getTitulo());
            stmt.setString(2, vaga.getRequisitos());
            stmt.setDouble(3, vaga.getSalario());
            stmt.setString(4, vaga.getLocalizacao());
            stmt.setString(5, vaga.getAcessibilidade());
            stmt.setString(6, vaga.getEmpresa());
            stmt.setString(7, vaga.getBeneficios());
            stmt.executeUpdate();
    
            // Recupera o ID gerado
            try (ResultSet rs = stmt.getGeneratedKeys()) {
                if (rs.next()) {
                    return rs.getInt(1); // Retorna o ID da vaga recém-criada
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Erro ao publicar a vaga: " + e.getMessage());
        }
        return -1; // Retorna -1 em caso de falha
    }

  // Método para visualizar os candidatos de uma vaga específica
  public List<PessoaComDeficiencia> visualizarCandidatosPorVaga(int idVaga) {
    String sql = """
        SELECT p.id, p.nome, p.dataNascimento, p.cpf, p.endereco, p.telefone, p.email,
               p.deficiencia, p.formacao, p.experiencia
        FROM candidatura c
        INNER JOIN pessoa_com_deficiencia p ON c.idPessoa = p.id
        WHERE c.idVaga = ?
    """;

    List<PessoaComDeficiencia> candidatos = new ArrayList<>();

    try (PreparedStatement stmt = connection.prepareStatement(sql)) {
        stmt.setInt(1, idVaga);

        try (ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                PessoaComDeficiencia pessoa = new PessoaComDeficiencia(
                    rs.getInt("id"),
                    rs.getString("nome"),
                    rs.getDate("dataNascimento"),
                    rs.getString("cpf"),
                    rs.getString("endereco"),
                    rs.getString("telefone"),
                    rs.getString("email"),
                    rs.getString("senha"),
                    rs.getString("deficiencia"),
                    rs.getString("formacao"),
                    rs.getString("experiencia")
                );
                candidatos.add(pessoa);
            }
        }
    } catch (SQLException e) {
        System.out.println("Erro ao buscar candidatos: " + e.getMessage());
        e.printStackTrace();
    }

    return candidatos;
}

// Método para realizar login
    public Administrador login(String email, String senha) {
        String sql = "SELECT * FROM administrador WHERE email = ? AND senha = ?";
        Administrador administrador = null;

        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, email);
            stmt.setString(2, senha);

            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                   administrador = new Administrador(
                        rs.getInt("id"),
                        rs.getString("nome"),
                        rs.getDate("dataNascimento"),
                        rs.getString("cpf"),
                        rs.getString("endereco"),
                        rs.getString("telefone"),
                        rs.getString("email"),
                        rs.getString("senha")
                    );
                }
            }
        } catch (SQLException e) {
            System.out.println("Erro ao realizar login: " + e.getMessage());
            e.printStackTrace();
        }

        return administrador;
    }

    //Método para atualizar os dados da capacitação
    public void alterarCapacitacao(Capacitacao capacitacao){
        try {
            Connection con = DataBaseConfiguracao.conectar();
            PreparedStatement pstm = con.prepareStatement("UPDATE capacitaco SET titulo = ?, descricaoo = ?, dataInicio = ?, dataFim = ?, instrutor = ?, publicoAlvo = ? WHERE id = ? ");
            
            pstm.setString(1, capacitacao.getTituloCapacitacao());
            pstm.setString(2, capacitacao.getDescriçãoCapacitação());
            pstm.setDate(3, new Date(capacitacao.getDataInicioCapacitacao().getTime()));
            pstm.setDate(4, new Date(capacitacao.getDataFimCapacitacao().getTime()));
            pstm.setString(5, capacitacao.getInstrutorCapacitaca());
            pstm.setString(5, capacitacao.getPublicoAlvos());
            pstm.setInt(7,capacitacao.getIdCapacitacao());

            pstm.executeUpdate();

            
        } catch (Exception e) {
            System.out.println("Erro ao alterar informação " + e);
        }
    }
        */
}
