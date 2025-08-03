<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

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
        <!-- Verificar se há uma mensagem de erro --> 
        <% if (request.getAttribute("mensagemErro") != null) { %> 
        <script> 
        alert("<%= request.getAttribute("mensagemErro") %>"); 
        </script> <% } %>
        <form id="formVaga" action="CadastrarVaga">
          <label for="titulo">Título da Vaga</label>
          <input type="text" id="titulo" name="titulo" placeholder="Informe o titulo da vaga." required>
  
          <label for="nomeEmpresa">Empresa</label>
          <input type="text" id="nomeEmpresa" name="nomeEmpresa" placeholder="Informe a empresa que está ofertando a vaga." required>
  
  
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