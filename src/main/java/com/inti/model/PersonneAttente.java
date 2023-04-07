package com.inti.model;
import java.util.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Table(name="g1_personne_attente")
@Entity @AllArgsConstructor @NoArgsConstructor @Data
@JsonIgnoreProperties({"hibernateLazyInitializer"})
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class PersonneAttente {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected int id;
    protected String nom;
    protected String prenom;
    protected String login;
    protected String mdp;
    protected String mail;


//@ManyToOne
//@JoinColumn(name = "id_agence_immmobiliere")
//private AgenceImmobiliere agence_immobiliere;


//public PersonneAttente(int id, String nom, String prenom, String login, String mdp, String mail) {
//	super();
//	this.id = id;
//	this.nom = nom;
//	this.prenom = prenom;
//	this.login = login;
//	this.mdp = mdp;
//	this.mail = mail;
//}



}