package com.projeto_lpoo.pei.model;

import lombok.Data;



@Data
public class Vaga {
    
    private int idVaga;
    private String titulo;
    private String descricao;
    private double salario;
    private String localizacao;
    private Boolean acessibilidade;
    private String beneficios;
    private Empresa empresa;
    private String requisitos;

    public Vaga(int idVaga,  String titulo, String descricao, double salario, String requisitos){
        this.idVaga = idVaga;
        this.titulo = titulo;
        this.descricao = descricao;
        this.salario = salario;
        this.requisitos = requisitos;
    }

    public Vaga(){
        this.idVaga = idVaga;
        this.titulo = titulo;
        this.salario = salario;
        this.localizacao = localizacao;
        this.acessibilidade = acessibilidade;
        this.beneficios = beneficios;
    }
}



