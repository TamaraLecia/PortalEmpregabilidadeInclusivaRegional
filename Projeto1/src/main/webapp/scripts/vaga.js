/**
 * Validar informações
 */

function validarinformacao() {
	
    var titulo = document.getElementById('titulo').value;
    var nomeEmpresa = document.getElementById('nomeEmpresa').value;
    var descricao = document.getElementById('descricao').value;
	var local = document.getElementById('local').value;
    var requisito = document.getElementById('requisito').value;
   	var salario = document.getElementById('salario').value;  // Correção do ID
    var acessibilidade = document.getElementById('acessibilidade').value;
    var dataExpiracao = document.getElementById('dataExpiracao').value;
	
     if(titulo === "") {
        alert('Informe o titulo da vaga');
        document.getElementById('titulo').focus();
        return false;
    } else if(empresa === "") {
        alert('Informe o nome da empresa');
        document.getElementById('empresa').focus();
        return false;
    } else if(descricao === "") {
        alert('Informe o descricao');
        document.getElementById('descricao').focus();
        return false;
    } else if(local === "") {
        alert('Informe o local da vaga');
        document.getElementById('local').focus();
        return false;
    } else if(requisito === "") {
        alert('Informe o requisito da vaga');
        document.getElementById('requisito').focus();
        return false;
    } else if(acessibilidade === "") {
        alert('Informe a acessibilidade da vaga');
        document.getElementById('acessibilidade').focus();
        return false;
    } else if(dataExpiracao === "") {
        alert('Informe a data de expiração da vaga');
        document.getElementById('dataExpiracao').focus();
        return false;
    } else {
        document.getElementById('formVaga').submit();
    }
}

function salvar() {
	var nomeEmpresa = document.getElementById('nomeEmpresa').value;
	document.getElementById('form').submit();
}
