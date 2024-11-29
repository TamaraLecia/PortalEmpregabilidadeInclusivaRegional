<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="model.PessoaPCD" %>
	
<%

	PessoaPCD pessoa = (PessoaPCD) request.getAttribute("pessoa");
	if(pessoa == null){
		System.out.println("Usuario nao encontrado");
	}
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
  <aside>
    <h2>Menu</h2>
    <ul>
      <li><a href="editarPerfilUsuario.html" class="active">Editar perfil</a></li>
      <li><a href="vagasCadastradasUsuario.html">Vagas Cadastradas</a></li>
      <li><a href="#">Sair</a></li>
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
      <%for(int i = 0; i < 1; i++){ %>
      <form>
        <div class="form-group">
          <label for="area-interesse">Área de Interesse</label>
          <input type="text" id="area-interesse" value="${pessoa.get(i).getAreaInteresse()}"  disabled >
        </div>

        <div class="form-group">
          <label for="genero">Gênero</label>
          <input type="text" id="genero" value="${pessoa.genero}"  disabled>
        </div>

        <div class="form-group">
          <label for="data-nascimento">Data de Nascimento</label>
          <input type="text" id="data-nascimento" value="${pessoa.get(i).getDataNascimento()}"  disabled>
        </div>

        <div class="form-group">
          <label for="nacionalidade">Nacionalidade</label>
          <input type="text" id="nacionalidade" value="${pessoa.get(i).getNacionalidade()}"  disabled>
        </div>

        <div class="form-group">
          <label for="endereco">Endereço</label>
          <input type="text" id="endereco" value="${pessoa.get(i).getEndereco()}" disabled>
        </div>

        <div class="form-group">
          <label for="formacao-academica">Formação Acadêmica</label>
          <input type="text" id="formacao-academica" value="${pessoa.get(i).getFormacaoAcademica()}"  disabled>
        </div>

        <div class="form-group">
          <label for="deficiencia">Deficiência</label>
          <input type="text" id="deficiencia" value="${pessoa.deficiencia}"  disabled>
        </div>

        <div class="form-group">
          <label for="descricao-deficiencia">Descrição sobre a Deficiência</label>
          <textarea id="descricao-deficiencia" rows="4" disabled>${pessoa.descricaoDeficiencia}
          </textarea>
        </div>
      </form>
    </section>
    <%} %>

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