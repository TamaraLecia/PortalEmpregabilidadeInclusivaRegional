<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
<%@ page import="java.util.ArrayList" %> 
<%@ page import="model.PessoaPCD"%>

<% ArrayList<PessoaPCD> lista2 = (ArrayList<PessoaPCD>) request.getAttribute("pessoaComDeficiencia");%>

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
  <aside>
    <h2>Menu</h2>
    <ul>
    <%for(int i = 0; i <lista2.size(); i++ ){ %>
      <li><a href="select?email=<%=lista2.get(i).getEmail()%>" class="active">Editar perfil</a></li>
      <li><a href="vagasCadastradasUsuario.html">Vagas Cadastradas</a></li>
      <li><a href="#">Sair</a></li>
      <%} %>
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
    <% ArrayList<PessoaPCD> lista = (ArrayList<PessoaPCD>) request.getAttribute("pessoaComDeficiencia"); 
    System.out.println("lista " +lista);
    if (lista != null && !lista.isEmpty()) {
    	for (PessoaPCD pessoa : lista) { %>
      <form>
        <div class="form-group">
          <label for="area-interesse">Área de Interesse</label>
          <input type="text" id="area-interesse" value="<%=pessoa.getAreaInteresse() %>"  disabled >
        </div>

        <div class="form-group">
          <label for="genero">Gênero</label>
          <input type="text" id="genero" value="<%=pessoa.getGenero() %>"  disabled>
        </div>

        <div class="form-group">
          <label for="data-nascimento">Data de Nascimento</label>
          <input type="text" id="data-nascimento" value="<%=pessoa.getDataNascimento() %>"  disabled>
        </div>

        <div class="form-group">
          <label for="nacionalidade">Nacionalidade</label>
          <input type="text" id="nacionalidade" value="<%=pessoa.getNacionalidade() %>"  disabled>
        </div>

        <div class="form-group">
          <label for="endereco">Endereço</label>
          <input type="text" id="endereco" value="<%=pessoa.getEndereco() %>" disabled>
        </div>

        <div class="form-group">
          <label for="formacao-academica">Formação Acadêmica</label>
          <input type="text" id="formacao-academica" value="<%=pessoa.getFormacaoAcademica() %>"  disabled>
        </div>

        <div class="form-group">
          <label for="deficiencia">Deficiência</label>
          <input type="text" id="deficiencia" value="<%=pessoa.getDeficiencia() %>"  disabled>
        </div>

        <div class="form-group">
          <label for="descricao-deficiencia">Descrição sobre a Deficiência</label>
          <textarea id="descricao-deficiencia" rows="4" disabled><%=pessoa.getDescricaoDeficiencia() %>
          </textarea>
        </div>
      </form>
      <%}
    	
    	}else{
    		out.println("nada encontrado");
    	}
    %>
    </section>
    <footer class="footer">
      <p>&copy; 2024 Portal de Empregabilidade Inclusiva Regional. Todos os direitos reservados.</p>
    </footer>
  </main>
</body>
</html>
<!--
<!DOCTYPE html>
<html lang="pt-BR">
<head>
<meta charset="UTF-8">
<title>Perfil do Usuário</title>
</head>
<body>
	<h1>Perfil do Usuário</h1>
	<p>
		<strong>Área de Interesse:</strong> ${pessoa.areaInteresse}
	</p>
	<p>
		<strong>Gênero:</strong> ${pessoa.genero}
	</p>
	<p>
		<strong>Data de Nascimento:</strong> ${pessoa.dataNascimento}
	</p>
	<p>
		<strong>Nacionalidade:</strong> ${pessoa.nacionalidade}
	</p>
	<p>
		<strong>Endereço:</strong> ${pessoa.endereco}
	</p>
	<p>
		<strong>Formação Acadêmica:</strong> ${pessoa.formacaoAcademica}
	</p>
	<p>
		<strong>Deficiência:</strong> ${pessoa.deficiencia}
	</p>
	<p>
		<strong>Descrição da Deficiência:</strong>
		${pessoa.descricaoDeficiencia}
	</p>
</body>
</html>
-->