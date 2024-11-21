package com.pei.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pei.models.Pessoa;

public interface PessoaRepository extends JpaRepository<Pessoa, Integer> {
    //Responsavel por dar o select no BD e buscar a coluna Email
    Optional<Pessoa> findBYEmail(String email);
}
