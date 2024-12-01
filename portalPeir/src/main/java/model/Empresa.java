package model;

public class Empresa {
	private int id;
	private Administrador administrador;
	private String cnpj;
	private String setor;
	private String site;
	private String regiaoAtuacao;
	private String progrmaInclusao;
	private String descricaoVaga;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Administrador getAdministrador() {
		return administrador;
	}
	public void setAdministrador(Administrador administrador) {
		this.administrador = administrador;
	}
	public String getCnpj() {
		return cnpj;
	}
	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}
	public String getSetor() {
		return setor;
	}
	public void setSetor(String setor) {
		this.setor = setor;
	}
	public String getSite() {
		return site;
	}
	public void setSite(String site) {
		this.site = site;
	}
	public String getRegiaoAtuacao() {
		return regiaoAtuacao;
	}
	public void setRegiaoAtuacao(String regiaoAtuacao) {
		this.regiaoAtuacao = regiaoAtuacao;
	}
	public String getProgrmaInclusao() {
		return progrmaInclusao;
	}
	public void setProgrmaInclusao(String progrmaInclusao) {
		this.progrmaInclusao = progrmaInclusao;
	}
	public String getDescricaoVaga() {
		return descricaoVaga;
	}
	public void setDescricaoVaga(String descricaoVaga) {
		this.descricaoVaga = descricaoVaga;
	}
	
	
}
