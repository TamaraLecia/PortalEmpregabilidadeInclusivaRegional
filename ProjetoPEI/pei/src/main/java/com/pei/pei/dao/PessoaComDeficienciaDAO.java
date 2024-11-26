package com.pei.pei.dao;

import java.sql.Connection;

public class PessoaComDeficienciaDAO {
    private Connection connection;

    public PessoaComDeficienciaDAO(Connection connection) {
    /* 
        this.connection = connection;
    }
    // Método para cadastro primario
    public boolean cadastroPrimario(Pessoa pessoa) throws SQLException{
        String sql = "INSERT INTO pessoa(nome, telefone, email, senha)" + "VALUES(?, ?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, pessoa.getNome());            
            stmt.setString(2, pessoa.getTelefone());
            stmt.setString(3, pessoa.getEmail());
            stmt.setString(4, pessoa.getSenha());
            return stmt.executeUpdate() > 0;
        }
    }

    // Método para cadastrar uma nova pessoa com deficiência
    public boolean cadastrar(PessoaComDeficiencia pessoa) throws SQLException {
        String sql = "INSERT INTO pessoa_com_deficiencia (interesse, genero, dataNascimento, nacionalidade, endereco, formacao, deficiencia, cpf, descricao) " +
                 "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";

    try (PreparedStatement stmt = connection.prepareStatement(sql)) {
        stmt.setString(1, pessoa.getInteresse());
        stmt.setString(2, pessoa.getGenero());
        stmt.setDate(3, new java.sql.Date(pessoa.getDataNascimento().getTime()));
        stmt.setString(4, pessoa.getNacionalidade());
        stmt.setString(5, pessoa.getEndereco());
        stmt.setString(6, pessoa.getFormacao());
        stmt.setString(7, pessoa.getDeficiencia());
        stmt.setString(8, pessoa.getCpf());
        stmt.setString(9, pessoa.getDescricao());
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

    //Método para visualizar perfil
    public PessoaComDeficiencia visualizarPerfil(int idPessoa) {
        String sql = "SELECT * FROM pessoa_com_deficiencia WHERE id = ?";
        PessoaComDeficiencia pessoa = null;

        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, idPessoa);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    pessoa = new PessoaComDeficiencia(
                        rs.getLong("id"),
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
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Erro ao buscar perfil: " + e.getMessage());
        }

        return pessoa; 
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


    //Metodo para remover formação
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

    //Metodo para remover experiencia
    public void removerExperiencia(Integer id){
        String sql = "DELETE experiencia FROM pessoa_com_deficiencia WHERE id = ?";
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
                pessoasComDeficiencia.setExperiencia(rset.getString("experiencia"));
    
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

       //Método para atualizar os dados da Pessoa Com Deficiencia
       public void alterarPessoaComDeficiencia(PessoaComDeficiencia pessoaComDeficiencia){
        try {
            Connection con = DataBaseConfiguracao.conectar();
            PreparedStatement pstm = con.prepareStatement("UPDATE pessoa_com_deficiencia SET mome = ?, dataNascimento = ?, cpf = ?, genero = ?, endereco = ?, nacionalidade = ?, deficiencia = ?, areaInteresse = ?, formacao = ?, descricao = ? WHERE id = ? ");
            
            pstm.setString(1,pessoaComDeficiencia.getNome());
            pstm.setDate(2, new Date(pessoaComDeficiencia.getDataNascimento().getTime()));
            pstm.setString(3, pessoaComDeficiencia.getCpf());
            pstm.setString(4, pessoaComDeficiencia.getGenero());
            pstm.setString(5, pessoaComDeficiencia.getNacionalidade());
            pstm.setString(6, pessoaComDeficiencia.getDeficiencia());
            pstm.setString(7, pessoaComDeficiencia.getInteresse());
            pstm.setString(8, pessoaComDeficiencia.getFormacao());
            pstm.setString(9, pessoaComDeficiencia.getDescricao());
            pstm.setInt(10, pessoaComDeficiencia.getId());

            pstm.executeUpdate();

            
        } catch (Exception e) {
            System.out.println("Erro ao alterar informação " + e);
        }
    }
    

   */
}
}