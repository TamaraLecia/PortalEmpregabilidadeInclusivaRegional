package com.pei.repository;

import org.springframework.data.repository.CrudRepository;

import com.pei.models.PessoaComDeficiencia;


public interface PessoaComDeficienciaRepository extends CrudRepository<PessoaComDeficiencia, Long>{
    PessoaComDeficiencia findById(long id);
}
