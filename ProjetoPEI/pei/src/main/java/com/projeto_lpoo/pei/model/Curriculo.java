package com.projeto_lpoo.pei.model;

import java.util.List;

import lombok.Data;

@Data
public class Curriculo {
    private List<Experiencia> experienciaProfissional;
    private List<Formacao> formacaoAcademica;
}
