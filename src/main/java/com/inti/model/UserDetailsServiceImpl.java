package com.inti.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.inti.repository.IAdministrateurRepository;
import com.inti.repository.IArtisteRepository;
import com.inti.repository.IProprietaireRepository;
import com.inti.repository.IUtilisateurRepository;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	IAdministrateurRepository iadr;
	@Autowired
	IArtisteRepository iarr;
	@Autowired
	IProprietaireRepository ipr;
	@Autowired
	IUtilisateurRepository iur;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Administrateur admin = iadr.findByLogin(username);
		Artiste artiste = iarr.findByLogin(username);
		Proprietaire p = ipr.findByLogin(username);
		Utilisateur u = iur.findByLogin(username);
		
		if(admin!=null)
		{
			return User.withUsername(admin.getLogin())
				.password(admin.getMdp())
				.roles("ADMIN")
				.build();
		}
		else if(artiste!=null)
		{
			return User.withUsername(artiste.getLogin())
				.password(artiste.getMdp())
				.roles("ARTISTE")
				.build();
		}
		else if(p!=null)
		{
			return User.withUsername(p.getLogin())
				.password(p.getMdp())
				.roles("PROPRIETAIRE")
				.build();
		}
		else if(u!=null)
		{
			return User.withUsername(u.getLogin())
				.password(u.getMdp())
				.roles("UTILISATEUR")
				.build();
		}
		else
		{
			throw new UsernameNotFoundException("Le login : " + username + " n'existe pas en BDD");
		}
	}


	
}
