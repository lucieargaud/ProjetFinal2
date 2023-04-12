package com.inti.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.inti.model.Artiste;
import com.inti.model.Utilisateur;
import com.inti.repository.IArtisteRepository;
import com.inti.repository.IUtilisateurRepository;

@Controller
@RequestMapping("artiste")
public class ArtisteController {
	
	@Autowired
	IArtisteRepository iar;
		
	
	@GetMapping("inscription")
	public String inscription()
	{
		return "inscriptionArtiste";
	}
	
	@PostMapping("inscription")
	public String inscriptionSQL(@ModelAttribute("artiste") Artiste a)
	{
		BCryptPasswordEncoder b = new BCryptPasswordEncoder();
		a.setMdp(b.encode(a.getMdp()));
		iar.save(a);
		return "redirect:/accueil";
	}

}
