package com.inti.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.inti.model.Administrateur;

@Repository
public interface IAdministrateurRepository extends JpaRepository<Administrateur, Integer>{

}
