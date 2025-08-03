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
      <nav class="menu">
        <a href="Sobre.jsp" style="color: white; text-decoration: none;">Sobre</a>
     	<a href="TelaInicioUsuario.jsp" style="color: white; text-decoration: none;">Voltar</a>
      </nav>
    </div>

    <div class="content">
      <h2>Vagas Disponiveis</h2>
      
   	 <%if(lista1 != null) {%>
   	 <div style="display: flex; flex-wrap: wrap; gap: 10px;">
	   	 <%for(Vaga vaga : lista1) {%>
	   	 <div style="flex: 0 0 auto;">
		   	 
		      <table  border="1" cellpadding="8" cellspacing="0">
		      	<tr>
			      <th>Titulo</th>
			      <td> <%=vaga.getTitulo()%></td>
		      	</tr>
		      	<tr>
			      <td><strong>Descrição:</strong></td>
			      <td><%=vaga.getDescricao()%></td>
		      	</tr>
		      	<tr>
			      <td><strong>Requisitos:</strong></td>
			      <td><%=vaga.getRequisito() %></td>
		      	</tr>
		      	<tr>
			      <td><strong>Salário:</strong></td>
			      <td><%=vaga.getSalario() %></td>
		      	</tr>
		      	<tr>
			      <td><strong>Localização:</strong></td>
			      <td><%=vaga.getLocalizacao() %></td>
		      	</tr>
		      	<tr>
			      <td><strong>Acessibilidade:</strong></td>
			      <td><%=vaga.getAcessibilidade() %></td>
		      	</tr>
		      	<tr>
			      <td><strong>Data de Expiração:</strong></td>
			      <td><%=vaga.getDataExpiracao() %></td>
		      	</tr>
		      </table>
		   </div>
	      <%}%>
	   </div>
      <%} %><%else{%>
      		<input type="text" value="Não há nenhuma vaga Cadastrada para essa empresa">
      	<%} %>
    </div>
  </main>

  <div class="footer">
    <p>&copy; 2024 Portal de Empregabilidade Inclusiva Regional</p>
  </div>
  <script src="scripts/validador.js"></script>
</body>
</html>