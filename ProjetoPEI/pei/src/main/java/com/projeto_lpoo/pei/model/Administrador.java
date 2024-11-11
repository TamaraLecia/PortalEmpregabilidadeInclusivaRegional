package com.projeto_lpoo.pei.model;

import java.util.List;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper=true)
public class Administrador extends Pessoa{
    private List<Vaga> vagas;
}
