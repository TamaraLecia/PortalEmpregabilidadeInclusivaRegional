package model;

public class Vaga {
	private int id;
	private Empresa empresa;
	private String titulo;
	private String requisistos;
	private double salario;
	private String localizacao;
	private String acessibilidade;
	private String beneficio;
	
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
	public String getRequisistos() {
		return requisistos;
	}
	public void setRequisistos(String requisistos) {
		this.requisistos = requisistos;
	}
	public double getSalario() {
		return salario;
	}
	public void setSalario(double salario) {
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
	public String getBeneficio() {
		return beneficio;
	}
	public void setBeneficio(String beneficio) {
		this.beneficio = beneficio;
	}
	
	
}
