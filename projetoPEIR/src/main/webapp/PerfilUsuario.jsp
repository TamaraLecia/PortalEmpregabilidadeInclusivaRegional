<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="model.PessoaPCD"%>
<%@ page import="java.util.ArrayList"%>

<%
    ArrayList<PessoaPCD> lista1 = (ArrayList<PessoaPCD>) request.getAttribute("mostrarPerfil");
%>

<!DOCTYPE html>
<html lang="pt-BR">
<head>
  <meta charset="UTF-8">
  <title>Perfil do Usuário</title>
  <link rel="stylesheet" href="css/perfilUsuario.css">
</head>
<body>
  <aside>
    <h2>Menu</h2>
    <ul>
<%
    if (lista1 != null && !lista1.isEmpty()) {
        for (PessoaPCD pessoa : lista1) {
%>
      <li><a href="selecionarPerfil?id=<%= pessoa.getId() %>" class="active">Editar perfil</a></li>
<%
        }
    } else {
%>
      <li>Nenhum perfil encontrado</li>
<%
    }
%>
      <li><a href="vagasCadastradasUsuario.html">Vagas Cadastradas</a></li>
      <li><a href="logout2">Sair</a></li>
    </ul>
  </aside>

  <main>
    <section class="content">
      <h2>Meu Perfil</h2>
<%
    if (lista1 != null && !lista1.isEmpty()) {
        for (PessoaPCD pessoa : lista1) {
%>
      <form>
        <div class="form-group">
          <label>Área de Interesse</label>
          <input type="text" value="<%= pessoa.getAreaInteresse() %>" disabled>
        </div>
        <div class="form-group">
          <label>Gênero</label>
          <input type="text" value="<%= pessoa.getGenero() %>" disabled>
        </div>
        <div class="form-group">
          <label for="data-nascimento">Data de Nascimento</label>
          <input type="text" id="dataNascimento" value="<%=pessoa.getDataNascimento() %>"  disabled>
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
          <input type="text" id="formacaoAcademica" value="<%=pessoa.getFormacaoAcademica() %>"  disabled>
        </div>

        <div class="form-group">
          <label for="deficiencia">Deficiência</label>
          <input type="text" id="deficiencia" value="<%=pessoa.getDeficiencia() %>"  disabled>
        </div>

        <div class="form-group">
          <label for="descricao-deficiencia">Descrição sobre a Deficiência</label>
          <textarea id="descricaoDeficiencia" rows="4" disabled> <%=pessoa.getDescricaoDeficiencia() %>
          </textarea>
        </div>
        
        <!-- Repita os campos conforme necessário -->
      </form>
      <hr>
<%
        }
    } else {
%>
      <p>Nenhum perfil encontrado.</p>
<%
    }
%>
    </section>
  </main>
</body>
</html>