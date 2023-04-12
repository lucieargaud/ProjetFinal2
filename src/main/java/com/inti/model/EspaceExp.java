package com.inti.model;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Table(name = "g1p2_offre")
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@JsonIgnoreProperties({ "hibernateLazyInitializer" })
@PrimaryKeyJoinColumn(name = "id_offre")

public class EspaceExp {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String adresse;
	private String ville;
	private double prix;
	private double surface;

	@OneToOne
	private Proprietaire proprietaire;


	public EspaceExp(String adresse, String ville, double prix, double surface, Proprietaire proprietaire) {
		super();
		this.adresse = adresse;
		this.ville = ville;
		this.prix = prix;
		this.surface = surface;
		this.proprietaire = proprietaire;
	}

}
