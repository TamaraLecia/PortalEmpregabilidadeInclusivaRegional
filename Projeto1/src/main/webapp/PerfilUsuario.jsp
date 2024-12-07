<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
	<%@ page import="model.PessoaPCD"%>
	<%@ page import = "java.util.ArrayList"%>
	
	<%
	
	ArrayList<PessoaPCD> lista = (ArrayList<PessoaPCD>) request.getAttribute("mostrarPerfil");
	
	%>
<!DOCTYPE html>
<html lang="pt-BR">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Perfil do Usuário</title>
  <link rel="icon" type="image/png" href="imagens/acessibilidade.png">
  <link rel="stylesheet" href="css/perfilUsuario.css">
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
    <li><a href="editarPerfil" class="active">Editar perfil</a></li>
    <li><a href="vagasCadastradasUsuario.html">Vagas Cadastradas</a></li>
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
      <h2>Meu Perfil</h2>
      <form>
      <%for(int i = 0; i < lista.size(); i++){ %>
        <div class="form-group">
          <label for="area-interesse">Área de Interesse</label>
          <input type="text" id="areaInteresse" value="<%=lista.get(i).getAreaInteresse() %>"  disabled >
        </div>

        <div class="form-group">
          <label for="genero">Gênero</label>
          <input type="text" id="genero" value="<%=lista.get(i).getGenero() %>"  disabled>
        </div>

        <div class="form-group">
          <label for="data-nascimento">Data de Nascimento</label>
          <input type="text" id="dataNascimento" value="<%=lista.get(i).getDataNascimento() %>"  disabled>
        </div>

        <div class="form-group">
          <label for="nacionalidade">Nacionalidade</label>
          <input type="text" id="nacionalidade" value="<%=lista.get(i).getNacionalidade() %>"  disabled>
        </div>

        <div class="form-group">
          <label for="endereco">Endereço</label>
          <input type="text" id="endereco" value="<%=lista.get(i).getEndereco() %>" disabled>
        </div>

        <div class="form-group">
          <label for="formacao-academica">Formação Acadêmica</label>
          <input type="text" id="formacaoAcademica" value="<%=lista.get(i).getFormacaoAcademica() %>"  disabled>
        </div>

        <div class="form-group">
          <label for="deficiencia">Deficiência</label>
          <input type="text" id="deficiencia" value="<%=lista.get(i).getDeficiencia() %>"  disabled>
        </div>

        <div class="form-group">
          <label for="descricao-deficiencia">Descrição sobre a Deficiência</label>
          <textarea id="descricaoDeficiencia" rows="4" disabled> <%=lista.get(i).getDescricaoDeficiencia() %>
          </textarea>
        </div>
        <%} %>
      </form>
    </section>
    <footer class="footer">
      <p>&copy; 2024 Portal de Empregabilidade Inclusiva Regional. Todos os direitos reservados.</p>
    </footer>
  </main>
</body>
</html>