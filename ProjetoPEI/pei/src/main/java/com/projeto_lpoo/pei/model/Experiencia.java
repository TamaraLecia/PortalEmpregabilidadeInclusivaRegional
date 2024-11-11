package com.projeto_lpoo.pei.model;

import java.util.Date;

import lombok.Data;

@Data
public class Experiencia {
    private String nomeEmpresa;
    private String cargo;
    private Date dataInicio;
    private Date dataFim;
}
