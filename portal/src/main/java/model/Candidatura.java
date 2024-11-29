package model;

import java.util.Date;
import java.util.List;

public class Candidatura {
	private int id;
	private Vaga vaga;
	private List<PessoaPCD> pessoasComDeficiencia;
	private Date dataCandidatura;
	private String statusCandidatura;
}
