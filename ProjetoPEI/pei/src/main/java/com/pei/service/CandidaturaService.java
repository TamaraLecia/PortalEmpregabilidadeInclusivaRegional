package com.pei.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pei.models.Candidatura;
import com.pei.repository.CandidaturaRepository;

@Service
public class CandidaturaService {
    
    @Autowired
    private CandidaturaRepository candidaturaRepository;

    public void cancelarCandidatura(boolean status){
        Candidatura candidatura = candidaturaRepository.findByStatus(status)
        .orElseThrow(null);

        if(candidatura.getStatus() == false){
            candidatura.setStatus(true);
            System.out.println("Candidatura cancelada");
        }
    }

}
