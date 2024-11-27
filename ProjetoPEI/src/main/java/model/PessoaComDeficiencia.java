package model;

import java.util.Date;

public class PessoaComDeficiencia extends Pessoa{
	
	private String genero;
	private String deficiencia;
	private String formacao;
	private String experiencia;
	private String descricao;
	private String nacionalidade;
	private Date dataNascimento;
	private String interesse;
	private String cpf;
    private String endereco;

    public PessoaComDeficiencia(String cpf, Date dataNascimento, String deficiencia, String descricao, String endereco, String experiencia, String formacao, String genero, String interesse, String nacionalidade) {
        this.cpf = cpf;
        this.dataNascimento = dataNascimento;
        this.deficiencia = deficiencia;
        this.descricao = descricao;
        this.endereco = endereco;
        this.experiencia = experiencia;
        this.formacao = formacao;
        this.genero = genero;
        this.interesse = interesse;
        this.nacionalidade = nacionalidade;
    }

    public PessoaComDeficiencia(String cpf, Date dataNascimento, String deficiencia, String descricao, String endereco, String experiencia, String formacao, String genero, String interesse, String nacionalidade, int id, String nome, String telefone, String email, String senha) {
        super(id, nome, telefone, email, senha);
        this.cpf = cpf;
        this.dataNascimento = dataNascimento;
        this.deficiencia = deficiencia;
        this.descricao = descricao;
        this.endereco = endereco;
        this.experiencia = experiencia;
        this.formacao = formacao;
        this.genero = genero;
        this.interesse = interesse;
        this.nacionalidade = nacionalidade;
    }
}

