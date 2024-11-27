function validarInformacoes() {
    
    const areaInteresse = document.getElementById('area-interesse').value.trim();
    const genero = document.getElementById('genero').value.trim();
    const dataNascimento = document.getElementById('data-nascimento').value.trim();
    const nacionalidade = document.getElementById('nacionalidade').value.trim();
    const endereco = document.getElementById('endereco').value.trim();
    const formacaoAcademica = document.getElementById('formacao-academica').value.trim();
    const deficiencia = document.getElementById('deficiencia').value.trim();
    const descricaoDeficiencia = document.getElementById('descricao-deficiencia').value.trim();
  
    if (!areaInteresse) {
      alert('Por favor, informe sua área de interesse.');
      document.getElementById('area-interesse').focus();
      return false;
    }
    if (!genero) {
      alert('Por favor, informe seu gênero.');
      document.getElementById('genero').focus();
      return false;
    }
    if (!dataNascimento) {
      alert('Por favor, informe sua data de nascimento.');
      document.getElementById('data-nascimento').focus();
      return false;
    }
    if (!nacionalidade) {
      alert('Por favor, informe sua nacionalidade.');
      document.getElementById('nacionalidade').focus();
      return false;
    }
    if (!endereco) {
      alert('Por favor, informe seu endereço.');
      document.getElementById('endereco').focus();
      return false;
    }
    if (!formacaoAcademica) {
      alert('Por favor, informe sua formação acadêmica.');
      document.getElementById('formacao-academica').focus();
      return false;
    }
    if (!deficiencia) {
      alert('Por favor, informe se possui alguma deficiência.');
      document.getElementById('deficiencia').focus();
      return false;
    }
    if (!descricaoDeficiencia) {
      alert('Por favor, descreva a deficiência brevemente.');
      document.getElementById('descricao-deficiencia').focus();
      return false;
    }

    document.getElementById('formEditarPerfilUsuario').submit();
  }
  