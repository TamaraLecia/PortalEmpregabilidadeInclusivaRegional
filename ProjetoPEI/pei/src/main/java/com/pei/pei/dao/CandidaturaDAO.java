package com.pei.pei.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;



public class CandidaturaDAO {
    private Connection connection;

    public CandidaturaDAO(Connection connection) {
        this.connection = connection;
    }

    public boolean cadastrarCandidatura(int idPessoa, int idVaga) throws SQLException {
        String sql = "INSERT INTO candidatura (id_pessoa, id_vaga) VALUES (?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, idPessoa);
            stmt.setInt(2, idVaga);
            int rowsAffected = stmt.executeUpdate();
            return rowsAffected > 0;
        }
    }

}
