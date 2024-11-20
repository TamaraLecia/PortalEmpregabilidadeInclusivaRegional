package com.pei.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.pei.models.PessoaComDeficiencia;
import com.pei.models.Vaga;

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

        //Metodo para buscar vaga
    public List<Vaga> bucarVaga(String titulo, String localizacao){
        String sql = "SELECT * FROM pessoa_com_deficiencia WHERE titulo = ? || localizacao = ? ";
        List<Vaga> vagas = new ArrayList<Vaga>();

        Connection con = null;
        PreparedStatement pstm = null;
        //recupera os dados do banco
        ResultSet rset = null;

        try {
            con = DataBaseConfiguracao.conectar();
            
            pstm = (PreparedStatement) con.prepareStatement(sql);
            rset = pstm.executeQuery();

            while (rset.next()) {
                Vaga vaga = new Vaga();

                vaga.setIdVaga(rset.getInt("id"));
                vaga.setTitulo(rset.getString("titulo"));
                vaga.setRequisitos(rset.getString("requisitos"));
                vaga.setSalario(rset.getDouble("salario"));
                vaga.setLocalizacao(rset.getString("localizacao"));
                vaga.setAcessibilidade(rset.getString("acessibilidade"));
                vaga.setEmpresa(rset.getString("empresa"));
                vaga.setBeneficios(rset.getString("beneficios"));

                vagas.add(vaga);
                return vagas;

            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            try {
                if(rset != null){
                    rset.close();
                }
                if(pstm != null){
                    pstm.close();
                }
                if(con != null ){
                    con.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return bucarVaga(titulo, localizacao);
    }

    //Metodo para remover experiencia
    public void removerFormacao(Integer id){
        String sql = "DELETE formacao FROM pessoa_com_deficiencia WHERE id = ?";
        List<PessoaComDeficiencia> pessoaComDeficiencias = new ArrayList<PessoaComDeficiencia>();

        Connection con = null;
        PreparedStatement pstm = null;
        ResultSet rset = null;

        try {
            con = DataBaseConfiguracao.conectar();

            pstm = (PreparedStatement) con.prepareStatement(sql);
            rset = pstm.executeQuery();

            while(rset.next()){
                PessoaComDeficiencia pessoasComDeficiencia = new PessoaComDeficiencia(0, sql, null, sql, sql, sql, sql, sql, sql, sql, sql);
                pessoasComDeficiencia.setFormacao(rset.getString("formacao"));

                pessoaComDeficiencias.remove(pessoasComDeficiencia);
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            try {
                if(rset != null){
                    rset.close();
                }
                if(pstm != null){
                    pstm.close();
                }
                if(con != null ){
                    con.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

   
}