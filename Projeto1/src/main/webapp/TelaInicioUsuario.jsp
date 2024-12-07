<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ page import="model.PessoaPCD"%>

<!DOCTYPE html>
<html lang="pt-br">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Portal de Empregabilidade Inclusiva</title>
  <link rel="icon" type="image/png" href="imagens/acessibilidade.png">
  <link rel="stylesheet" href="css/telaInicioUsuario.css">
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
      <li class="dropdown">
        <a href="#opcao2">Trabalhador</a>
        <ul class="dropdown-content">
          <li><a href="https://www.gov.br/trabalho-e-emprego/pt-br/servicos/trabalhador/carteira-de-trabalho">Carteira de trabalho digital</a></li>
        </ul>
      </li>
      </li>
      <li class="dropdown">
        <a href="#opcao3">Perfil</a>
        <ul class="dropdown-content">
          <li><a href="PerfilUsuario">Perfil de usuário</a></li>
        </ul>
      </li>
      <li class="dropdown">
        <a href="#opcao3">Outros</a>
        <ul class="dropdown-content">
          <li><a href="https://www.gov.br/governodigital/pt-br/acessibilidade-e-usuario/vlibras">VLibras</a></li>
        </ul>
      </li>
      <li><a href="sair">Sair</a></li>
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
      <a href="mostrarVaga">
        <button>Vagas disponiveis</button>
      </a>
      </a>
    </section>

    <div class="content">
      <p>O portal de empregabilidade digital conta com 5 cidades no momento. Confira quais sÃ£o:</p>
      <ol>
        <li>Guanambi - BA</li>
        <li>Barreiras - BA</li>
        <li>Caetite - BA</li>
        <li>Bom Jesus da Lapa - BA</li>
        <li>Vitoria da Conquista - BA</li>
      </ol>

      <h2>Endereçoss relacionados:</h2>

    <div class="address">
      <h3>PEIR Guanambi - BA:</h3>
      <p>Avenida Santos Dumont, 1239, bairro Centro</p>
      <p><strong>Contatos:</strong></p>
      <p>Telefone: (77) 99190-9878</p>
      <p>Email: peir_guanambi@gmail.com</p>
      <p>Expediente: Segunda-feira a sexta-feira das 8h Ã s 18h</p>
    </div>

    <div class="address">
      <h3>PEIR Barreiras - BA:</h3>
      <p>Rua Maria da GlÃ³ria, 135, bairro AntÃ´nio Geraldo</p>
      <p><strong>Contatos:</strong></p>
      <p>Telefone: (77) 99967-5567</p>
      <p>Email: peir_barreiras@gmail.com</p>
      <p>Expediente: Segunda-feira a sexta-feira das 8h Ã s 18h</p>
    </div>

    <div class="address">
      <h3>PEIR Vitoria da Conquista - BA:</h3>
      <p>Travessa Henrique Prates, 135, bairro Candeiras</p>
      <p><strong>Contatos:</strong></p>
      <p>Telefone: (77) 99927-4584</p>
      <p>Email: peir_VConquista@gmail.com</p>
      <p>Expediente: Segunda-feira a sexta-feira das 8h Ã s 18h</p>
    </div>

    <div class="address">
      <h3>PEIR Bom Jesus da Lapa - BA:</h3>
      <p>Rua do Machado, 159, bairro Centro</p>
      <p><strong>Contatos:</strong></p>
      <p>Telefone: (77) 99962-8565</p>
      <p>Email: peir_bjl@gmail.com</p>
      <p>Expediente: Segunda-feira a sexta-feira das 8h Ã s 18h</p>
    </div>

    <div class="address">
      <h3>PEIR CaetitÃ© - BA:</h3>
      <p>Rua Novo Horizonte, 1005, bairro Centro </p>
      <p><strong>Contatos:</strong></p>
      <p>Telefone: (77) 99967-5567</p>
      <p>Email: peir_barreiras@gmail.com</p>
      <p>Expediente: Segunda-feira a sexta-feira das 8h Ã s 18h</p>
    </div>

    <footer class="footer">
      <p>Contato: 3451-9078</p>
      <p>Email: portalempregabilidade@gmail.com</p>
    </footer>
  </main>
</body>
</html>