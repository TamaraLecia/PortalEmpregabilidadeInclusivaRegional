package com.projeto_lpoo.pei.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.projeto_lpoo.pei.model.Capacitacao;
import com.projeto_lpoo.pei.model.PessoaComDeficiencia;
import com.projeto_lpoo.pei.model.Vaga;


public class AdministradorRepository {
    private Connection connection;

    public AdministradorRepository(Connection connection) {
        this.connection = connection;
    }

    //Gerencia de vagas
    public void adicionarVaga(Vaga vaga) {
        String sql = "INSERT INTO vaga (titulo, descricao, salario, requisitos) VALUES (?, ?, ?, ?)";

        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, vaga.getTitulo());
            stmt.setString(2, vaga.getDescricao());
            stmt.setDouble(3, vaga.getSalario());
            stmt.setString(4, vaga.getRequisitos());

            int rowsInserted = stmt.executeUpdate();
            if (rowsInserted > 0) {
                System.out.println("Vaga adicionada com sucesso!");
            }
        } catch (SQLException e) {
            System.out.println("Erro ao adicionar vaga: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public void removerVaga(int idVaga) {
        String sql = "DELETE FROM vaga WHERE idVaga = ?";

        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, idVaga);

            int rowsDeleted = stmt.executeUpdate();
            if (rowsDeleted > 0) {
                System.out.println("Vaga removida com sucesso!");
            } else {
                System.out.println("Nenhuma vaga encontrada com o ID fornecido.");
            }
        } catch (SQLException e) {
            System.out.println("Erro ao remover vaga: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public List<Vaga> listarVagas() {
        String sql = "SELECT idVaga, titulo, descricao, salario, requisitos FROM vaga";
        List<Vaga> vagas = new ArrayList<>();

        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                int idVaga = rs.getInt("idVaga");
                String titulo = rs.getString("titulo");
                String descricao = rs.getString("descricao");  
                double salario = rs.getDouble("salario");    
                String requisitos = rs.getString("requisitos"); 

                Vaga vaga = new Vaga(idVaga, titulo, descricao, salario, requisitos);
                vagas.add(vaga);
            }
        } catch (SQLException e) {
            System.out.println("Erro ao listar vagas: " + e.getMessage());
            e.printStackTrace();
        }

        return vagas;
    }

    public boolean atualizarVaga(Vaga vaga) {
        String sql = "UPDATE vagas SET descricao = ?, requisitos = ? WHERE id = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, vaga.getDescricao());
            statement.setString(2, vaga.getRequisitos());
            statement.setInt(3, vaga.getIdVaga()); 

            int rowsUpdated = statement.executeUpdate();
            return rowsUpdated > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    //Gerencia de candidatos

    public List<PessoaComDeficiencia> listarCandidatos() {
        List<PessoaComDeficiencia> candidatos = new ArrayList<>();
        String sql = "SELECT p.*, c.deficiencia, c.curriculo" +
                     "FROM pessoas p " + 
                     "JOIN candidaturas c ON p.id = c.pessoa_id"; 

        try (PreparedStatement statement = connection.prepareStatement(sql);
             ResultSet resultSet = statement.executeQuery()) {

            while (resultSet.next()) {
                PessoaComDeficiencia candidato = new PessoaComDeficiencia();
                candidato.setNome(resultSet.getString("nome"));
                candidato.setDataNascimento(resultSet.getDate("data_nascimento")); 
                candidato.setCpf(resultSet.getString("cpf"));
                candidato.setEndereco(resultSet.getString("endereco"));
                candidato.setTelefone(resultSet.getString("telefone"));
                candidato.setEmail(resultSet.getString("email"));
                candidato.setSenha(resultSet.getString("senha"));
                candidato.setDeficiencia(resultSet.getString("deficiencia"));
                candidatos.add(candidato);
            }
        } catch (SQLException e) {
            e.printStackTrace(); 
        }
        return candidatos; 
    }

    public boolean contratarCandidato(PessoaComDeficiencia pessoaComDeficiencia) {
        String sql = "UPDATE candidaturas SET status = 'contratado' WHERE pessoa_id = ?";
        
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, pessoaComDeficiencia.getId()); 

            int rowsUpdated = statement.executeUpdate();
            return rowsUpdated > 0; 
        } catch (SQLException e) {
            e.printStackTrace();
            return false; 

        }
    }

    public PessoaComDeficiencia buscarCandidatoPeloNome(String nome) {
        String sql = "SELECT p.*, c.deficiencia, c.curriculo, c.experiencia_profissional, c.formacao_academica " +
                     "FROM pessoas p " +
                     "JOIN candidaturas c ON p.id = c.pessoa_id " +
                     "WHERE p.nome = ?";

        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, nome);

            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    PessoaComDeficiencia candidato = new PessoaComDeficiencia();
                    candidato.setNome(resultSet.getString("nome"));
                    candidato.setDataNascimento(resultSet.getDate("data_nascimento"));
                    candidato.setCpf(resultSet.getString("cpf"));
                    candidato.setEndereco(resultSet.getString("endereco"));
                    candidato.setTelefone(resultSet.getString("telefone"));
                    candidato.setEmail(resultSet.getString("email"));
                    candidato.setSenha(resultSet.getString("senha"));
                    candidato.setDeficiencia(resultSet.getString("deficiencia"));

                    return candidato; 
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    //Gerencia de capacitação

     public boolean adicionarCapacitacao(PessoaComDeficiencia pessoaComDeficiencia, Capacitacao capacitacao) {
        String sql = "INSERT INTO capacitacoes (pessoa_id, titulo, descricao, data_inicio, data_fim) VALUES (?, ?, ?, ?, ?)";

        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, pessoaComDeficiencia.getId()); 
            statement.setString(2, capacitacao.getTitulo());
            statement.setString(3, capacitacao.getDescricao());
            statement.setDate(4, new java.sql.Date(capacitacao.getDataInicio().getTime()));
            statement.setDate(5, new java.sql.Date(capacitacao.getDataFim().getTime()));

            int rowsInserted = statement.executeUpdate();
            return rowsInserted > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false; 
        }
    }

    public boolean atualizarCapacitacao(PessoaComDeficiencia pessoaComDeficiencia, Capacitacao capacitacao) {
        String sql = "UPDATE capacitacoes SET titulo = ?, descricao = ?, data_inicio = ?, data_fim = ? " +
                     "WHERE pessoa_id = ? AND id = ?";

        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, capacitacao.getTitulo());
            statement.setString(2, capacitacao.getDescricao());
            statement.setDate(3, new java.sql.Date(capacitacao.getDataInicio().getTime()));
            statement.setDate(4, new java.sql.Date(capacitacao.getDataFim().getTime()));
            statement.setInt(5, pessoaComDeficiencia.getId()); 
            statement.setInt(6, capacitacao.getId()); 

            int rowsUpdated = statement.executeUpdate();
            return rowsUpdated > 0; 
        } catch (SQLException e) {
            e.printStackTrace();
            return false; 
        }
    }

    public List<Capacitacao> visualizarCapacitacoes(PessoaComDeficiencia pessoaComDeficiencia) {
        List<Capacitacao> capacitacoes = new ArrayList<>();
        String sql = "SELECT * FROM capacitacoes WHERE pessoa_id = ?";

        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, pessoaComDeficiencia.getId()); 

            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    Capacitacao capacitacao = new Capacitacao();
                    capacitacao.setId(resultSet.getInt("id"));
                    capacitacao.setTitulo(resultSet.getString("titulo"));
                    capacitacao.setDescricao(resultSet.getString("descricao"));
                    capacitacao.setDataInicio(resultSet.getDate("data_inicio"));
                    capacitacao.setDataFim(resultSet.getDate("data_fim"));

                    capacitacoes.add(capacitacao); 
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return capacitacoes;
    }



}

