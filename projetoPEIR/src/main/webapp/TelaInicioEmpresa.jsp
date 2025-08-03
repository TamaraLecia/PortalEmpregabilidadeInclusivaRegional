<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ page import="model.Empresa"%>
<%@ page import="java.util.ArrayList"%>

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
      <li><a href="logout2">Sair</a></li>
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
        <a href="Sobre.jsp">Sobre</a>
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
     <%--Exibir todas as empresas cadastradas no sistema
     	Esse arrayList está recebendo esses dados da controllerTelaPrincipal que salva os dados em uma sessão
     	cujo o nome é listaEmpresas
      --%>
	     <%
	    ArrayList<Empresa> listaEmpresas = (ArrayList<Empresa>) session.getAttribute("listas");
	    if (listaEmpresas != null) {
	        for (Empresa emp : listaEmpresas) {%>
	            <div>
	                <h3><%= emp.getNomeEmpresa() %></h3>
	                <p><strong>CNPJ:</strong> <%= emp.getCnpj() %></p>
	                <p><strong>Setor:</strong> <%= emp.getSetor() %></p>
	                <p><strong>Site:</strong> <%= emp.getSite() %></p>
	                <p><strong>Endereço:</strong> <%= emp.getEndereco() %></p>
	                <p><strong>Região de atuação:</strong> <%= emp.getRegiaoAtuacao() %></p>
	                <p><strong>Programa de inclusão:</strong> <%= emp.getProgramaInclusao() %></p>
	                <p><strong>Tipo de vaga:</strong> <%= emp.getTipoVaga() %></p>
	                <p><strong>Descrição da vaga:</strong> <%= emp.getDescricaoVaga() %></p>
	            </div>
			<%}
	    } else {%>
	        <p>Nenhuma empresa encontrada.</p>
	<%}%>

    <footer class="footer">
      <p>Contato: 3451-9078</p>
      <p>Email: portalempregabilidade@gmail.com</p>
    </footer>
</body>
</html>