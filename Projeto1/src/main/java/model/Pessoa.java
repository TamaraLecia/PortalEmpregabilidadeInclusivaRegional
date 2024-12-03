package model;

public class Pessoa {
	private int id;
	private String nome;
	private String telefone;
	private String email;
	private String senha;
	private String dataNascimento;
	private String genero;
	private String endereco;
	private String nacionalidade;
	private String cpf;
	private int nivelAcesso;
	
	public Pessoa(int id, String nome, String telefone, String email, String senha, String dataNascimento,String genero, String endereco, String nacionalidade, String cpf, int nivelAcesso) {
		this.id = id;
		this.nome = nome;
		this.telefone = telefone;
		this.email = email;
		this.senha = senha;
		this.dataNascimento = dataNascimento;
		this.genero = genero;
		this.endereco = endereco;
		this.nacionalidade = nacionalidade;
		this.cpf = cpf;
		this.nivelAcesso = nivelAcesso;
	}
	
	public Pessoa(int id, String nome, String telefone, String email, String senha, int nivelAcesso) {
		this.id = id;
		this.nome = nome;
		this.telefone = telefone;
		this.email = email;
		this.senha = senha;
		this.nivelAcesso = nivelAcesso;
	}
	
	public Pessoa(String dataNascimento,String genero, String endereco, String nacionalidade, String cpf) {
		this.dataNascimento = dataNascimento;
		this.genero = genero;
		this.endereco = endereco;
		this.nacionalidade = nacionalidade;
		this.cpf = cpf;
	}
	
	public Pessoa() {
		
	}
	
	
	public Pessoa(String dataNascimento, String genero, String endereco, String nacionalidade) {
		this.dataNascimento = dataNascimento;
		this.genero = genero;
		this.endereco = endereco;
		this.nacionalidade = nacionalidade;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public String getDataNascimento() {
		return dataNascimento;
	}
	public void setDataNascimento(String dataNascimento) {
		this.dataNascimento = dataNascimento;
	}
	public String getGenero() {
		return genero;
	}
	public void setGenero(String genero) {
		this.genero = genero;
	}
	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	public String getNacionalidade() {
		return nacionalidade;
	}
	public void setNacionalidade(String nacionalidade) {
		this.nacionalidade = nacionalidade;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public int getNivelAcesso() {
		return nivelAcesso;
	}

	public void setNivelAcesso(int nivelAcesso) {
		this.nivelAcesso = nivelAcesso;
	}
	
}