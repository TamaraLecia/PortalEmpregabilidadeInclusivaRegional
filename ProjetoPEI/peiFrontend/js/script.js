const formulario = document.querySelector("form");
const botao = document.querySelector("button");

const inputNome = document.getElementById("nome");
const inputEmail = document.getElementById("email");
const inputSenha = document.getElementById("senha");
const inputInteresse = document.getElementById("interesse");
const inputGenero = document.getElementById("genero");
const inputNascimento = document.getElementById("dataNascimento");
const inputNacionalidade = document.getElementById("nacionalidade");
const inputEndereco = document.getElementById("endereco");
const inputFormacao = document.getElementById("formacao");
const inputDeficiencia = document.getElementById("deficiencia");
const inputCpf = document.getElementById("cpf");
const inputDescricao = document.getElementById("descricao");
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
formulario.addEventListener("submit", function (event) {
    event.preventDefault();

    const interesse = document.getElementById("interesse").value;
    const genero = document.getElementById("genero").value;
    const dataNascimento = document.getElementById("dataNascimento").value;
    const nacionalidade = document.getElementById("nacionalidade").value;
    const endereco = document.getElementById("endereco").value;
    const formacao = document.getElementById("formacao").value;
    const deficiencia = document.getElementById("deficiencia").value;
    const cpf = document.getElementById("cpf").value;
    const descricao = document.getElementById("descricao").value;

    fetch("http://localhost:8080/pessoa-com-deficiencia/cadastrar", {
        headers: {
            "Accept": "application/json",
            "Content-Type": "application/json"
        },
        method: "POST",
        body: JSON.stringify({
            interesse: interesse,
            genero: genero,
            dataNascimento: dataNascimento,
            nacionalidade: nacionalidade,
            endereco: endereco,
            formacao: formacao,
            deficiencia: deficiencia,
            cpf: cpf,
            descricao: descricao
        })
    })
        .then(response => {
            if (response.ok) {
                return response.json();
            } else {
                throw new Error("Erro ao cadastrar: " + response.statusText);
            }
        })
        .then(data => {
            alert("Cadastro realizado com sucesso!");
            console.log(data);
        })
        .catch(error => {
            alert("Erro ao cadastrar: " + error.message);
            console.error(error);
        });
});

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
