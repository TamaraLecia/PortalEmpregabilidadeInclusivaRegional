<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ page import="model.Vaga"%>
<%@ page import="java.util.ArrayList"%>
    
  <%
	ArrayList<Vaga> lista1 = (ArrayList<Vaga>) request.getAttribute("listaVaga");
%>
<!DOCTYPE html>
<html lang="pt-BR">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Portal de Empregabilidade Inclusiva - Vagas Ofertadas</title>
  <link rel="icon" type="image/png" href="images/acessibilidade.png">
  <link rel="stylesheet" href="css/VagasOfertadas.css">
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
  <main>
    <div class="header">
      <div class="logo">
        <img src="imagens/acessibilidade.png" alt="Acessibilidade" class="logo-icon">
        <h1>Portal de Empregabilidade Inclusiva</h1>
      </div>
    </div>

    <div class="content">
      <h2>Vagas Ofertadas</h2>
      <form id="form" action="mostrarVagaParaAdm"">
      <input type="text" id="nomeEmpresa" name="nomeEmpresa" placeholder="Informe o nome da empresa para ver." required>
      	<div class="navigation-buttons">
       <button  onclick="salvar()">Ver vagas</button>
   		 </div>
      </form>
      
   	 <%if(lista1 != null) {%>
   	 <%for(Vaga vaga : lista1) {%>
      <p><%=vaga.getTitulo()%></p>
      <p><%=vaga.getDescricao()%></p>
      <p><%=vaga.getRequisito() %></p>
      <p><%=vaga.getSalario() %></p>
      <p><%=vaga.getLocalizacao() %></p>
      <p><%=vaga.getAcessibilidade() %></p>
      <p><%=vaga.getDataExpiracao() %></p>
      <%}%>
      <%} %><%else{%>
      		<input type="text" value="Não há nenhuma vaga Cadastrada para essa empresa">
      	<%} %>
    </div>

    <div class="navigation-buttons">
      <button onclick="location.href='CadastrarVaga'">Adicionar Nova Vaga</button>
    </div>
  </main>

  <div class="footer">
    <p>&copy; 2024 Portal de Empregabilidade Inclusiva Regional</p>
  </div>
  <script src="scripts/validador.js"></script>
</body>
</html>
