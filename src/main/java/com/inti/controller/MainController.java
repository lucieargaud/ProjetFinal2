package com.inti.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.inti.model.Utilisateur;
import com.inti.repository.IUtilisateurRepository;

@Controller
public class MainController {

	@Autowired
	IUtilisateurRepository iur;
	
	@GetMapping("accueil")
	public String accueil() 
	{
		return "accueil";
	}	
	
	@GetMapping("login")
	public String login() 
	{
		return "login";
	}	
	
	@GetMapping("inscription")
	public String inscription()
	{
		return "inscriptionUtilisateur";
	}
	
	@PostMapping("inscription")
	public String inscriptionSQL(@ModelAttribute("utilisateur") Utilisateur u)
	{
		BCryptPasswordEncoder b = new BCryptPasswordEncoder();
		u.setMdp(b.encode(u.getMdp()));
		iur.save(u);
		return "redirect:/accueil";
	}
}
