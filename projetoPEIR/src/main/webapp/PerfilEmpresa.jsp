<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="model.Empresa"%>
<%@ page import="java.util.ArrayList"%>
    <%
        ArrayList<Empresa> lista1 = (ArrayList<Empresa>) request.getAttribute("mostrarEmpresa");
        if (lista1 != null) {
          for (Empresa empresa : lista1) {%>
<!DOCTYPE html>
<html lang="pt-BR">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Perfil da Empresa</title>
  <link rel="icon" type="image/png" href="imagens/acessibilidade.png">
  <link rel="stylesheet" href="css/PerfilEmpresa.css">
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
      <li><a href="selecionarEmpresa?id=<%=empresa.getId()%>" class="active">Editar Perfil</a></li>
      <li><a href="VagasOfertadas.jsp">Minhas Vagas</a></li>
      <li><a href="#">Sair</a></li>
    </ul>
  </aside>

  <main>
    <header class="header">
      <div class="logo">
        <img src="images/acessibilidade.png" alt="Ícone de Acessibilidade" class="logo-icon">
        <h1>Portal de Empregabilidade Inclusiva</h1>
      </div>
      <nav class="menu">
        <a href="TelaInicio.html">Início</a>
        <a href="Sobre.html">Sobre</a>
      </nav>
    </header>

    <hr class="divider">

    <section class="content">
      <h2>Perfil da Empresa</h2>
  
      <form>
        <div class="form-group">
          <label for="nome-empresa">Nome da Empresa:</label>
          <input type="text" id="nomeEmpresa" name="nomeEmpresa" value="<%=empresa.getNomeEmpresa() %>" disabled>
        </div>

        <div class="form-group">
          <label for="cnpj">CNPJ:</label>
          <input type="text" id="cnpj" name="cnpj" value="<%=empresa.getCnpj() %>" disabled>
        </div>

        <div class="form-group">
          <label for="setor">Setor de Atuação:</label>
          <input type="text" id="setor" name="setor" value="<%=empresa.getSetor() %>" disabled>
        </div>

        <div class="form-group">
          <label for="site">Site Oficial:</label>
          <input type="text" id="site" name="site" value="<%=empresa.getSite() %>" disabled>
        </div>

        <div class="form-group">
          <label for="endereco">Endereço:</label>
          <input type="text" id="endereco" name="endereco" value="<%=empresa.getEndereco() %>" disabled>
        </div>

        <div class="form-group">
          <label for="regioes">Regiões de Atuação:</label>
          <input type="text" id="regioes" name="regioes" value="<%=empresa.getRegiaoAtuacao() %>" disabled>
        </div>

        <div class="form-group">
          <label for="programa-inclusao">Possui Programas de Inclusão?</label>
          <input type="text" id="programa-inclusao" name="programa-inclusao" value="<%=empresa.getProgramaInclusao() %>" disabled>
        </div>

        <div class="form-group">
          <label for="descricao-vagas">Descrição das Vagas Ofertadas:</label>
          <textarea id="descricao-vagas" name="descricao-vagas" rows="4"disabled>
			<%=empresa.getDescricaoVaga()%>
          </textarea>
        </div>
      </form>
      <%
          }
        } else {
          out.println("Nada encontrado");
        }
      %>
    </section>

    <footer class="footer">
      <p>&copy; 2024 Portal de Empregabilidade Inclusiva Regional. Todos os direitos reservados.</p>
    </footer>
  </main>
</body>
</html>
