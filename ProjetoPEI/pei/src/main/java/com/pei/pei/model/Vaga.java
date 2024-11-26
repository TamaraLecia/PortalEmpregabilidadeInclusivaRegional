package com.pei.pei.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

@Data
@Entity
public class Vaga {		

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer idVaga;

    @NotEmpty
    private String titulo;
    @NotEmpty
    private String requisitos;
    @NotEmpty
    private double salario;
    @NotEmpty
    private String localizacao;
    @NotEmpty
    private String acessibilidade;
    @NotEmpty
    private String empresa;
    @NotEmpty
    private String beneficios; 
}
