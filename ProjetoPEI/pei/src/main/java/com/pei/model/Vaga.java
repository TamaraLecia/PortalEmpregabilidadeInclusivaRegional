package com.pei.model;

import lombok.Data;

@Data
public class Vaga {		

    private Integer idVaga;
    private String titulo;
    private String requisitos;
    private double salario;
    private String localizacao;
    private String acessibilidade;
    private String empresa;
    private String beneficios; 
}
