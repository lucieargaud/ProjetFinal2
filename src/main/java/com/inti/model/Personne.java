package com.inti.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.lang.Nullable;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.ToString.Exclude;


@Table(name = "g1_personne")
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@JsonIgnoreProperties({ "hibernateLazyInitializer" })
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Personne {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	protected int id;
	protected String nom;
	protected String prenom;
	@NonNull
	@Column(unique = true, nullable = false)
	protected String login;
	@NonNull
	@Column(nullable = false)
	protected String mdp;
	protected String mail;


//	public Personne(int id, String nom, String prenom, String login, String mdp, String mail) {
//		super();
//		this.id = id;
//		this.nom = nom;
//		this.prenom = prenom;
//		this.login = login;
//		this.mdp = mdp;
//		this.mail = mail;
//	}

}