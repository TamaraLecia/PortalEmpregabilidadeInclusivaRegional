 const inputArea = document.getElementById('area').value;
const inputGenero = document.getElementById('genero').value;
const inputNascimento = document.getElementById('nascimento').value;
const inputNacionalidade = document.getElementById('nacionalidade').value;
const inputEndereco = document.getElementById('endereco').value;
const inputFormacao = document.getElementById('formacao').value;
const inputDeficiencia = document.getElementById('deficiencia').value;
const inputCpf = document.getElementById('cpf').value;
const inputDescricao = document.getElementById('descricao').value;

const usuario = {
    inputArea : area,
    inputGenero : genero,
    inputNascimento : nascimento,
    inputNacionalidade : nacionalidade,
    inputEndereco : endereco,
    inputFormacao : formacao,
    inputDeficiencia : deficiencia,
    inputCpf : cpf,
    inputDescricao : descricao

};

function cadastrar(cadastrar){
    fetch('jdbc:mysql://localhost:3306/pei_database/pessoas-com-deficiencia/cadastrar',{
        method : 'POST',
        headers : {
            'Content-Type' : 'application/json'
        },
        body : JSON.stringify(usuario)
    })
    .then(response => response.json())
    .then(dado => {
        console.log('Cadastro realizado com sucesso', dado)
    })
    .catch((erro) => {
        console.error('Erro: ', erro);
    });
}


function longar(){
    fetch("http://localhost:8080/pessoas-com-deficiencia/login",
        {
            headers: {
                "Accept": "application/json",
                "Content-Type": "application/json"
            },
            method: "POST",
            body: JSON.stringify({
                email : inputEmail.value,
                password : inputSenha.value
            })
        })
        .then(function (res) {console.log(res)})
        .catch(function (res) {console.log(res)})
}

/*
function CadastrarUsuario(){
    fetch("http://localhost:8080/pessoas-com-deficiencia/cadastrar",
        {
            headers: {
                "Accept": "application/json",
                "Content-Type": "application/json"
            },
            method: "POST",
            body: JSON.stringify({
                area : inputArea.value,
                genero : inputGenero.value,
                nascimento : inputNascimento.value,
                nacionalidade : inputNacionalidade.value,
                endereco : inputEndereco.value,
                formacao : inputFormacao.value,
                deficiencia : inputDeficiencia.value,
                cpf : inputCpf.value,
                descricao : inputDescricao.value,

            })
        })
        .then(function (res) {console.log(res)})
        .catch(function (res) {console.log(res)})
}
*/
function atualizarUsuario(){
}

function verDadosUsuario(){
    return fetch("http://localhost:8080/pessoas-com-deficiencia/{id}") 
            .then(request => request.json())
                .then(dadosUsuario => {
                    formulario.innerHTML = 
                    `<p><strong>Nome:</strong> ${dadosUsuario.nome}</p> 
                    <p><strong>Email:</strong> ${dadosUsuario.formacao}</p> `;
                })
            
}
