package model;

import java.util.ArrayList;
import java.util.List;

public class PessoaPCD extends Pessoa {
	private String deficiencia;
	private String formacaoAcademica;
	private String areaInteresse;
	private String descricaoDeficiencia;
	private List<Candidatura> candidaturas;

	public PessoaPCD(int id, String nome, String telefone, String email, String senha, int nivelAcesso) {
		
		super(id, nome, telefone, email, senha, nivelAcesso);
		this.deficiencia = deficiencia;
		this.formacaoAcademica = formacaoAcademica;
		this.areaInteresse = areaInteresse;
		this.descricaoDeficiencia = descricaoDeficiencia;
		this.candidaturas = new ArrayList<>();
	}
	

	public PessoaPCD(int id, String nomeString, String telefone, String email, String senha, String dataNascimento,String genero, String endereco, String nacionalidade, String cpf, String deficiencia,String formacaoAcademica, String areaInteresse, String descricaoDeficiencia, int nivelAcesso) {
		super(id, nomeString, telefone, email, senha,dataNascimento, genero, endereco, nacionalidade, cpf, nivelAcesso);
		this.deficiencia = deficiencia;
		this.formacaoAcademica = formacaoAcademica;
		this.areaInteresse = areaInteresse;
		this.descricaoDeficiencia = descricaoDeficiencia;
		this.candidaturas = new ArrayList<>();
	}
	
	public PessoaPCD(String dataNascimento,String genero, String endereco, String nacionalidade, String cpf, String deficiencia,String formacaoAcademica, String areaInteresse, String descricaoDeficiencia) {
		super(dataNascimento, genero, endereco, nacionalidade, cpf);
		this.deficiencia = deficiencia;
		this.formacaoAcademica = formacaoAcademica;
		this.areaInteresse = areaInteresse;
		this.descricaoDeficiencia = descricaoDeficiencia;
		this.candidaturas = new ArrayList<>();
	}

	public PessoaPCD() {
		// TODO Auto-generated constructor stub
	}


	public PessoaPCD(String dataNascimento, String genero, String endereco, String nacionalidade, String deficiencia,
			String formacaoAcademica, String interesse, String descricao) {
		super(dataNascimento, genero, endereco, nacionalidade);
		this.deficiencia = deficiencia;
		this.formacaoAcademica = formacaoAcademica;
		this.areaInteresse = interesse;
		this.descricaoDeficiencia = deficiencia;
	}


	public String getDeficiencia() {
		return deficiencia;
	}

	public void setDeficiencia(String deficiencia) {
		this.deficiencia = deficiencia;
	}

	public String getFormacaoAcademica() {
		return formacaoAcademica;
	}

	public void setFormacaoAcademica(String formacaoAcademica) {
		this.formacaoAcademica = formacaoAcademica;
	}

	public String getAreaInteresse() {
		return areaInteresse;
	}

	public void setAreaInteresse(String areaInteresse) {
		this.areaInteresse = areaInteresse;
	}

	public List<Candidatura> getCandidaturas() {
		return candidaturas;
	}

	public void setCandidaturas(List<Candidatura> candidaturas) {
		this.candidaturas = candidaturas;
	}

	public String getDescricaoDeficiencia() {
		return descricaoDeficiencia;
	}

	public void setDescricaoDeficiencia(String descricaoDeficiencia) {
		this.descricaoDeficiencia = descricaoDeficiencia;
	}
}