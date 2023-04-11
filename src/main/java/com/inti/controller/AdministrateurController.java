package com.inti.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.inti.model.AdminAttente;
import com.inti.model.Administrateur;
import com.inti.model.Utilisateur;
import com.inti.model.UtilisateurAttente;
import com.inti.model.Proprietaire;
import com.inti.model.ProprietaireAttente;
import com.inti.repository.IAdminAttenteRepository;
import com.inti.repository.IAdministrateurRepository;
import com.inti.repository.IUtilisateurAttenteRepository;
import com.inti.repository.IUtilisateurRepository;
import com.inti.repository.IProprietaireAttenteRepository;
import com.inti.repository.IProprietaireRepository;
import com.inti.repository.INoteRepository;
import com.inti.repository.IEspaceExpRepository;

@RestController
@RequestMapping("admin")
public class AdministrateurController {

	@Autowired
	IAdministrateurRepository iar;
	
	@Autowired
	IAdminAttenteRepository iaar;
	
	@Autowired
	IUtilisateurRepository icr;
	
	@Autowired
	IUtilisateurAttenteRepository icar;
	
	@Autowired
	IProprietaireRepository igr; 
	
	@Autowired
	IProprietaireAttenteRepository igar; 
	
	@Autowired
	INoteRepository inr;
	
	
	// Client
	@PostMapping("ajouterClient")
	public UtilisateurAttente inscriptionClient(@RequestBody UtilisateurAttente c)
	{
		return icar.save(c);
	}
	 
	@GetMapping("getClientsAttente")
	public List<UtilisateurAttente> getClientsAttente()
	{
		return icar.findAll();
	}
	
	@DeleteMapping("deleteClientAttente/{id}")
	public void deleteClientAttente(@PathVariable("id") int id)
	{
		icar.deleteById(id);
	}
	
    // Validation du compte client
	@PostMapping("validerClient")
	public void validerClientAttente(@RequestBody Utilisateur c)
	{
		icr.save(c);
	}
	
	@GetMapping("getClientsValide")
	public List<Utilisateur> getClients()
	{
		return icr.findAll();
	}
	
	@GetMapping("getClientById/{id}")
	public Utilisateur getClientById(@PathVariable("id") int id)
	{
		return icr.getReferenceById(id);
	}
	
	@DeleteMapping("deleteClientValide/{id}")
	public void deleteClient(@PathVariable("id") int id)
	{
		icr.deleteById(id);
	}
	
	@PutMapping("updateClient")
	public void updateClient(@RequestBody Utilisateur c)
	{
		icr.save(c);
	}
	
	// Admin
	@PostMapping("ajouterAdmin")
	public AdminAttente inscriptionAdmin(@RequestBody AdminAttente a)
	{
		return iaar.save(a);
	}

	@GetMapping("getAdminsAttente")
	public List<AdminAttente> getAdminsAttente()
	{
		return iaar.findAll();
	}
	
	@DeleteMapping("deleteAdminAttente/{id}")
	public void deleteAdminAttente(@PathVariable("id") int id)
	{
		iaar.deleteById(id);
	}
	
	 // Validation du compte admin	
	@PostMapping("validerAdmin")
	public void validerAdminAttente(@RequestBody Administrateur a)
	{
		iar.save(a);
	}
	
	@GetMapping("getAdminValide")
	public List<Administrateur> getAdmins()
	{
		return iar.findAll();
	}
	
	@GetMapping("getAdminById/{id}")
	public Administrateur getAdminById(@PathVariable("id") int id)
	{
		return iar.getReferenceById(id);
	}
	
	@DeleteMapping("deleteAdminValide/{id}")
	public void deleteAdmin(@PathVariable("id") int id)
	{
		iar.deleteById(id);
	}
	@PutMapping("updateAdmin")
	public void updateAdmin(@RequestBody Administrateur a)
	{
		iar.save(a);
	}

	
	// Gerant
	@PostMapping("ajouterGerant")
	public ProprietaireAttente inscriptionGerant(@RequestBody ProprietaireAttente g)
	{
			
		return igar.save(g);
	}
		
	@GetMapping("getGerantsAttente")
	public List<ProprietaireAttente> getGerantsAttente()
	{
		return igar.findAll();
	}
	
	@DeleteMapping("deleteGerantAttente/{id}")
	public void deleteGerantAttente(@PathVariable("id") int id)
	{
		igar.deleteById(id);
	}
	
	 // Validation du compte admin
	@PostMapping("validerGerant")
	public void validerGerantAttente(@RequestBody Proprietaire g)
	{
		igr.save(g);
	}

	@GetMapping("getGerantsValide")
	public List<Proprietaire> getGerants()
	{
		return igr.findAll();
	}
	
	@GetMapping("getGerantById/{id}")
	public Proprietaire getGerantById(@PathVariable("id") int id)
	{
		return igr.getReferenceById(id);
	}
		
	@DeleteMapping("deleteGerantValide/{id}")
	public void deleteGerant(@PathVariable("id") int id)
	{
		igr.deleteById(id);
	}
	
	@PutMapping("updateGerant")
	public void updateGerant(@RequestBody Proprietaire g)
	{
		igr.save(g);
	}
	
	// Statistiques
	
	@GetMapping("moyenneNotes")
	public double moyenneNotes() {
	
		double moy = inr.moyenneNotes();
		System.out.println("Moyenne notes "+ moy);
		return moy;
	}
	
	@GetMapping("nombreClients")
	public long nombreClient()
	{
		long n=icr.count();
		System.out.println("Nombre clients " + n);
		return n;
	}
	

}
