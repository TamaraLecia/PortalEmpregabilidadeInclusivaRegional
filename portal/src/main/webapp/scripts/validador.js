/**
 * 
 */

function validarinformacoes() {
	var nome = document.getElementById('nome').value
	var telefone = document.getElementById('telefone').value
	var email = document.getElementById('email').value
	var senha = document.getElementById('senha').value
	var interesse = document.getElementById('interesse').value
	var genero = document.getElementById('genero').value
	var dataNascimento = document.getElementById('dataNascimento').value
	var nacionalidade = document.getElementById('dataNascimento').value
	var endereco = document.getElementById('endereco').value
	var formacao = document.getElementById('formacao').value
	var cpf = document.getElementById('cpf').value
	var deficiencia = document.getElementById('deficiencia').value
	var descricao = document.getElementById('descricao').value

	if (nome === "") {
		alert('Informe o nome')
		formCadastro.nome.focus()
		return false;
	} else if (telefone === "") {
		alert('Informe o telefone')
		formCadastro.telefone.focus()
		return false;
	} else if (email === "") {
		alert('Informe o email')
		formCadastro.email.focus()
		return false;
	} else if (senha === "") {
		alert('Digite uma senha')
		formCadastro.senha.focus()
		return false;
	} else if (interesse === "") {
		alert('Informe o seu interesse')
		formCadastro.interesse.focus()
		return false;
	} else if (genero === "") {
		alert('Informe o seu genero')
		formCadastro.genero.focus()
		return false;
	} else if (dataNascimento === "") {
		alert('Informe a data de nascimento')
		formCadastro.dataNascimento.focus()
		return false;
	} else if (nacionalidade === "") {
		alert('Digite a sua nacionalidade')
		formCadastro.nacionalidade.focus()
		return false;
	} else if (endereco === "") {
		alert('Digite o seu endereco')
		formCadastro.endereco.focus()
		return false;
	} else if (formacao === "") {
		alert('Digite sua formacao')
		formCadastro.formacao.focus()
		return false;
	} else if (cpf === "") {
		alert('Digite seu cpf')
		formCadastro.cpf.focus()
		return false;
	} else if (deficiencia === "") {
		alert('Digite sua deficiencia')
		formCadastro.deficiencia.focus()
		return false;
	} else if (descricao === "") {
		alert('Digite seu cpf')
		formCadastro.descricao.focus()
		return false;
	} else {
		document.getElementById('formCadastro').submit();
	}

}
