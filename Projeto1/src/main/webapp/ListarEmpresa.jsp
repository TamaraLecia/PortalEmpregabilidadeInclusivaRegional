<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="model.Empresa"%>
<%@ page import="java.util.ArrayList"%>

<%
	ArrayList<Empresa> lista = (ArrayList<Empresa>) request.getAttribute("listaEmpresa");
%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Listar Empresa</title>
	<link rel="stylesheet" href="css/ListarEmpresa.css">
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
	<h1>Empresas Cadastradas</h1>
	<table class="tabela">
	<%if(lista != null) {%>
		<thead>
			<tr>
				<th>Empresa</th>
				<th></th>
				<th></th>
			</tr>
		</thead>
	<tbody>
	<%for(Empresa empresa : lista){ %>
		<tr>
			<td><%=empresa.getNomeEmpresa()%></td>
			 <td><a href="verEmpresa?id=<%=empresa.getId()%>" class="botao">Ver Perfil</a></td>
		</tr>
		<%} %>
	<%}%><%else{ %>
		<textArea type="text" value="Não há empresas Cadastradas ainda">
		<%}%>
	</tbody>
	</table>
	
</body>
</html>