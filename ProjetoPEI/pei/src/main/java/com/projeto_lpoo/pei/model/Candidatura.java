package com.projeto_lpoo.pei.model;

import java.util.Date;

import lombok.Data;

@Data
public class Candidatura {
    private int  idCandidatura;
    private Vaga vaga;
    private PessoaComDeficiencia pessoa;
    private Date dataCandidatura;
    private String statusCandidatura;
}