<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="model.Vaga" %>
<%@ page import="dao.VagaDAO" %>
<!DOCTYPE html>
<html lang="ptbr">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Portal de Empregabilidade Inclusiva Regional</title>
  <link rel="icon" type="image/png" href="imagens/acessibilidade.png">
  <link rel="stylesheet" href="css/Vagas.css">
</head>
<body>
  <header class="header">
    <div class="logo">
      <img src="imagens/acessibilidade.png" alt="Ícone de Acessibilidade" class="logo-icon">
      <h1>Portal de Empregabilidade Inclusiva Regional</h1>
    </div>
    <nav class="menu">
      <a href="TelaInicio.jsp">Início</a>
      <a href="Sobre.html">Sobre</a>
      <a href="Login.html">Sair</a>
    </nav>
  </header>

  <main>
    <section class="search-bar">
      <input type="text" placeholder="Digite aqui para pesquisar vagas...">
      <button>Pesquisar</button>
    </section>

    <div class="job-list">
      <%
        // Instanciar DAO e buscar vagas do banco de dados
        VagaDAO vagaDAO = new VagaDAO();
        List<Vaga> vagas = vagaDAO.listarVagas();

        for (Vaga vaga : vagas) {
      %>
      <div class="job-card">
        <h2><%= vaga.getTitulo() %></h2>
        <p><strong>Empresa:</strong> <%= vaga.getEmpresaNome() %></p>
        <p><strong>Descrição:</strong> <%= vaga.getDescricao() %></p>
        <p><strong>Local:</strong> <%= vaga.getLocalizacao() %></p>
        <p><strong>Requisitos:</strong></p>
        <ul>
          <li><%= vaga.getRequisitos() %></li>
        </ul>
        <p><strong>Acessibilidade:</strong> <%= vaga.getAcessibilidade() %></p>
        <a href="cadastroConcluido.html">
          <button>Candidatar</button>
        </a>
      </div>
      <%
        }
      %>
    </div>
  </main>

  <footer class="footer">
    <p>&copy; 2024 Portal de Empregabilidade Inclusiva. Todos os direitos reservados.</p>
  </footer>
  <script src="https://vlibras.gov.br/app/vlibras-plugin.js"></script>
  <script>
    new window.VLibras.Widget('https://vlibras.gov.br/app');
  </script>
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