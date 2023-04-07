package com.inti.model;
import java.util.*;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString.Exclude;

@Table(name="g1_user_attente")
@Entity @AllArgsConstructor @NoArgsConstructor @Data
@JsonIgnoreProperties({"hibernateLazyInitializer"})
@PrimaryKeyJoinColumn(name="id_user")
public class UtilisateurAttente extends PersonneAttente {

   
    private String adresse;
    private String telephone;
    
//    @OneToMany(mappedBy = "client")
//	@Exclude
//	@JsonIgnore
//    private List<Questions> listeQuestions;

	public UtilisateurAttente(int id, String nom, String prenom, String login, String mdp, String mail, String adresse,
			String telephone) {
		super(id, nom, prenom, login, mdp, mail);
		this.adresse = adresse;
		this.telephone = telephone;	
	}
}