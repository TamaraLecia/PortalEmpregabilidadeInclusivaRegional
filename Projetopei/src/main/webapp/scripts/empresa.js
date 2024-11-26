
function validarinformacoes(){
	var nome = document.getElementById('nome').value
	var cnpj = document.getElementById('cnpj').value
	var setor = document.getElementById('setor').value
	var endereco = document.getElementById('endereco').value
	var regiao = document.getElementById('regiao').value
	var inclusao = document.getElementById('inclusao').value
	var tipovaga = document.getElementById('tipovaga').value
	var descricaovagas = document.getElementById('descricaovagas').value
	
	if(nome === ""){
		alert('Informe o nome')
		document.getElementById('nome').focus()
		return false;
	}else if(cnpj === ""){
		alert('Informe o cnpj')
		document.getElementById('cnpj').focus()
		return false;
	}else if(setor === ""){
		alert('Informe o setor')
		document.getElementById('setor').focus()
		return false;
	}else if(endereco === ""){
		alert('Digite uma endereco')
		document.getElementById('endereco').focus()
		return false;
	}else if(regiao === ""){
		alert('Digite uma regiao')
		document.getElementById('regiao').focus()
		return false;
	}else if(inclusao === ""){
		alert('Digite uma inclusao')
		document.getElementById('inclusao').focus()
		return false;
	}else if(tipovaga === ""){
		alert('Digite uma site')
		document.getElementById('tipovaga').focus()
		return false;
	}else if(descricaovagas === ""){
		alert('Digite uma site')
		document.getElementById('descricaovagas').focus()
		return false;
	}
	else{
		document.getElementById('fomContinuacao').submit();
	}
}