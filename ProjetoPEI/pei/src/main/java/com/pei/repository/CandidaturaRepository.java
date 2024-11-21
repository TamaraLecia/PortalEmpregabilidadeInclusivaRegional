package com.pei.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pei.models.Candidatura;

public interface CandidaturaRepository extends JpaRepository<Candidatura, Integer> {

    Optional<Candidatura> findByStatus(boolean status);
}
