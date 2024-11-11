package com.projeto_lpoo.pei.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.projeto_lpoo.pei.config.DatabaseConfig;
import com.projeto_lpoo.pei.model.Vaga;

public class VagaRepository {

    public void save(Vaga vaga) throws SQLException {
        String sql = "INSERT INTO vaga (titulo, salario, localizacao, acessibilidade, beneficios) VALUES (?, ?, ?, ?, ?)";
        try (Connection conn = DatabaseConfig.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, vaga.getTitulo());
            stmt.setDouble(2, vaga.getSalario());
            stmt.setString(3, vaga.getLocalizacao());
            stmt.setBoolean(4, vaga.getAcessibilidade());
            stmt.setString(5, vaga.getBeneficios());
            stmt.executeUpdate();
        }
    }

    public Vaga findById(int id) throws SQLException {
        String sql = "SELECT * FROM vaga WHERE idVaga = ?";
        try (Connection conn = DatabaseConfig.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setLong(1, id);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                Vaga vaga = new Vaga();
                vaga.setIdVaga(rs.getInt("idVaga"));
                vaga.setTitulo(rs.getString("titulo"));
                vaga.setSalario(rs.getDouble("salario"));
                vaga.setLocalizacao(rs.getString("localizacao"));
                vaga.setAcessibilidade(rs.getBoolean("acessibilidade"));
                vaga.setBeneficios(rs.getString("beneficios"));
                return vaga;
            }
            return null;
        }
    }

    public List<Vaga> findAll() throws SQLException {
        String sql = "SELECT * FROM vaga";
        List<Vaga> vagas = new ArrayList<>();

        try (Connection conn = DatabaseConfig.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Vaga vaga = new Vaga();
                vaga.setIdVaga(rs.getInt("idVaga"));
                vaga.setTitulo(rs.getString("titulo"));
                vaga.setSalario(rs.getDouble("salario"));
                vaga.setLocalizacao(rs.getString("localizacao"));
                vaga.setAcessibilidade(rs.getBoolean("acessibilidade"));
                vaga.setBeneficios(rs.getString("beneficios"));
                vagas.add(vaga);
            }
        }
        return vagas;
    }

    public void delete(int id) throws SQLException {
        String sql = "DELETE FROM vaga WHERE idVaga = ?";
        try (Connection conn = DatabaseConfig.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setLong(1, id);
            stmt.executeUpdate();
        }
    }
}
