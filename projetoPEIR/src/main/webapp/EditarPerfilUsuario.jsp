<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="model.PessoaPCD"%>
<%@ page import="java.util.ArrayList"%>
    <%
    ArrayList<PessoaPCD> lista1 = (ArrayList<PessoaPCD>) request.getAttribute("mostrarPerfil");


        if (lista1 != null) {
          for (PessoaPCD pessoa : lista1) {%>
    
<!DOCTYPE html>
<html lang="pt-BR">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Editar Perfil</title>
  <link rel="icon" type="image/png" href="imagens/acessibilidade.png">
  <link rel="stylesheet" href="css/editarPerfilUsuario.css">
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
      <li><a href="selecionarPerfil?id=<%=pessoa.getId() %>" class="active">Editar Perfil</a></li>
      <li><a href="PerfilUsuario">Meu perfil</a></li>
      <li><a href="#">Vagas Cadastradas</a></li>
      <li><a href="logout2">Sair</a></li>
    </ul>
  </aside>

  <main>
    <header class="header">
      <div class="logo">
        <img src="imagens/acessibilidade.png" alt="Ícone de Acessibilidade" class="logo-icon">
        <h1>Portal de Empregabilidade Inclusiva</h1>
      </div>
      <nav class="menu">
        <a href="TelaInicio.html">Início</a>
        <a href="Sobre.html">Sobre</a>
      </nav>
    </header>

    <hr class="divider">

    <section class="content">
      <h2>Editar Perfil</h2>
      <form name="formEditar" id="formEditar" action="update" method="get">
        <div class="form-group">
          <label for="email">Email *</label>
          <input type="text" id="email" name="email" placeholder="" value="<%=pessoa.getEmail() %>" readonly required>
        </div>
        <div class="form-group">
          <label for="id">id *</label>
          <input type="text" id="id" name="id" placeholder="" value="<%=pessoa.getId() %>" readonly required>
        </div>
        <div class="form-group">
          <label for="area-interesse">Área de Interesse *</label>
          <input type="text" id="areaInteresse" name="areaInteresse" placeholder="Digite sua área de interesse profissional" value="<%=pessoa.getAreaInteresse() %>" required>
        </div>

        <div class="form-group">
          <label for="genero">Gênero *</label>
          <input type="text" id="genero" name="genero" placeholder="Digite seu gênero" value="<%=pessoa.getGenero() %>" required>
        </div>

        <div class="form-group">
          <label for="data-nascimento">Data de Nascimento *</label>
          <input type="date" id="dataNascimento" name="dataNascimento" value="<%=pessoa.getDataNascimento() %>" required>
        </div>

        <div class="form-group">
          <label for="nacionalidade">Nacionalidade *</label>
          <input type="text" id="nacionalidade" name="nacionalidade" placeholder="Digite sua nacionalidade" value="<%=pessoa.getNacionalidade() %>" required>
        </div>

        <div class="form-group">
          <label for="endereco">Endereço *</label>
          <input type="text" id="endereco" name="endereco" placeholder="Digite seu endereço" value="<%=pessoa.getEndereco() %>" required>
        </div>

        <div class="form-group">
          <label for="formacao-academica">Formação Acadêmica *</label>
          <input type="text" id="formacaoAcademica" name="formacaoAcademica" placeholder="Digite sua formação acadêmica" value="<%=pessoa.getFormacaoAcademica() %>" required>
        </div>

        <div class="form-group">
          <label for="deficiencia">Deficiência *</label>
          <input type="text" id="deficiencia" name="deficiencia" placeholder="Informe se possui alguma deficiência" value="<%=pessoa.getDeficiencia() %>" required>
        </div>

        <div class="form-group">
          <label for="descricao-deficiencia">Descrição sobre a Deficiência *</label>
          <textarea id="descricaoDeficiencia" name="descricaoDeficiencia" rows="4" placeholder="Descreva a deficiência brevemente" value="<%=pessoa.getDescricaoDeficiencia() %>" required></textarea>
        </div>

        <div class="form-buttons">
         <input type="submit" value="Salvar Alterações" class="btn">

          <button type="reset" class="btn-secondary">Cancelar</button>
        </div>
      </form>
       <%
	     }
     }else {
    	 out.println("Nada encontrado");
     }
      %>
    </section>

    <footer class="footer">
      <p>&copy; 2024 Portal de Empregabilidade Inclusiva Regional. Todos os direitos reservados.</p>
    </footer>
    <script src="scripts/validador.js"></script>
  </main>
</body>
</html>