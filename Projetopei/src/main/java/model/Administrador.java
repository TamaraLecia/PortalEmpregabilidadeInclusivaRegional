package model;

public class Administrador extends Pessoa{
	private String setor;

	public Administrador(int id, String nome, String telefone, String email, String senha, String setor) {
		super(id, nome, telefone, email, senha);
		this.setor = setor;
	}
	
	public Administrador() {
		super();
	}

	public String getSetor() {
		return setor;
	}

	public void setSetor(String setor) {
		this.setor = setor;
	}
}
