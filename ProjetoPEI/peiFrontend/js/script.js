const formulario = document.querySelector("form");
const botao = document.querySelector("button");
const inputEmail = document.getElementById("email");
const inputSenha = document.getElementById("password");
const inputArea = document.getElementById("area");
const inputGenero = document.getElementById("genero");
const inputNascimento = document.getElementById("nascimento");
const inputNacionalidade = document.getElementById("nacionalidade");
const inputEndereco = document.getElementById("nacionalidade");
const inputFormacao = document.getElementById("formacao");
const inputDeficiencia = document.getElementById("deficiencia");
const inputCpf = document.getElementById("cpf");
const inputDescricao = document.getElementById("descricao");
const inputNome = document.getElementById("nome");
const inputTelefone = document.getElementById("telefone");

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
function cadastroPrimario(){
    fetch("http://localhost/127.0.0.1/pei_database/pessoa/cadastroPrimario",
        {
            headers: {
                "Accept": "application/json",
                "Content-Type": "application/json"
            },
            method: "POST",
            body: JSON.stringify({
                id : inputId.value,
                nome : inputId.value,
                telefone : inputTelefone.value,
                email : inputEmail.value,
                senha : inputSenha
            })
        })
        .then(function (res) {console.log(res)})
        .catch(function (res) {console.log(res)})
}

function cadastrarUsuario(){
    fetch("http://127.0.0.1:8080/pessoa_com_deficiencia/cadastrar",
        {
            headers: {
                "Accept": "application/json",
                "Content-Type": "application/json"
            },
            method: "POST",
            body: JSON.stringify({
                interesse : inputArea.value,
                genero : inputGenero.value,
                dataNascimento : inputNascimento.value,
                nacionalidade : inputNacionalidade.value,
                endereco : inputEndereco.value,
                formacao : inputFormacao.value,
                deficiencia : inputDeficiencia.value,
                cpf : inputCpf.value,
                descricao : inputDescricao.value,
                nome : inputId.value,
                telefone : inputTelefone.value,
                email : inputEmail.value,
                senha : inputSenha.value

            })
        })
        .then(function (res) {console.log(res)})
        .catch(function (res) {console.log(res)})
}

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
