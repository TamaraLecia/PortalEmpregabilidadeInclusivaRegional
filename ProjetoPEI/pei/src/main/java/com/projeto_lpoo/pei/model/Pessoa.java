package com.projeto_lpoo.pei.model;

import java.util.Date;

import lombok.Data;

@Data
public class Pessoa {
    private int id;
    private String nome;
    private Date dataNascimento;
    private String cpf;
    private String endereco;
    private String telefone;
    private String email;
    private String senha;
}
