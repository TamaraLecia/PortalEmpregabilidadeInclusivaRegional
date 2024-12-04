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
  <link rel="stylesheet" href="css/TelaInicioEmpresa.css">
</head>
<body>
  <aside>
    <h2>Menu</h2>
    <ul>
      </li>
      <li class="dropdown">
        <a href="#opcao3">Empresa</a>
        <ul class="dropdown-content">
          <li><a href="CadastrarVaga.jsp">Cadastrar Vaga</a></li>
        </ul>
      </li>
      <li class="dropdown">
        <a href="#opcao3">Perfil</a>
        <ul class="dropdown-content">
          <li><a href= "verNomeEmpresa">Perfil da empresa</a></li>
        </ul>
      </li>
      <li class="dropdown">
        <a href="#opcao3">Outros</a>
        <ul class="dropdown-content">
          <li><a href="https://www.gov.br/governodigital/pt-br/acessibilidade-e-usuario/vlibras">VLibras</a></li>
        </ul>
      </li>
      <li><a href="#opcao4">Sair</a></li>
      <li class="dropdown">
    </ul>
  </aside>

  <main>
    <header class="header">
      <div class="logo">
        <img src="imagens/acessibilidade.png" alt="Ãcone de Acessibilidade" class="logo-icon">
        <h1>Portal de Empregabilidade Inclusiva Regional</h1>
      </div>
      <nav class="menu">
        <a href="Sobre.html">Sobre</a>
      </nav>
    </header>

    <section class="search-bar">
      <input type="text" placeholder="Buscar no portal...">
      <button>Pesquisar</button>
    </section>
	
    <section class="navigation-buttons">
    	<a href="CadastrarEmpresa.jsp">
        	<button>Cadastrar empresa</button>
      	</a>
      	
      	<a href="VagasOfertadas.jsp">
        	<button>Vagas cadastradas</button>
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
