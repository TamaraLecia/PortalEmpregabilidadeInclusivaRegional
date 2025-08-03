create database pei_db;
use pei_db;
/*drop database pei_db;*/
create table pessoaComDeficiencia(
	 nivelAcesso int,
	id int primary key auto_increment,
    nome varchar(50) not null,
    telefone varchar(15) not null,
    email varchar(50),
    senha varchar(50),
    dataNascimento Date,
    genero varchar(50),
    endereco varchar(50),
    nacionalidade varchar(50),
    cpf varchar(20),
	deficiencia varchar(100),
    formacaoAcademica varchar(200),
    descricaoDeficiencia varchar(200),
    areaInteresse varchar(80)
);

create table administrador(
	id int primary key auto_increment,
    nivelAcesso int,
    nome varchar(50) not null,
    telefone varchar(15) not null,
    email varchar(50),
    senha varchar(50)
);

create table empresa(
	id int primary key auto_increment,
    administrador_id int,
    foreign key (administrador_id) references administrador(id),
    nomeEmpresa varchar(60),
	cnpj varchar(20),
    setor varchar(50),
    site varchar (80),
    endereco varchar(50),
    regiaoAtuacao varchar(50),
    programaInclusao varchar(50),
    tipoVaga varchar(50),
    descricaoVaga varchar(200)
);

create index indiceNomeEmpresa on empresa(nomeEmpresa);

create table vaga(
	id int primary key auto_increment,
    empresaNome varchar(60),
    foreign key(empresaNome) references empresa(nomeEmpresa),
    titulo varchar(50),
    descricao varchar(100),
    requisitos varchar (50),
    salario double,
    localizacao varchar(50),
    acessibilidade varchar(50),
    dataExpiracao date
);


create table candidatura(
	id int primary key auto_increment,
    vaga_id int,
    pessoaComDeficiencia_id int,
	foreign key(vaga_id) references vaga(id),
    foreign key(pessoaComDeficiencia_id) references pessoaComDeficiencia(id), 
    pessoaComDeficiencia varchar(50),
    dataCandidatura date,
    status varchar(50)
);