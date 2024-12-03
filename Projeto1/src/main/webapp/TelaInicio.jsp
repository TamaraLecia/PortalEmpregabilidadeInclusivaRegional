<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ page import="model.Empresa"%>
<%@ page import="java.util.ArrayList"%>
<%
	ArrayList<Empresa> lista = (ArrayList<Empresa>) request.getAttribute("lista");
%>

<!DOCTYPE html>
<html lang="pt-br">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Portal de Empregabilidade Inclusiva</title>
  <link rel="icon" type="image/png" href="imagens/acessibilidade.png">
  <link rel="stylesheet" href="css/TelaInicio.css">
</head>
<body>
  <aside>
    <h2>Menu</h2>
    <ul>
      <li class="dropdown">
        <a href="#opcao2">Trabalhador</a>
        <ul class="dropdown-content">
          <li><a href="https://www.gov.br/trabalho-e-emprego/pt-br/servicos/trabalhador/carteira-de-trabalho">Carteira de trabalho digital</a></li>
        </ul>
      </li>
      <li class="dropdown">
        <a href="#opcao3">Outros</a>
        <ul class="dropdown-content">
          <li><a href="https://www.gov.br/governodigital/pt-br/acessibilidade-e-usuario/vlibras">VLibras</a></li>
        </ul>
      </li>
  </aside>

  <main>
    <header class="header">
      <div class="logo">
        <img src="imagens/acessibilidade.png" alt="Ícone de Acessibilidade" class="logo-icon">
        <h1>Portal de Empregabilidade Inclusiva Regional</h1>
      </div>
      <nav class="menu">
        <a href="Sobre.html">Sobre</a>
        <a href="login">Login</a>
        <a href="principal">Criar Conta</a>
      </nav>
    </header>

    <section class="search-bar">
      <input type="text" placeholder="Buscar no portal...">
      <button>Pesquisar</button>
    </section>

    <section class="navigation-buttons">
      <a href="Vagas.html">
        <button>Vagas disponíveis</button>
      </a>
      <a href="CriarContaUsuario.html">
        <button>Cadastrar Usuário</button>
      </a>
    </section>

    <div class="content">
      <p>O portal de empregabilidade digital. Confira quais são as cidades que possui alguma empresa cadastrada:</p>
      <%if(lista != null) {%>
      <ol>
      <%for(Empresa empresa : lista){ %>
        <li><%=empresa.getEndereco()%></li>
        <%}%>
      </ol>

      <h2>Endereços relacionados:</h2>

    <div class="address">
    <%for(Empresa empresa: lista) {%>
      <h3><%=empresa.getNomeEmpresa() %></h3>
      <p><%=empresa.getEndereco() %></p>
      <p><strong>Contatos:</strong></p>
      <p><%=empresa.getSite() %></p>
     <br>
     <%}%>
    </div>
	<%}%><%else{ %>
		<input type="text" value="Não há nenhuma empresa Cadastrada">
	<%} %>
    <footer class="footer">
      <p>Contato: 3451-9078</p>
      <p>Email: portalempregabilidade@gmail.com</p>
    </footer>
  </main>
</body>
</html>