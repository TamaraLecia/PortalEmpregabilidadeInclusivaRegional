package com.pei.models;

import java.util.Date;

import lombok.Data;

@Data
public class Pessoa {
    private Integer id;
    private String nome;
    private String telefone;
    private String email;
    private String senha;

}

