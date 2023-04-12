package com.inti.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.inti.model.Utilisateur;
import com.inti.model.Proprietaire;
import com.inti.model.Reclamation;
import com.inti.model.EspaceExp;
import com.inti.repository.IUtilisateurRepository;
import com.inti.repository.IProprietaireRepository;
import com.inti.repository.IReclamationRepository;
import com.inti.repository.IEspaceExpRepository;

@Controller
@RequestMapping("utilisateur")
public class UtilisateurController {

	@Autowired
	IUtilisateurRepository iur;
	@Autowired
	IEspaceExpRepository ier;
	@Autowired
	IProprietaireRepository ipr;
	@Autowired
	IReclamationRepository irr;

	@GetMapping("accueil")
	public String accueilClient() {
		return "accueil";
	}

	// Visualiser les détails des éléments (informations, prix) -> angular
	
	// Consulter la liste des espaces d'exposition
	@GetMapping("consulterAllEspExpo")
	public List<EspaceExp> getAllEspExpo(@PathVariable("id") int id) {
		try {
			System.out.println("Affichage des informations des espaces expo");
			return ier.findAll();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	// Consulter un espace d'exposition
	@GetMapping("consulterEspExpo/{id}")
	public EspaceExp getByIdEspExpo(@PathVariable("id") int id) {
		EspaceExp e1 = new EspaceExp();
		try {
			System.out.println("Affichage des informations d'un espace expo selon son id");
			e1=ier.getReferenceById(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return e1;
	}

	// La recherche des différents éléments dans un espace choisi-> angular
	
//	@GetMapping("getCommentairesOf/{id}")
//    public List<String> getCommentaire(@PathVariable("id")int id) {
//	try {
//		
//		System.out.println("Affichage des commentaires de l'espace expo " + id);
//		return ier.getReferenceById(id).getCommentaire();
//				} catch (Exception e) {
//		e.printStackTrace();
//	}
//	return null;
//}
	
	
	// CRUD Espace Exposition 
	@GetMapping("listeUtilisateur")
	public List<Utilisateur> listeUtilisateurs() {
		return iur.findAll();
	}

	@PostMapping("saveUtilisateur")
	public Utilisateur saveUtilisateur(@RequestBody Utilisateur c) {
		return iur.save(c);
	}

	@DeleteMapping("supprimerUtilisateur/{id}")
	public void supprimerUtilisateur(@PathVariable("id") int id) {
		iur.deleteById(id);
	}

	@PutMapping("modifierUtilisateur/{id}")
	public Utilisateur modifierUtilisateur(@RequestBody Utilisateur c) {
		return iur.save(c);
	}
	
	// Commenter
	
	// Signaler un espace 
	
	// Faire une réclammation
	@GetMapping("ajouterReclamation")
	public String reclammation() {
		return "ajouterReclamation";
	}
	
	@PostMapping("ajouterReclamation")
	public String saveReclamation(@ModelAttribute("reclamation") Reclamation r)
	{
		System.out.println(r);
		irr.save(r);
		return "redirect:/accueil";
	}
	
	
}