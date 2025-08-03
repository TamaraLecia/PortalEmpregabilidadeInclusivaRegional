/**
 * Validar informações
 */

function validarinformacao() {
	
    var idAdm = document.getElementById('idAdm').value
	var nomeEmpresa = document.getElementById('nomeEmpresa').value;
    var cnpj = document.getElementById('cnpj').value;
    var setor = document.getElementById('setor').value;
	var site = document.getElementById('site').value;
    var endereco = document.getElementById('endereco').value;
    var regiaoAtuacao = document.getElementById('regiao').value;  // Correção do ID
    var programaInclusao = document.getElementById('programaInclusao').value;
    var tipoVaga = document.getElementById('tipoVaga').value;
    var descricaoVagas = document.getElementById('descricaoVagas').value;
	
     if(nomeEmpresa === "") {
        alert('Informe o nome da empresa');
        document.getElementById('nomeEmpresa').focus();
        return false;
    } else if(cnpj === "") {
        alert('Informe o cnpj');
        document.getElementById('cnpj').focus();
        return false;
    } else if(setor === "") {
        alert('Informe o setor');
        document.getElementById('setor').focus();
        return false;
    } else if(endereco === "") {
        alert('Digite uma endereco');
        document.getElementById('endereco').focus();
        return false;
    } else if(regiao === "") {
        alert('Digite uma regiao');
        document.getElementById('regiao').focus();
        return false;
    } else if(programaInclusao === "") { 
        alert('Digite uma inclusao');
        document.getElementById('programaInclusao').focus();
        return false;
    } else if(tipoVaga === "") {
        alert('Digite uma site');
        document.getElementById('tipoVaga').focus();
        return false;
    } else if(descricaoVagas === "") {
        alert('Digite uma site');
        document.getElementById('descricaoVagas').focus();
        return false;
    } else {
        document.getElementById('formEmpresa').submit();
    }
}

function salvar(){
	let id = document.getElementById('id').value
	let nome = document.getElementById('nomeEmpresa').value
	let cnpj = document.getElementById('cnpj').value
	let setor = document.getElementById('setor').value
	let site = document.getElementById('site').value
	let endereco = document.getElementById('endereco').value
	let regiao = document.getElementById('regioes').value
	let inclusao = document.getElementById('inclusao').value
	let descricao = document.getElementById('descricao').value
	
	document.getElementById('formAtualizar').submit();
	
}
