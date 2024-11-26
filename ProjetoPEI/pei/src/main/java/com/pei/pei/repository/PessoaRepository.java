package com.pei.pei.repository;

import org.springframework.data.repository.CrudRepository;

import com.pei.pei.model.Pessoa;


public interface PessoaRepository extends CrudRepository<Pessoa, Long>{
    Pessoa findById(long id);
}
