<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ptbr">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Login</title>
<link rel="icon" type="image/png" href="imagens/acessibilidade.png">
<link rel="stylesheet" href="css/Login.css">
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
			<img src="imagens/acessibilidade.png" alt="Ícone de Acessibilidade"
				class="logo-icon">
			<h1>Portal de Empregabilidade Inclusiva Regional</h1>
		</div>
		<nav class="menu">
			<a href="TelaInicial">Inicio</a> <a href="Sobre.html">Sobre</a>
		</nav>
	</header>

	<div class="container">
		<div class="left-panel">
			<div class="logo">
				<img src="imagens/acessibilidade.png" alt="Acessibilidade">
			</div>
			<h1>FAÇA SEU LOGIN</h1>
			<!-- <a href="PjPf.html" class="criar-conta">CRIAR CONTA</a> -->
		</div>
		<div class="right-panel">
			<form id="loginForm" action="ControllerLogin" method="">
				<div class="input-group">
					<label for="email">E-mail<span>*</span></label>
					<div class="input-wrapper">
						<input type="email" id="email" name="email" required>
					</div>
				</div>
				<div class="input-group">
					<label for="password">Senha<span>*</span></label>
					<div class="input-wrapper">
						<input type="password" id="senha" name="senha" required>
					</div>
					<a href="#" class="esqueceu-password">Esqueceu a senha</a>
				</div>

				<nav>
					<input type="submit" class="botao" value="Login">
					<!-- <a href="TelaInicio.jsp" class="botao">Login</a> -->
				</nav>

			</form>
		</div>
	</div>
	<script src="../js/script.js"></script>
</body>
</html>