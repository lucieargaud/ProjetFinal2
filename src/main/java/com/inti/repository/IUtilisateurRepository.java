package com.inti.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.inti.model.Utilisateur;
@Repository
public interface IUtilisateurRepository extends JpaRepository<Utilisateur, Integer>{

	List<Utilisateur> findByNom(String nom);
	Utilisateur findByLogin(String login);
}
