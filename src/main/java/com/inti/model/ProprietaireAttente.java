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

@Table(name="g1_prop_attente")
@Entity 
@JsonIgnoreProperties({"hibernateLazyInitializer"})
@PrimaryKeyJoinColumn(name="id_prop")
public class ProprietaireAttente extends PersonneAttente {

	
//	@OneToMany(mappedBy = "gerant")
//	@Exclude
//	@JsonIgnore
//    private List<Questions> listeQuestions;

    public ProprietaireAttente() {
		super();
	}
	public ProprietaireAttente(int id, String nom, String prenom, String login, String mdp, String mail) {
		super(id, nom, prenom, login, mdp, mail);
	}

}