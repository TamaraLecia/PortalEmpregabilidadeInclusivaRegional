<%@ page import="java.util.*, java.sql.*" %>
<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<!DOCTYPE html> 
<html lang="pt-BR">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Portal de Empregabilidade Inclusiva - Vagas Ofertadas</title>
  <link rel="icon" type="image/png" href="imagens/acessibilidade.png">
  <link rel="stylesheet" href="css/VagasOfertadas.css">
</head>
<body>
  <main>
    <div class="header">
      <div class="logo">
        <img src="imagens/acessibilidade.png" alt="Acessibilidade" class="logo-icon">
        <h1>Portal de Empregabilidade Inclusiva</h1>
      </div>
    </div>

    <div class="content">
      <h2>Vagas Ofertadas</h2>
      
      <%
        // Conexão com o banco de dados
        String url = "jdbc:mysql://localhost:3306/seu_banco_de_dados"; // Substitua pelo nome do seu banco
        String usuario = "seu_usuario"; // Substitua pelo seu usuário
        String senha = "sua_senha"; // Substitua pela sua senha
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(url, usuario, senha);
            stmt = conn.createStatement();
            String query = "SELECT * FROM Vaga"; // Query para buscar todas as vagas
            rs = stmt.executeQuery(query);
            
            // Verifica se há vagas
            if (!rs.next()) {
      %>
                <p>Não há vagas cadastradas no momento.</p>
      <%
            } else {
                // Voltar para o início do ResultSet
                rs.beforeFirst(); 
                
                // Exibir as vagas
                while (rs.next()) {
      %>
                  <div class="job-card">
                    <h3><%= rs.getString("titulo") %></h3>
                    <p><strong>Empresa:</strong> <%= rs.getString("empresa") %></p>
                    <p><strong>Descrição:</strong> <%= rs.getString("requisitos") %></p>
                    <p><strong>Local:</strong> <%= rs.getString("localizacao") %></p>
                    <p><strong>Acessibilidade:</strong> <%= rs.getString("acessibilidade") %></p>
                    <p><strong>Benefícios:</strong> <%= rs.getString("beneficios") %></p>
                    <a href="cadastroConcluido.html"><button>Candidatar</button></a>
                  </div>
      <%
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (rs != null) rs.close();
                if (stmt != null) stmt.close();
                if (conn != null) conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
      %>
    </div>

    <div class="navigation-buttons">
      <button onclick="location.href='CadastrarNovaVaga.jsp'">Adicionar Nova Vaga</button>
    </div>
  </main>

  <div class="footer">
    <p>&copy; 2024 Portal de Empregabilidade Inclusiva Regional</p>
  </div>
  <div vw class="enabled">
    <div vw-access-button class="active"></div>
    <div vw-plugin-wrapper>
      <div class="vw-plugin-top-wrapper"></div>
    </div>
  </div>
  <script src="https://vlibras.gov.br/app/vlibras-plugin.js"></script>
  <script>
    new window.VLibras.Widget('https://vlibras.gov.br/app');
  </script>
</body>
</html>
