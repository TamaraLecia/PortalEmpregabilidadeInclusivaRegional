package model;

import java.util.Date;

public class Administrador extends Pessoa {
private String setor;

	
	
	public Administrador(int id, String nomeString, String telefone, String email, String senha,
			String dataNascimento, String genero, String endereco, String nacionalidade, String cpf, String setor) {
		super(id, nomeString, telefone, email, senha, dataNascimento, genero, endereco, nacionalidade, cpf);
		this.setor = setor;

	}

	public String getSetor() {
		return setor;
	}

	public void setSetor(String setor) {
		this.setor = setor;
	}
}
