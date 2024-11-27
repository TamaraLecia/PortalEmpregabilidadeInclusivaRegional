package model;

public class Candidatura {
    private int id;
    private String nome;
    private int idVaga;
    private String titulo;
    private boolean status;

    public Candidatura(int id, int idVaga, String nome, boolean status, String titulo) {
        this.id = id;
        this.idVaga = idVaga;
        this.nome = nome;
        this.status = status;
        this.titulo = titulo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdVaga() {
        return idVaga;
    }

    public void setIdVaga(int idVaga) {
        this.idVaga = idVaga;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
}
