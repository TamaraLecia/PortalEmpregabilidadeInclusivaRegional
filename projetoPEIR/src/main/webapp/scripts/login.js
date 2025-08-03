/**
 * Validacao de formulario
 */

function validarInformacao(){
	
	var email = document.getElementById('email').value
	var senha = document.getElementById('senha').value
	
	if(email === ""){
		alert('Informe o email')
		document.getElementById('email').focus()
		return false;
	}else if(senha === ""){
		alert('Digite uma senha')
		document.getElementById('senha').focus()
		return false;
	}else{
		document.getElementById('loginForm').submit();
	}
}