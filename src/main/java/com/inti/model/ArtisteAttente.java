package com.inti.model;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Table(name="g1p2_artiste_attente")
@Entity 
@PrimaryKeyJoinColumn(name="id_artiste")
@JsonIgnoreProperties({"hibernateLazyInitializer"})
public class ArtisteAttente extends PersonneAttente {


    public ArtisteAttente() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ArtisteAttente(int id, String nom, String prenom, String login, String mdp, String mail) {
		super(id, nom, prenom, login, mdp, mail);
		// TODO Auto-generated constructor stub
	}

}