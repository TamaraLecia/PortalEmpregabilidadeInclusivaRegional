package com.pei.pei.model;

import java.util.Date;

import lombok.Data;

@Data
public class Capacitacao {
    Integer idCapacitacao;
    String tituloCapacitacao;
    String descriçãoCapacitação;
    Date dataInicioCapacitacao;
    Date dataFimCapacitacao;
    String instrutorCapacitaca;
    String publicoAlvos;
}
