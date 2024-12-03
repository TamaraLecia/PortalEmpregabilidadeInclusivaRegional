package model;

import java.util.ArrayList;
import java.util.List;

public class Administrador extends Pessoa{
	
	public Administrador(int id, String nome, String telefone, String email, String senha, int nivelAcesso) {
		super(id,nome, telefone, email, senha, nivelAcesso);
	}

	public Administrador() {
		super();
	}
	
}
