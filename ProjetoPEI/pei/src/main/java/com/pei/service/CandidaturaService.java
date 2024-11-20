package com.pei.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pei.models.Candidatura;
import com.pei.repository.CandidaturaRepository;

@Service
public class CandidaturaService {
    
    @Autowired
    private CandidaturaRepository candidaturaRepository;

    public String cancelarCandidatura(Integer id){
        Candidatura candidatura = candidaturaRepository.findById(id)
        .orElseThrow(null);

        if(candidatura.getStatus() == false){
            candidatura.setStatus(true);
            
            return "Candidatura cancelada";
        }
        return null;
    }

}
