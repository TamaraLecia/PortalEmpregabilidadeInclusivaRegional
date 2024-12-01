package model;

public class Administrador extends Pessoa{
	
	private int nivelAcesso;
	
	public Administrador(int id, String nome, String telefone, String email, String senha, int nivelAcesso) {
		super(id,nome, telefone, email, senha);
		this.nivelAcesso = nivelAcesso;
	}

	public Administrador() {
		super();
	}

	public int getNivelAcesso() {
		return nivelAcesso;
	}

	public void setNivelAcesso(int nivelAcesso) {
		this.nivelAcesso = nivelAcesso;
	}
}
