package com.inti.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Table(name = "g1p2_reclamation")
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Reclamation {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idR;
	private String sujet;
	private String msg;
	private String reponse;
	private boolean ferme;
	private int idU;
	
	public Reclamation(String sujet, String msg, String reponse, boolean ferme, int idU) {
		super();
		this.sujet = sujet;
		this.msg = msg;
		this.reponse = reponse;
		this.ferme = ferme;
		this.idU = idU;
	}
	
	
}
