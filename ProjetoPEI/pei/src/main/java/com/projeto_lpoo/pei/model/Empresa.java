package com.projeto_lpoo.pei.model;

import java.util.List;

import lombok.Data;

@Data
public class Empresa {
    private Long id;
    private String cnpj;
    private String razaoSocial;
    private String nome;
    private List<Vaga> vagas;
    private List<Administrador> administradores;
    private List<Capacitacao> capafitacaoOfertada;
}
