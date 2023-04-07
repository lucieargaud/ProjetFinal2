package com.inti.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.inti.model.UtilisateurAttente;

@Repository
public interface IUtilisateurAttenteRepository extends JpaRepository<UtilisateurAttente, Integer>{

}
