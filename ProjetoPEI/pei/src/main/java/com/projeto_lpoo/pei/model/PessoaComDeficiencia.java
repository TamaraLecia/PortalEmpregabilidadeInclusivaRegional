package com.projeto_lpoo.pei.model;


import java.util.List;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper=true)
public class PessoaComDeficiencia extends Pessoa {
    private String deficiencia;
    private Curriculo curriculo;
    private List<Formacao> formacaoAcademica;
    private List<Capacitacao> capacitacaoRecebida;

    public void adicionarExperiencia(int id, Experiencia experiencia) {
        throw new UnsupportedOperationException("Unimplemented method 'adicionarExperiencia'");
    }

    public Object getExperiencia() {
        throw new UnsupportedOperationException("Unimplemented method 'getExperiencia'");
    }


    public void adicionarFormacao(int idCandidato, Formacao formacao) {
        throw new UnsupportedOperationException("Unimplemented method 'adicionarFormacao'");
    }
}