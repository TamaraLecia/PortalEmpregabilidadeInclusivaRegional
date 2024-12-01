package model;

import java.util.Date;
import java.util.List;

public class Candidatura {
	private int id;
	private Vaga vaga;
	private List<PessoaPCD> pessoasComDeficiencia;
	private Date dataCandidatura;
	private String statusCandidatura;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Vaga getVaga() {
		return vaga;
	}
	public void setVaga(Vaga vaga) {
		this.vaga = vaga;
	}
	public List<PessoaPCD> getPessoasComDeficiencia() {
		return pessoasComDeficiencia;
	}
	public void setPessoasComDeficiencia(List<PessoaPCD> pessoasComDeficiencia) {
		this.pessoasComDeficiencia = pessoasComDeficiencia;
	}
	public Date getDataCandidatura() {
		return dataCandidatura;
	}
	public void setDataCandidatura(Date dataCandidatura) {
		this.dataCandidatura = dataCandidatura;
	}
	public String getStatusCandidatura() {
		return statusCandidatura;
	}
	public void setStatusCandidatura(String statusCandidatura) {
		this.statusCandidatura = statusCandidatura;
	}
	
}
