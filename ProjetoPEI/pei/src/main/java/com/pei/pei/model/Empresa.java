package com.pei.pei.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Empresa {
   @Id
   @GeneratedValue(strategy=GenerationType.IDENTITY)
   private String cnpj;
   private String razaoSocial;
   private String vagas; 
}
