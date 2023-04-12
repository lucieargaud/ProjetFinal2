package com.inti.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.inti.model.Reclamation;

@Repository
public interface IReclamationRepository extends JpaRepository<Reclamation, Integer>{

}
