package model;

public class Vaga {
	private int id;
    private Empresa empresa;
    private String titulo;
    private String descricao;
    private String requisito;
    private String salario;
    private String localizacao;
    private String acessibilidade;
    private String dataExpiracao;
    
	public Vaga(int id, Empresa empresa, String titulo,String descricao, String requisitos, String salario, String localizacao,String acessibilidade, String dataExpiracao) {
		this.id = id;
		this.empresa = empresa;
		this.titulo = titulo;
		this.descricao = descricao;
		this.requisito = requisitos;
		this.salario = salario;
		this.localizacao = localizacao;
		this.acessibilidade = acessibilidade;
		this.dataExpiracao = dataExpiracao;
	}
	
	public Vaga() {
		
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Empresa getEmpresa() {
		return empresa;
	}
	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getRequisito() {
		return requisito;
	}
	public void setRequisito(String requisito) {
		this.requisito = requisito;
	}
	public String getSalario() {
		return salario;
	}
	public void setSalario(String salario) {
		this.salario = salario;
	}
	public String getLocalizacao() {
		return localizacao;
	}
	public void setLocalizacao(String localizacao) {
		this.localizacao = localizacao;
	}
	public String getAcessibilidade() {
		return acessibilidade;
	}
	public void setAcessibilidade(String acessibilidade) {
		this.acessibilidade = acessibilidade;
	}
	public String getDataExpiracao() {
		return dataExpiracao;
	}
	public void setDataExpiracao(String dataExpiracao) {
		this.dataExpiracao = dataExpiracao;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
    
}