function validarInformacoes() {
    
    const nome = document.getElementById('nome').value.trim();
    const cnpj = document.getElementById('cnpj').value.trim();
    const setor = document.getElementById('setor').value.trim();
    const site = document.getElementById('site').value.trim();
    const endereco = document.getElementById('endereco').value.trim();
    const regiao = document.getElementById('regiao').value.trim();
    const inclusao = document.getElementById('inclusao').value.trim();
    const descricaoVagas = document.getElementById('descricao-vagas').value.trim();
  
    if (!nome) {
      alert('Por favor, informe o nome da empresa.');
      document.getElementById('nome').focus();
      return false;
    }
    if (!cnpj) {
      alert('Por favor, informe o CNPJ.');
      document.getElementById('cnpj').focus();
      return false;
    }
    if (!setor) {
      alert('Por favor, informe o setor de atuação.');
      document.getElementById('setor').focus();
      return false;
    }
    if (!site) {
      alert('Por favor, informe o site oficial.');
      document.getElementById('site').focus();
      return false;
    }
    if (!endereco) {
      alert('Por favor, informe o endereço completo.');
      document.getElementById('endereco').focus();
      return false;
    }
    if (!regiao) {
      alert('Por favor, informe as regiões de atuação.');
      document.getElementById('regiao').focus();
      return false;
    }
    if (!inclusao) {
      alert('Por favor, informe se possui programas de inclusão.');
      document.getElementById('inclusao').focus();
      return false;
    }
    if (!descricaoVagas) {
      alert('Por favor, forneça a descrição das vagas ofertadas.');
      document.getElementById('descricao-vagas').focus();
      return false;
    }

    document.getElementById('formEditarEmpresa').submit();
  }
  