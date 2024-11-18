package com.pei.models;

import lombok.Data;

@Data
public class PessoaComDeficiencia extends Pessoa{
	private String deficiencia;
	private String formacao;
	private String experiencia;
}
