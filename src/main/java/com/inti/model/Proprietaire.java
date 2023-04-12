package com.inti.model;


import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;

@Table(name = "g1p2_prop")
@Entity
@Data
@JsonIgnoreProperties({ "hibernateLazyInitializer" })
@PrimaryKeyJoinColumn(name = "id_prop")
public class Proprietaire extends Personne {


	public Proprietaire() {
		super();
	}
	
	@OneToOne
	private EspaceExp espaceExp;

	public Proprietaire(int id, String nom, String prenom, String login, String mdp, String mail) {
		super(id, nom, prenom, login, mdp, mail);
	}


}