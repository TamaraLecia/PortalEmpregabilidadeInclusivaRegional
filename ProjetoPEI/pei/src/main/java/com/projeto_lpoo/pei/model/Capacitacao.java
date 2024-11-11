package com.projeto_lpoo.pei.model;

import java.util.Date;
import java.util.List;

import lombok.Data;

@Data
public class Capacitacao {
    private int id;
    private String titulo;
    private String descricao;
    private Date dataInicio;
    private Date dataFim;
    private String instrutor;
    private List<String> publicoAlvo;
}
