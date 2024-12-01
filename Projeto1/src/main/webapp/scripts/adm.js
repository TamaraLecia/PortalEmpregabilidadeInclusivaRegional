/**
 * Validacao de formulario
 */

function validarInformacao(){
	var nome = document.getElementById('nome').value
	var telefone = document.getElementById('telefone').value
	var email = document.getElementById('email').value
	var senha = document.getElementById('senha').value
	
	
	if(nome === ""){
		alert('Informe o nome')
		document.getElementById('nome').focus()
		return false;
	}else if(telefone === ""){
		alert('Informe o telefone')
		document.getElementById('telefone').focus()
		return false;
	}else if(email === ""){
		alert('Informe o email')
		document.getElementById('email').focus()
		return false;
	}else if(senha === ""){
		alert('Digite uma senha')
		document.getElementById('senha').focus()
		return false;
	}else{
		document.getElementById('formAdm').submit();
	}
}