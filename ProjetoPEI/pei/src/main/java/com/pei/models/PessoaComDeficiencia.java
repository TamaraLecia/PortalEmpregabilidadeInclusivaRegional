package com.pei.models;

import java.sql.Date;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper=true)
public class PessoaComDeficiencia extends Pessoa{
	public PessoaComDeficiencia(int int1, String string, Date date, String string2, String string3, String string4,
			String string5, String string6, String string7, String string8, String string9) {
	}
	private String genero;
	private String deficiencia;
	private String formacao;
	private String experiencia;
	private String descricao;
	private String nacionalidade;
	private Date dataNascimento;
	private String interesse;
	private String cpf;
    private String endereco;
}
