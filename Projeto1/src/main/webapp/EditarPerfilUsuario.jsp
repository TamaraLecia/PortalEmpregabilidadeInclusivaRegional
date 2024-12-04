<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
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
  <aside>
    <h2>Menu</h2>
    <ul>
      <li><a href="EditarPerfilUsuario.html" class="active">Editar Perfil</a></li>
      <li><a href="PerfilUsuario.html">Meu perfil</a></li>
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
      <form name="formEditar" id="formEditar" action="update">
        <div class="form-group">
          <label for="id">Email *</label>
          <input type="text" id="email" name="email" placeholder="" value="<%out.print(request.getAttribute("email")); %>" readonly required>
        </div>
        <div class="form-group">
          <label for="id">id *</label>
          <input type="text" id="id" name="id" placeholder="" value="<%out.print(request.getAttribute("id")); %>" readonly required>
        </div>
        <div class="form-group">
          <label for="area-interesse">Área de Interesse *</label>
          <input type="text" id="areaInteresse" name="areaInteresse" placeholder="Digite sua área de interesse profissional" value="<%out.print(request.getAttribute("areaInteresse")); %>" required>
        </div>

        <div class="form-group">
          <label for="genero">Gênero *</label>
          <input type="text" id="genero" name="genero" placeholder="Digite seu gênero" value="<%out.print(request.getAttribute("genero")); %>" required>
        </div>

        <div class="form-group">
          <label for="data-nascimento">Data de Nascimento *</label>
          <input type="date" id="dataNascimento" name="dataNascimento" value="<%out.print(request.getAttribute("dataNascimento")); %>" required>
        </div>

        <div class="form-group">
          <label for="nacionalidade">Nacionalidade *</label>
          <input type="text" id="nacionalidade" name="nacionalidade" placeholder="Digite sua nacionalidade" value="<%out.print(request.getAttribute("nacionalidade")); %>" required>
        </div>

        <div class="form-group">
          <label for="endereco">Endereço *</label>
          <input type="text" id="endereco" name="endereco" placeholder="Digite seu endereço" value="<%out.print(request.getAttribute("endereco")); %>" required>
        </div>

        <div class="form-group">
          <label for="formacao-academica">Formação Acadêmica *</label>
          <input type="text" id="formacaoAcademica" name="formacaoAcademica" placeholder="Digite sua formação acadêmica" value="<%out.print(request.getAttribute("formacaoAcademica")); %>" required>
        </div>

        <div class="form-group">
          <label for="deficiencia">Deficiência *</label>
          <input type="text" id="deficiencia" name="deficiencia" placeholder="Informe se possui alguma deficiência" value="<%out.print(request.getAttribute("deficiencia")); %>" required>
        </div>

        <div class="form-group">
          <label for="descricao-deficiencia">Descrição sobre a Deficiência *</label>
          <textarea id="descricaoDeficiencia" name="descricaoDeficiencia" rows="4" placeholder="Descreva a deficiência brevemente" value="<%out.print(request.getAttribute("descricaoDeficiencia")); %>" required></textarea>
        </div>

        <div class="form-buttons">
          <input type="button" value="Salvar Alterações" class="btn" onclick ="salvar()">
          <button type="reset" class="btn-secondary">Cancelar</button>
        </div>
      </form>
    </section>

    <footer class="footer">
      <p>&copy; 2024 Portal de Empregabilidade Inclusiva Regional. Todos os direitos reservados.</p>
    </footer>
    <script src="scripts/validador.js"></script>
  </main>
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
</body>
</html>