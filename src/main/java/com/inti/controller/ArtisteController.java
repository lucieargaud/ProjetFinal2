package com.inti.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.inti.model.Utilisateur;
import com.inti.repository.IArtisteRepository;

@RestController
@RequestMapping("artiste")
public class ArtisteController {

	@Autowired
	IArtisteRepository iar;
	
	
	@GetMapping("listeClients")
	public List<Utilisateur> listeClients()
	{
		return icr.findAll();
	}
	
	@PostMapping("saveClient")
	public Utilisateur saveClient(@RequestBody Utilisateur c)
	{
		return icr.save(c);
	}
	
	@DeleteMapping("supprimerClient/{id}")
	public void supprimerClient(@PathVariable("id") int id)
	{
		icr.deleteById(id);	
	}
	
	@PutMapping("modifierClient/{id}")
	public Utilisateur modifierClient(@RequestBody Utilisateur c)
	{
		return icr.save(c);
	}
}
