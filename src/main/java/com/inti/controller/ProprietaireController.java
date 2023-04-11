package com.inti.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.inti.model.Utilisateur;
import com.inti.model.Proprietaire;
import com.inti.model.EspaceExp;
import com.inti.repository.IUtilisateurRepository;
import com.inti.repository.IProprietaireRepository;
import com.inti.repository.IEspaceExpRepository;

@RestController
@RequestMapping("proprietaire")
public class ProprietaireController {
	@Autowired
	IUtilisateurRepository icr;
	@Autowired
	IEspaceExpRepository ior;
	@Autowired
	IProprietaireRepository igr; 

	@GetMapping("listeClients")
	public List<Utilisateur> listeClients() {
		List<Utilisateur> listeClients = icr.findAll();
		return listeClients;
	}

	@GetMapping("clientId/{id}")
	public Utilisateur clientId(@PathVariable("id") int id) {
		System.out.println("id : " + id);
		return icr.getReferenceById(id);
	}

	@GetMapping("listeOffres")
	public List<EspaceExp> listeOffres() {
		List<EspaceExp> listeOffres = ior.findAll();
		return listeOffres;
	}

	@GetMapping("offreId/{id}")
	public EspaceExp offreId(@PathVariable("id") int id) {
		System.out.println("id : " + id);
		return ior.getReferenceById(id);
	}

	@PostMapping("saveOffre")
	public EspaceExp saveOffre(@RequestBody EspaceExp o) {
		return ior.save(o);
	}

	@DeleteMapping("deleteOffre/{id}")
	public void deleteOffre(@PathVariable("id") int id) {
		ior.deleteById(id);
	}

	@PutMapping("updateOffre")
	public void updateOffre(@RequestBody EspaceExp o) {
		ior.save(o);
	}

//	@GetMapping("listePropositions/{idGerant}")
//	public List<EspaceExp> listePropositions(@PathVariable int idGerant) {
//		return igr.getReferenceById(idGerant).getListePropositionOffre();
//	}
//
//	@PutMapping("ajoutPropOffre/{idOffre}/{idGerant}")
//	public void ajoutPropositionOffre(@PathVariable int idOffre, @PathVariable int idGerant) {
//		Proprietaire g = igr.getReferenceById(idGerant);
//		EspaceExp o = ior.getReferenceById(idOffre);
//
//		System.out.println("Récupération du gérant " + g.getId() + "pour l'offre " + o.getId());
//		System.out.println("taille de la liste avant ajout : " + g.getListePropositionOffre().size());
//
//		g.getListePropositionOffre().add(o);
//		igr.save(g);
//
//		System.out.println("taille de la liste après ajout : " + g.getListePropositionOffre().size());
//		System.out.println("liste proposition après ajout" + g.getListePropositionOffre());
//	}
//
//	@DeleteMapping("deletePropOffre/{idOffre}/{idGerant}")
//	public void deletePropOffre(@PathVariable int idOffre, @PathVariable int idGerant) {
//		Proprietaire g = igr.getReferenceById(idGerant);
//		System.out.println("taille de la liste avant retrait : " + g.getListePropositionOffre().size());
//
//		g.getListePropositionOffre().remove(ior.getReferenceById(idOffre));
//		igr.save(g);
//
//		System.out.println("taille de la liste après retrait : " + g.getListePropositionOffre().size());
//	}
	
	
	@PostMapping("ajouterGerant")
	public Proprietaire inscriptionGerant(@RequestBody Proprietaire g)
	{
			
		return igr.save(g);
	}
		
	@GetMapping("getGerants")
	public List<Proprietaire> getGerants()
	{
	 return igr.findAll();
	}
}
