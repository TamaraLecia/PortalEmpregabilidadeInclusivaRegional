<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ page import="java.util.ArrayList" %>
<%@ page import="model.Empresa" %>

<%

	ArrayList<Empresa> lista = (ArrayList<Empresa>) request.getAttribute("listaEmpresa");

%>

<!DOCTYPE html>
<html lang="ptbr">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Cadastrar Vaga de Emprego</title>
  <link rel="icon" type="image/png" href="imagens/acessibilidade.png">
  <link rel="stylesheet" href="css/CadastrarVaga.css">
</head>

</head>
<body>

    <header class="header">
        <div class="logo">
          <img src="imagens/acessibilidade.png" alt="Ícone de Acessibilidade" class="logo-icon">
          <h1>Portal de Empregabilidade Inclusiva Regional</h1>
        </div>
        <nav class="menu">
          <a href="TelaInicio.html">Inicio</a>
          <a href="Sobre.html">Sobre</a>
        </nav>
      </header>

    <div class="container">
      <div class="sidebar">
        <img src="imagens/acessibilidade.png" alt="Ícone de Acessibilidade" class="accessibility-icon">
        <h2>Portal de Empregabilidade</h2>
      </div>
  
      <div class="form-container">
        <h2>Cadastrar Nova Vaga de Emprego</h2>
        <form id="formVaga" action="CadastrarVaga">
          <label for="titulo">Título da Vaga</label>
          <input type="text" id="titulo" name="titulo" placeholder="Informe o titulo da vaga." required>
  
          <label for="idEmpresa">Empresa</label>
          <select id ="idEmpresa" name ="idEmpresa" required>
          <%
          System.out.println("lista vaga: " + lista);
          if(lista != null){ %>
          		<%for(Empresa empresa : lista){ %>
          		 <option value="<%= empresa.getNome()%>"><%= empresa.getId() %></option>
          		<%} %>
         <% }%><%else{ %>
         			<textArea type="text" value="Não há empresas cadastradas"></textArea>
         	<%} %>
          
          </select>
  
          <label for="descricao">Descrição da Vaga</label>
          <textarea id="descricao" name="descricao" placeholder="Descreva as responsabilidades da vaga..." rows="5" required></textarea>
  
          <label for="local">Local da Vaga</label>
          <input type="text" id="local" name="local" placeholder="Informe o endereço, ou se é uma vaga remota." required>
  
          <label for="requisito">Requisitos</label>
          <textarea id="requisito" name="requisito" placeholder="Listar requisitos da vaga..." rows="5" required></textarea>
          
          <label for="salario">Salario</label>
          <input type="number" id="salario" name="salario" placeholder="R$0,0">
  
          <label for="acessibilidade">Acessibilidade</label>
          <textarea id="acessibilidade" name="acessibilidade" placeholder="Informar adaptações e suportes oferecidos..." rows="3" required></textarea>
  
          <label for="dataExpiracao">Data de Expiração</label>
          <input type="date" id="dataExpiracao" name="dataExpiracao" required>
  
          <button value="Cadastrar Vaga" class="btn" onclick="validarinformacao()">></button>
        </form>
      </div>
    </div>
    <script src="scripts/vaga.js"></script>
  </body>
  </html>