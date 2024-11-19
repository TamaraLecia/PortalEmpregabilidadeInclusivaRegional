package com.pei.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.pei.models.PessoaComDeficiencia;

public class PessoaComDeficienciaDAO {
    private Connection connection;

    public PessoaComDeficienciaDAO(Connection connection) {
        this.connection = connection;
    }

    // Método para cadastrar uma nova pessoa com deficiência
    public boolean cadastrar(PessoaComDeficiencia pessoa) throws SQLException {
        String sql = "INSERT INTO pessoa_com_deficiencia (nome, data_nascimento, cpf, endereco, telefone, email, senha, deficiencia, formacao, experiencia) " +
                     "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, pessoa.getNome());
            stmt.setDate(2, new java.sql.Date(pessoa.getDataNascimento().getTime()));
            stmt.setString(3, pessoa.getCpf());
            stmt.setString(4, pessoa.getEndereco());
            stmt.setString(5, pessoa.getTelefone());
            stmt.setString(6, pessoa.getEmail());
            stmt.setString(7, pessoa.getSenha());
            stmt.setString(8, pessoa.getDeficiencia());
            stmt.setString(9, pessoa.getFormacao());
            stmt.setString(10, pessoa.getExperiencia());
            return stmt.executeUpdate() > 0;
        }
    }

    // Método para fazer login
    public PessoaComDeficiencia login(String email, String senha) throws SQLException {
        String sql = "SELECT * FROM pessoa_com_deficiencia WHERE email = ? AND senha = ?";

        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, email);
            stmt.setString(2, senha);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    PessoaComDeficiencia pessoa = new PessoaComDeficiencia(0, sql, null, sql, sql, sql, sql, sql, sql, sql, sql);
                    pessoa.setNome(rs.getString("nome"));
                    pessoa.setDataNascimento(rs.getDate("data_nascimento"));
                    pessoa.setCpf(rs.getString("cpf"));
                    pessoa.setEndereco(rs.getString("endereco"));
                    pessoa.setTelefone(rs.getString("telefone"));
                    pessoa.setEmail(rs.getString("email"));
                    pessoa.setSenha(rs.getString("senha"));
                    pessoa.setDeficiencia(rs.getString("deficiencia"));
                    pessoa.setFormacao(rs.getString("formacao"));
                    pessoa.setExperiencia(rs.getString("experiencia"));
                    return pessoa;
                }
            }
        }
        return null; // Retorna null se as credenciais estiverem erradas
    }

   
}