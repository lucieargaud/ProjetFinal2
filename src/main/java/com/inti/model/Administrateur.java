package com.inti.model;

import java.util.*;

import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Table(name="g1_admin")
@Entity 
@PrimaryKeyJoinColumn(name="id_admin")
@JsonIgnoreProperties({"hibernateLazyInitializer"})
public class Administrateur extends Personne {


    public Administrateur() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Administrateur(int id, String nom, String prenom, String login, String mdp, String mail) {
		super(id, nom, prenom, login, mdp, mail);
		// TODO Auto-generated constructor stub
	}
}