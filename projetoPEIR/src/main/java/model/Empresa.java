package model;

public class Empresa {
	private int id;
	private String nomeEmpresa;
	private String cnpj;
	private String setor;
	private String site;
	private String endereco;
	private String regiaoAtuacao;
	private String programaInclusao;
	private String tipoVaga;
	private String descricaoVaga;
	private Administrador adm;
	
	
	public Empresa(int id,String nomeEmpresa, String cnpj, String setor, String site,String endereco, String regiaoAtuacao, String programaInclusao, String tipoVaga, String descricaoVaga,Administrador adm) {

		this.id = id;
		this.nomeEmpresa = nomeEmpresa;
		this.cnpj = cnpj;
		this.setor = setor;
		this.site = site;
		this.endereco = endereco;
		this.regiaoAtuacao = regiaoAtuacao;
		this.programaInclusao = programaInclusao;
		this.tipoVaga = tipoVaga;
		this.descricaoVaga = descricaoVaga;
		this.adm = adm;
	}
	
	public Empresa(String nomeEmpresa, String cnpj, String setor, String site,String endereco, String regiaoAtuacao, String programaInclusao,String descricaoVaga) {
		this.nomeEmpresa = nomeEmpresa;
		this.cnpj = cnpj;
		this.setor = setor;
		this.site = site;
		this.endereco = endereco;
		this.regiaoAtuacao = regiaoAtuacao;
		this.programaInclusao = programaInclusao;
		this.descricaoVaga = descricaoVaga;
	}
	
	public Empresa() {
		
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNomeEmpresa() {
		return nomeEmpresa;
	}
	public void setNomeEmpresa(String nomeEmpresa) {
		this.nomeEmpresa = nomeEmpresa;
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
	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	public String getRegiaoAtuacao() {
		return regiaoAtuacao;
	}
	public void setRegiaoAtuacao(String regiaoAtuacao) {
		this.regiaoAtuacao = regiaoAtuacao;
	}
	public String getProgramaInclusao() {
		return programaInclusao;
	}
	public void setProgramaInclusao(String programaInclusao) {
		this.programaInclusao = programaInclusao;
	}
	public String getTipoVaga() {
		return tipoVaga;
	}
	public void setTipoVaga(String tipoVaga) {
		this.tipoVaga = tipoVaga;
	}
	public String getDescricaoVaga() {
		return descricaoVaga;
	}
	public void setDescricaoVaga(String descricaoVaga) {
		this.descricaoVaga = descricaoVaga;
	}
	public Administrador getAdm() {
		return adm;
	}
	public void setAdm(Administrador adm) {
		this.adm = adm;
	}
	

}