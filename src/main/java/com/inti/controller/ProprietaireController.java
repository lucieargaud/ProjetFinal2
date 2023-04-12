package com.inti.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.inti.model.EspaceExp;
import com.inti.repository.IUtilisateurRepository;
import com.inti.repository.IProprietaireRepository;
import com.inti.repository.IEspaceExpRepository;

@Controller
@RequestMapping("proprietaire")
public class ProprietaireController {
	@Autowired
	IUtilisateurRepository icr;
	@Autowired
	IEspaceExpRepository ier;
	@Autowired
	IProprietaireRepository ipr; 

	@GetMapping("createEspace")
	public String createEspace() {
		return "createEspaceForm";
	}
	@PostMapping("createEspace")
	public String ouvrirEspaceForm(@ModelAttribute ("espaceExp") EspaceExp espaceExp, @RequestParam("idP") int idP) {
		
		espaceExp.setProprietaire(ipr.getReferenceById(idP));
		ier.save(espaceExp);
		return "redirect:/acceuil";
	}
	
//	@GetMapping("createOeuvre")
//	public String createOeuvreForm() {
//		return "createOeuvreForm";
//	}
//
//	@PostMapping("createOeuvre")
//	public String createOeuvre(@ModelAttribute("oeuvre") Oeuvre o, @RequestParam("idConcert") int idC) {
//		Concert c = iconr.findById(idC).get();
//		o.setConcert(c);
////		List<Oeuvre> listOeuvre = c.getListOeuvres();
////		listOeuvre.add(o);
////		c.setListOeuvres(listOeuvre);
////		
////		System.out.println(listOeuvre);
//		ior.save(o);
////		iconr.save(c);
//
//		return "redirect:/createOeuvre";
//	}
	

}
