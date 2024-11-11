package com.projeto_lpoo.pei.repository;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.projeto_lpoo.pei.config.DatabaseConfig;
import com.projeto_lpoo.pei.model.Candidatura;
import com.projeto_lpoo.pei.model.Experiencia;
import com.projeto_lpoo.pei.model.Formacao;
import com.projeto_lpoo.pei.model.Pessoa;
import com.projeto_lpoo.pei.model.PessoaComDeficiencia;
import com.projeto_lpoo.pei.model.Vaga;

public class PessoaComDeficienciaRepository {
    private Connection connection;


    public void save(Pessoa pessoa) throws SQLException {
        String sql = "INSERT INTO pessoa (nome, dataNascimento, cpf, endereco, telefone, email, senha) VALUES (?, ?, ?, ?, ?, ?, ?)";
        try (Connection conn = DatabaseConfig.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, pessoa.getNome());
            stmt.setDate(2, new java.sql.Date(pessoa.getDataNascimento().getTime()));
            stmt.setString(3, pessoa.getCpf());
            stmt.setString(4, pessoa.getEndereco());
            stmt.setString(5, pessoa.getTelefone());
            stmt.setString(6, pessoa.getEmail());
            stmt.setString(7, pessoa.getSenha());
            stmt.executeUpdate();
        }
    }

    public Pessoa findById(int id) throws SQLException {
        String sql = "SELECT * FROM pessoa WHERE id = ?";
        try (Connection conn = DatabaseConfig.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id); 
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                Pessoa pessoa = new Pessoa();
                

                pessoa.setId(rs.getInt("id"));
                pessoa.setNome(rs.getString("nome"));
                pessoa.setDataNascimento(rs.getDate("dataNascimento"));
                pessoa.setCpf(rs.getString("cpf"));
                pessoa.setEndereco(rs.getString("endereco"));
                pessoa.setTelefone(rs.getString("telefone"));
                pessoa.setEmail(rs.getString("email"));
                pessoa.setSenha(rs.getString("senha"));             

                if (pessoa instanceof PessoaComDeficiencia) {
                    return (PessoaComDeficiencia) pessoa;
                } else {
                    return null; // ou lançar uma exceção específica
                }
            }         
            return null;
        }
    }

    public List<Pessoa> findAll() throws SQLException {
        String sql = "SELECT * FROM pessoa";
        List<Pessoa> pessoas = new ArrayList<>();

        try (Connection conn = DatabaseConfig.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Pessoa pessoa = new Pessoa();
                pessoa.setId(rs.getInt("id"));
                pessoa.setNome(rs.getString("nome"));
                pessoa.setDataNascimento(rs.getDate("dataNascimento"));
                pessoa.setCpf(rs.getString("cpf"));
                pessoa.setEndereco(rs.getString("endereco"));
                pessoa.setTelefone(rs.getString("telefone"));
                pessoa.setEmail(rs.getString("email"));
                pessoa.setSenha(rs.getString("senha"));
                pessoas.add(pessoa);
            }
        }
        return pessoas;
    }

    public void delete(int id) throws SQLException {
        String sql = "DELETE FROM pessoa WHERE id = ?";
        try (Connection conn = DatabaseConfig.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            stmt.executeUpdate();
        }
    }


    //Candidatura
        public void saveCandidatura(Candidatura candidatura) throws SQLException {
        String sql = "INSERT INTO candidatura (idVaga, idPessoa, dataCandidatura, statusCandidatura) VALUES (?, ?, ?, ?)";
        try (Connection conn = DatabaseConfig.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setLong(1, candidatura.getVaga().getIdVaga());
            stmt.setLong(2, candidatura.getPessoa().getId());
            stmt.setDate(3, new java.sql.Date(candidatura.getDataCandidatura().getTime()));
            stmt.setString(4, candidatura.getStatusCandidatura());
            stmt.executeUpdate();
        }
    }

    public Candidatura findCandidaturaById(int id) throws SQLException {
        String sql = "SELECT * FROM candidatura WHERE idCandidatura = ?";
        try (Connection conn = DatabaseConfig.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                Candidatura candidatura = new Candidatura();
                candidatura.setIdCandidatura(rs.getInt("idCandidatura"));
                
                Vaga vaga = new VagaRepository().findById(rs.getInt("idVaga"));
                PessoaComDeficiencia pessoa = (PessoaComDeficiencia) new PessoaComDeficienciaRepository().findById(rs.getInt("idPessoa"));

                candidatura.setVaga(vaga);
                candidatura.setPessoa(pessoa);
                candidatura.setDataCandidatura(rs.getDate("dataCandidatura"));
                candidatura.setStatusCandidatura(rs.getString("statusCandidatura"));
                return candidatura;
            }
            return null;
        }
    }

    public List<Candidatura> findAllCandidatura() throws SQLException {
        String sql = "SELECT * FROM candidatura";
        List<Candidatura> candidaturas = new ArrayList<>();

        try (Connection conn = DatabaseConfig.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Candidatura candidatura = new Candidatura();
                candidatura.setIdCandidatura(rs.getInt("idCandidatura"));
                
                Vaga vaga = new VagaRepository().findById(rs.getInt("idVaga"));
                PessoaComDeficiencia pessoa = (PessoaComDeficiencia) new PessoaComDeficienciaRepository().findById(rs.getInt("idPessoa"));

                candidatura.setVaga(vaga);
                candidatura.setPessoa(pessoa);
                candidatura.setDataCandidatura(rs.getDate("dataCandidatura"));
                candidatura.setStatusCandidatura(rs.getString("statusCandidatura"));
                candidaturas.add(candidatura);
            }
        }
        return candidaturas;
    }

    public void deleteCandidatura(int id) throws SQLException {
        String sql = "DELETE FROM candidatura WHERE idCandidatura = ?";
        try (Connection conn = DatabaseConfig.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            stmt.executeUpdate();
        }
    }

    //Experiencia

    public boolean adicionarExperiencia(PessoaComDeficiencia pessoa, Experiencia experiencia) {
        String sql = "INSERT INTO experienciasProfissionais (pessoaId, empresa, cargo, dataInicio, dataFim) " +
                     "VALUES (?, ?, ?, ?, ?)";

        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, pessoa.getId()); 
            statement.setString(2, experiencia.getNomeEmpresa());
            statement.setString(3, experiencia.getCargo());
            statement.setDate(4, new java.sql.Date(experiencia.getDataInicio().getTime()));
            statement.setDate(5, new java.sql.Date(experiencia.getDataFim().getTime()));

            int rowsInserted = statement.executeUpdate();
            return rowsInserted > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false; 
        }
    }

    public boolean adicionarFormacao(PessoaComDeficiencia pessoa, Formacao formacao) {
        String sql = "INSERT INTO formacoesAcademicas (pessoaId, instituicao, curso, dataConclusao) " +
                     "VALUES (?, ?, ?, ?, ?)";

        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, pessoa.getId()); 
            statement.setString(2, formacao.getNomeInstituicao());
            statement.setString(4, formacao.getCurso());
            statement.setDate(5, new java.sql.Date(formacao.getDataConclusao().getTime()));

            int rowsInserted = statement.executeUpdate();
            return rowsInserted > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false; 
        }
    }

    
    
}
