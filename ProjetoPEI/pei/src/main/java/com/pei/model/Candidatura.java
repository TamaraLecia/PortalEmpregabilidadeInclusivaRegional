package com.pei.model;

import lombok.Data;

@Data
public class Candidatura {
    private Integer id;
    private String nome;
    private int idVaga;
    private String titulo;
    private boolean status;

    public boolean getStatus() {
        return true;
    }
    public void setStatus(boolean status){
        this.status = status;
    }
}
